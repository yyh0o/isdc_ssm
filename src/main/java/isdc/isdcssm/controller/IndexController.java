package isdc.isdcssm.controller;

import isdc.isdcssm.dto.BaseResponse;
import isdc.isdcssm.service.BannerService;
import isdc.isdcssm.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;

/**
 * Copyright (c) 2017 Peter Mao). All rights reserved.
 * Created by mao on 17-7-21.
 */
@RestController
@RequestMapping("")
public class IndexController {

    private final SemesterService semesterService;

    private final BannerService bannerService;

    @Autowired
    public IndexController(SemesterService semesterService, BannerService bannerService) {
        this.semesterService = semesterService;
        this.bannerService = bannerService;
    }

    @RequestMapping(value = "schedule", method = RequestMethod.GET)
    public BaseResponse listAnnounce() {
        return BaseResponse.success(semesterService.findSemesterByDate(new Date(System.currentTimeMillis())));
    }

    @RequestMapping(value = "banner", method = RequestMethod.GET)
    public BaseResponse listBanner() {
        return  BaseResponse.success( bannerService.findAll());
    }

}
