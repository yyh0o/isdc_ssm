package isdc.isdcssm.controller;

import isdc.isdcssm.dto.BaseResponse;

import isdc.isdcssm.dto.Request.LoginRequest;
import isdc.isdcssm.dto.Request.SignUpRequest;
import isdc.isdcssm.dto.Response.UserResponse;
import isdc.isdcssm.model.User;
import isdc.isdcssm.service.UserService;
import isdc.isdcssm.support.Authorization;
import isdc.isdcssm.support.CurrentUser;
import isdc.isdcssm.support.VerifyCodeUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.RandomStringUtils;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("user/")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @PostMapping(value = "register")
    public BaseResponse signUp(@RequestBody SignUpRequest request, HttpSession session) {
        if (session.getAttribute("_code") != null && session.getAttribute("_code").equals(request.getCheckCode())) {
            User user = new User();
            user.setEmail(request.getEmail());
            user.setUserName(request.getUserName());
            user.setPassword(request.getPassword());
            user.setEnabled(true);
            user.setIsRoot(false);
            if (userService.signUp(user)) {
                return BaseResponse.success("注册成功");
            }
            return BaseResponse.badrequest("注册失败");
        } else {
            return BaseResponse.badrequest("验证码错误");
        }
    }


    @PostMapping(value = "auth")
    public BaseResponse login(@RequestBody LoginRequest request, HttpSession session) {
        if (session.getAttribute("_code") != null && session.getAttribute("_code").equals(request.getCheckCode())) {
            UserResponse user = userService.login(request.getEmail(), request.getPassword());
            if (user != null) {
                return BaseResponse.success(user);
            }
            return BaseResponse.badrequest("用户不存在或密码错误");
        } else {
            return BaseResponse.badrequest("验证码错误");
        }
    }

    @GetMapping(value = "auth")
    @Authorization
    public BaseResponse login(@CurrentUser User user) {
        return BaseResponse.success(modelMapper.map(user, UserResponse.class));
    }


    @GetMapping(value = "authCode")
    public void getAuthCode(HttpSession session, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");
        String verifyCode = RandomStringUtils.randomNumeric(4);
        session.setAttribute("_code", verifyCode);
        VerifyCodeUtils.outputImage(80, 50, response.getOutputStream(), verifyCode);
    }
}
