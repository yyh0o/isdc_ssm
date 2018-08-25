package isdc.isdcssm.controller;


import isdc.isdcssm.dto.BaseResponse;
import isdc.isdcssm.service.AnnounceService;
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

    @Autowired
    public IntroController(AnnounceService announceService)
    {
        this.announceService = announceService;
    }

    @RequestMapping(value = "announce", method = RequestMethod.GET)
    public BaseResponse listAnnounce()
    {
        return BaseResponse.success(announceService.listAll());
    }

    @RequestMapping(value = "suggest", method = RequestMethod.POST)
    public BaseResponse suggest()
    {
        return BaseResponse.error("Not implemented yet");
    }

}
