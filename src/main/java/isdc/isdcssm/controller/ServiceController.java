package isdc.isdcssm.controller;


import isdc.isdcssm.dto.BaseResponse;
import isdc.isdcssm.dto.Request.CalScoreRequest;
import isdc.isdcssm.model.ScoreRequest;
import isdc.isdcssm.service.JWCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.util.Date;

/**
 * Copyright (c) 2017 Peter Mao). All rights reserved.
 * Created by mao on 17-7-21.
 */
@RestController
@RequestMapping("service/")
public class ServiceController {
    private final JWCService jwcService;

    @Autowired
    public ServiceController(JWCService jwcService) {
        this.jwcService = jwcService;
    }

    @RequestMapping(value = "jwc/score", method = RequestMethod.POST)
    public BaseResponse calScore(@RequestBody CalScoreRequest request) throws IOException {
        ScoreRequest scoreRequest = new ScoreRequest(request.getZjh(), request.getMm());
        scoreRequest.setComplete(false);
        scoreRequest.setDate(new Date());
        jwcService.addRequest(scoreRequest);
        jwcService.getScore(scoreRequest);
        return  BaseResponse.success("正在连接教务处……");
    }


    @RequestMapping(value = "jwc/score/result", method = RequestMethod.POST)
    public BaseResponse getScoreResult(@RequestBody CalScoreRequest request) {
        ScoreRequest scoreRequest = jwcService.findRequest(request.getZjh(), request.getMm(), request.getDate());
        if (scoreRequest != null) {
            return BaseResponse.success(scoreRequest);
        }
        return BaseResponse.error("查询失败");
    }
}
