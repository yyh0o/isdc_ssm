package isdc.isdcssm.controller;


import isdc.isdcssm.dto.BaseResponse;
import isdc.isdcssm.service.AnnounceService;
import isdc.isdcssm.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Copyright (c) 2017 Peter Mao). All rights reserved.
 * Created by mao on 17-7-21.
 */
@RestController
@RequestMapping("intro/")
public class IntroController
{
    private final AnnounceService announceService;
    private final NoticeService noticeService;

    @Autowired
    public IntroController(AnnounceService announceService, NoticeService noticeService)
    {
        this.announceService = announceService;
        this.noticeService = noticeService;
    }

    @RequestMapping(value = "announce", method = RequestMethod.GET)
    public BaseResponse listAnnounce()
    {
        return BaseResponse.success(announceService.listAll());
    }

    @RequestMapping(value = "notice", method = RequestMethod.GET)
    public BaseResponse listNotice()
    {
        return BaseResponse.success(noticeService.listAll());
    }

    @RequestMapping(value = "suggest", method = RequestMethod.POST)
    public BaseResponse suggest()
    {
        return BaseResponse.error("Not implemented yet");
    }

}
