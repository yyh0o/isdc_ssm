package isdc.isdcssm.controller;

import isdc.isdcssm.dto.BaseResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/")
public class userController {

    @GetMapping("test")
    public BaseResponse test(){
        return BaseResponse.success("成功");
    }
}
