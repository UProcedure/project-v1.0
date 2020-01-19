package com.weimin.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weimin
 * @ClassName StudentController
 * @Description TODO
 * @date 2020/1/7 16:03
 */
@Controller
@RequestMapping("student")
public class StudentController {

    @RequestMapping("test")
    public String test(){
        return "test";
    }

}
