package isdc.isdcssm.controller;


import isdc.isdcssm.dto.BaseResponse;
import isdc.isdcssm.dto.Response.UserResponse;
import isdc.isdcssm.job.AccessTokenJob;
import isdc.isdcssm.model.ApplicationForm;
import isdc.isdcssm.service.JoinService;
import isdc.isdcssm.service.UserService;
import isdc.isdcssm.service.WechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import weixin.popular.bean.message.EventMessage;
import weixin.popular.bean.xmlmessage.XMLNewsMessage;
import weixin.popular.bean.xmlmessage.XMLTextMessage;
import weixin.popular.util.XMLConverUtil;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Copyright (c) 2017 Peter Mao). All rights reserved.
 * Created by mao on 17-7-21.
 */
@RestController
@RequestMapping("wechat/")
public class WeChatController {
    private final WechatService wechatService;
    private final UserService userService;
    private final JoinService joinService;

    @Autowired
    public WeChatController(WechatService wechatService, UserService userService, JoinService joinService) {
        this.wechatService = wechatService;
        this.userService = userService;
        this.joinService = joinService;
    }

    @RequestMapping(value = "notify")
    public String onMessageReceived(@RequestBody(required = false) String data, @RequestParam("signature") String signature, @RequestParam("timestamp") String timestamp, @RequestParam("nonce") String nonce, @RequestParam(value = "echostr", required = false) String echostr) {

        if (wechatService.checkSignature(timestamp, nonce, signature)) {
            if (echostr != null)
                return echostr;
            if (data != null) {
                EventMessage eventMessage = XMLConverUtil.convertToObject(EventMessage.class, data);
                if (eventMessage.getEvent() != null && eventMessage.getEvent().equals("subscribe")) {
                    return new XMLTextMessage(eventMessage.getFromUserName(), eventMessage.getToUserName(), "非常感谢您关注isdc公众订阅号“进退之间”。。社团官网：https://www.scuisdc.org ，社团微博：http://weibo.com/scuisdc。同时您可以直接输入任何意见、建议或者问题，我们将会在一天之内给您回复！再次感谢您的关注！回复【报名】开始填写报名表！报名成功后回复【面试】获取后续面试安排").toXML();
                }
                if (eventMessage.getContent().contains("报名")) {
                    String openid = eventMessage.getFromUserName();
                    wechatService.saveOpenid(openid);
                    XMLNewsMessage.Article t = new XMLNewsMessage.Article();
                    t.setDescription("欢迎你的加入！");
                    t.setPicurl("http://7xq5uu.com1.z0.glb.clouddn.com/images_want.jpg");
                    t.setTitle("ISDC招新报名表");
                    t.setUrl("https://www.scuisdc.org/api/join/" + eventMessage.getFromUserName());
                    XMLNewsMessage xmlNewsMessage = new XMLNewsMessage(
                            eventMessage.getFromUserName(),
                            eventMessage.getToUserName(),
                            Collections.singletonList(
                                    t));
                    return xmlNewsMessage.toXML();
                } else if (eventMessage.getContent().contains("面试")) {
                    String openid = eventMessage.getFromUserName();
                    Optional<ApplicationForm> applications = joinService.queryForm(openid);
                    String msg = "";
                    if (!applications.isPresent())
                        msg = "查询不到您的报名！";
                    else {
                        Date date = applications.get().getInterview();
                        if (date == null)
                            msg = "正在安排您的面试时间，请耐心等待！";
                        else
                            msg = String.format("您的面试时间是：%s，面试地点为二基楼B座405教室，请准时到场！时间安排如有冲突请私戳管理员", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date));
                    }
                    return new XMLTextMessage(eventMessage.getFromUserName(), eventMessage.getToUserName(), msg).toXML();
                }
                return new XMLTextMessage(eventMessage.getFromUserName(), eventMessage.getToUserName(), "我们已经收到了您的消息，将会在24小时内作出回复。回复【报名】开始填写报名表，报名成功后回复【面试】获取后续面试安排").toXML();
            }
        }
        return echostr;
    }

    @GetMapping(value = "token")
    public String getToken() {

        return AccessTokenJob.access_token;
    }

    @GetMapping("form")
    public BaseResponse<List<ApplicationForm>> listAllForms(@CookieValue(value = "accessToken") String accessToken) {
        if (userService.adminAuth(accessToken)) {
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
