package com.weimin.demo.controller;

import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.symmetric.AES;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.annotation.HttpConstraint;
import java.io.UnsupportedEncodingException;

/**
 * @author weimin
 * @ClassName TestController
 * @Description TODO
 * @date 2020/1/18 8:48
 */
@Controller
public class TestController {

    @RequestMapping("add")
    @ResponseBody //up?key="+key+"&iv="+iv+"&text="+x
    public String test(String key,String iv,String text) throws UnsupportedEncodingException {
        AES aes = new AES(Mode.CTR, Padding.PKCS5Padding,key.getBytes(),iv.getBytes());
        return aes.encryptHex(text);
    }

    @RequestMapping("up")
    @ResponseBody
    public String test2(String key,String iv,String text) throws UnsupportedEncodingException {
        AES aes = new AES(Mode.CTR, Padding.PKCS5Padding,key.getBytes(),iv.getBytes());
        byte[] s = aes.decrypt(text);
        return new String(s,"utf-8");
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }

}
