package com.weimin.login.controller;

import com.weimin.common.vo.ResultBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author weimin
 * @ClassName LoginController
 * @Description TODO
 * @date 2020/1/2 17:05
 */
@Controller
public class LoginController {

    @RequestMapping("login")
    public ResultBean login(){
        return new ResultBean();
    }
}
