package isdc.isdcssm.controller;

import isdc.isdcssm.dto.BaseResponse;
import isdc.isdcssm.dto.Request.DownloadRequest;
import isdc.isdcssm.service.FileService;
import isdc.isdcssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

@RestController
@RequestMapping("file/")
public class FileController
{
    private final UserService userService;
    private final FileService fileService;

    @Autowired
    public FileController(UserService userService, FileService fileService)
    {
        this.userService = userService;
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public String Upload(@RequestParam("file") MultipartFile file, @Nullable @CookieValue(value = "accessToken") String accessToken) throws IOException
    {

        if (accessToken == null || accessToken.equals(""))
        {
            return "请先登录";
        }
        if (userService.isMember(accessToken))
        {
            String filePath = file.getOriginalFilename(); // 获取文件的名称
            filePath = fileService.getCurrentPath(accessToken) + filePath; // 这是文件的保存路径，如果不设置就会保存到项目的根目录
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath));
            outputStream.write(file.getBytes());
            outputStream.flush();
            outputStream.close();
            return "上传成功";
        }
        else
        {
            return "您无权上传";
        }
    }

    @GetMapping("/getFileList")
    public BaseResponse<String> getFileList(@CookieValue(value = "accessToken") String accessToken)
    {
        if (userService.adminAuth(accessToken))
        {
            return BaseResponse.success("data", fileService.queryAll());
        }
        else
        {
            return BaseResponse.error();
        }
    }

    @PostMapping(value = "download")
    public void Download(@RequestBody DownloadRequest request, HttpServletResponse response) throws IOException
    {
        InputStream inputStream = fileService.DownloadStream(request.getTimes(), request.getEmail());
        //InputStream inputStream = new FileInputStream(new File("/opt/documents/1/1.txt"));
        String filename = request.getEmail() + ".zip";
        filename = URLEncoder.encode(filename, "UTF-8");
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while ((len = inputStream.read()) != -1)
        {
            out.write(len);
            out.flush();
        }
        out.close();
        inputStream.close();
    }
}
