package isdc.isdcssm.controller;

import isdc.isdcssm.dto.BaseResponse;
import isdc.isdcssm.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;


/**
 * Copyright (c) 2017 Peter Mao). All rights reserved.
 * Created by mao on 17-7-21.
 */
@RestController
@RequestMapping("blog/")
public class BlogController {

    private final BlogService blogService;


    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;

    }


    @GetMapping("list")
    public BaseResponse getBlogData() {
        blogService.updateBlogData();
        return BaseResponse.success(blogService.getAll());
    }
}
