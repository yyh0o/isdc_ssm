package isdc.isdcssm.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import isdc.isdcssm.dao.UserDAO;
import isdc.isdcssm.model.User;
import isdc.isdcssm.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
@Transactional
public class FileServiceImpl implements FileService
{
    private static String rootPath = "/opt/documents/";
    private final UserDAO userDAO;

    @Autowired
    public FileServiceImpl(UserDAO userDA)
    {
        this.userDAO = userDA;
    }

    @Override
    public String getRootPath()
    {
        return rootPath;
    }

    @Override
    public String getCurrentPath(String accessToken)
    {
        User user = userDAO.selectByAccessToken(accessToken);
        String ret = rootPath + getCurrentTime() + "/" + user.getEmail() + "/";
        File file = new File(ret);
        if(!file.exists()) file.mkdir();
        return ret;
    }

    private File[] getSortFiles(File file)
    {
        File[] files = file.listFiles();
        Arrays.sort(files, new Comparator<File>()
        {
            @Override
            public int compare(File o1, File o2)
            {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return files;
    }

    @Override
    public String queryAll()
    {
        try
        {
            File file = new File(rootPath);
            JSONArray ret = new JSONArray();
            for (File times : getSortFiles(file))
            {
                if (times.isDirectory())
                {
                    JSONObject jsonObject = new JSONObject();
                    JSONArray user_array = new JSONArray();
                    for (File user : times.listFiles())
                    {
                        if (user.isDirectory())
                        {
                            JSONObject user_object = new JSONObject();
                            JSONArray file_array = new JSONArray();
                            for (File files : user.listFiles())
                            {
                                if (files.isFile())
                                {
                                    file_array.add(files.getName());
                                }
                            }
                            user_object.put("name", user.getName());
                            user_object.put("files", file_array);
                            user_array.add(user_object);
                        }
                    }
                    jsonObject.put("name", times.getName());
                    jsonObject.put("files", user_array);
                    ret.add(jsonObject);
                }
            }

            return ret.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public InputStream DownloadStream(String times, String email)
    {
        String path = rootPath + times + "/" + email;
        String outputpath = rootPath + times + "/" + email + ".zip";
        File file = new File(outputpath);
        if(file.exists()) file.delete();
        compress(path, outputpath);
        try
        {
            InputStream bis = new BufferedInputStream(new FileInputStream(new File(outputpath)));
            return bis;
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }


    private String getCurrentTime()
    {
        File file = new File(rootPath);
        int ret = 1;
        for (File temp : file.listFiles())
        {
            if (temp.isDirectory())
            {
                if (Integer.parseInt(temp.getName()) > ret)
                    ret = Integer.parseInt(temp.getName());
            }
        }
        return String.valueOf(ret);
    }

    public static void compress(String srcFilePath, String destFilePath)
    {
        File src = new File(srcFilePath);

        if (!src.exists())
        {
            throw new RuntimeException(srcFilePath + "不存在");
        }
        File zipFile = new File(destFilePath);

        try
        {

            FileOutputStream fos = new FileOutputStream(zipFile);
            ZipOutputStream zos = new ZipOutputStream(fos);
            String baseDir = "";
            compressbyType(src, zos, baseDir);
            zos.close();

        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }

    private static void compressbyType(File src, ZipOutputStream zos, String baseDir)
    {

        if (!src.exists())
            return;
        System.out.println("压缩路径" + baseDir + src.getName());
        //判断文件是否是文件，如果是文件调用compressFile方法,如果是路径，则调用compressDir方法；
        if (src.isFile())
        {
            //src是文件，调用此方法
            compressFile(src, zos, baseDir);

        }
        else if (src.isDirectory())
        {
            //src是文件夹，调用此方法
            compressDir(src, zos, baseDir);

        }

    }

    /**
     * 压缩文件
     */
    private static void compressFile(File file, ZipOutputStream zos, String baseDir)
    {
        if (!file.exists())
            return;
        try
        {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            ZipEntry entry = new ZipEntry(baseDir + file.getName());
            zos.putNextEntry(entry);
            int count;
            byte[] buf = new byte[1024];
            while ((count = bis.read(buf)) != -1)
            {
                zos.write(buf, 0, count);
            }
            bis.close();

        }
        catch (Exception e)
        {
            // TODO: handle exception

        }
    }

    /**
     * 压缩文件夹
     */
    private static void compressDir(File dir, ZipOutputStream zos, String baseDir)
    {
        if (!dir.exists())
            return;
        File[] files = dir.listFiles();
        if (files.length == 0)
        {
            try
            {
                zos.putNextEntry(new ZipEntry(baseDir + dir.getName() + File.separator));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        for (File file : files)
        {
            compressbyType(file, zos, baseDir + dir.getName() + File.separator);
        }
    }
}
