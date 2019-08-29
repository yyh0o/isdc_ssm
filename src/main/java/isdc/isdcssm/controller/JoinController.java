package isdc.isdcssm.controller;

import isdc.isdcssm.dto.BaseResponse;
import isdc.isdcssm.dto.Response.UserResponse;
import isdc.isdcssm.model.ApplicationForm;
import isdc.isdcssm.model.User;
import isdc.isdcssm.service.JoinService;
import isdc.isdcssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Copyright (c) 2017 Peter Mao. All rights reserved.
 * Created by mao on 17-9-10.
 */

@Controller
@RequestMapping("join/")
public class JoinController
{

    private final JoinService joinService;
    private final UserService userService;

    @Autowired
    public JoinController(JoinService joinService, UserService userService)
    {
        this.joinService = joinService;
        this.userService = userService;
    }

    @GetMapping("{openid}")
    public String join(@PathVariable String openid)
    {
        Optional<ApplicationForm> applicationForm = joinService.queryForm(openid);
        if (applicationForm.isPresent() && applicationForm.get().getName() != null)
        {
            return "success";
        }
        return "index";
    }

    @PostMapping("{openid}")
    public String submit(@PathVariable String openid, @RequestParam("name") String name, @RequestParam("stuId") Long stuId, @RequestParam("gender") String gender, @RequestParam("nationality") String nationality, @RequestParam("tel") Long tel, @RequestParam("email") String email, @RequestParam("introduce") String introduce, @RequestParam("description") String description)
    {
        Optional<ApplicationForm> optional = joinService.queryForm(openid);

        if (optional.isPresent() && optional.get().getName() == null)
        {
            ApplicationForm applicationForm = optional.get();
            applicationForm.setOpenid(openid);
            applicationForm.setDescription(description);
            applicationForm.setName(name);
            applicationForm.setIntroduce(introduce);
            applicationForm.setTel(tel);
            applicationForm.setEmail(email);
            applicationForm.setCreateDate(new Date());
            applicationForm.setStuId(stuId);
            applicationForm.setGender(gender);
            applicationForm.setNationality(nationality);
            joinService.submit(applicationForm);
            System.out.println("submit");
        }
        System.out.println("submit2");

        return "success";
    }

    @GetMapping("form")
    public BaseResponse<List<ApplicationForm>> listAllForms(@CookieValue(value = "accessToken") String accessToken) {
        System.out.println("get form");
        if (userService.adminAuth(accessToken)) {
            System.out.println("auth success");
            return BaseResponse.success(joinService.queryAll());
        } else {
            return BaseResponse.error();
        }
    }

    @PutMapping("form")
    public BaseResponse updateForm(@CookieValue(value = "accessToken") String accessToken, @RequestBody ApplicationForm form) {
        if (userService.adminAuth(accessToken)) {
            UserResponse user = userService.auth(accessToken);
            form.setInterviewer(user.getUserName());
            joinService.submit(form);
            return BaseResponse.success();
        } else {
            return BaseResponse.error();
        }
    }
}