package isdc.isdcssm.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import isdc.isdcssm.dao.UserDAO;
import isdc.isdcssm.model.User;
import isdc.isdcssm.service.FileService;
import isdc.isdcssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;

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
        user.getEmail();
        return rootPath + getCurrentTime() + "/" + user.getEmail() + "/";
    }


    @Override
    public String queryAll()
    {
        try
        {
            File file = new File(rootPath);
            JSONObject jsonObject = new JSONObject();
            int number = 0;
            JSONObject jsonObject2 = new JSONObject();

            for (File temp : file.listFiles())
            {
                if (temp.isDirectory())//作业编号
                {
                    number++;
                    int number2 = 0;
                    JSONArray jsonArray2 = new JSONArray();
                    for (File temp2 : temp.listFiles())
                    {
                        if (temp2.isDirectory())//提交人邮箱
                        {
                            number2++;
                            int number3 = 0;
                            JSONArray jsonArray3 = new JSONArray();
                            for (File temp3 : temp2.listFiles())
                            {
                                if (temp3.isFile())
                                {
                                    number3++;
                                    jsonArray3.add(temp3.getName());
                                }
                            }
                            JSONObject jsonObject3 = new JSONObject();
                            jsonObject3.put("number", number3);
                            jsonObject3.put(temp2.getName(), jsonArray3);
                            jsonArray2.add(jsonObject3);
                        }
                    }
                    jsonObject2.put("number", number2);
                    jsonObject2.put(temp.getName(), jsonArray2);
                }
            }
            jsonObject.put("number", number);
            jsonObject.put("data", jsonObject2);
            return jsonObject.toString();
        }
        catch (Exception e)
        {
            return null;
        }
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
}
