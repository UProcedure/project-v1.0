package com.weimin.maintest;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.aspectj.weaver.ast.Var;
import org.hamcrest.Condition;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weimin
 * @ClassName ForEachTest
 * @Description TODO
 * @date 2020/1/3 14:34
 */
public class ForEachTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        Map<String,Object> map = new HashMap<>();
//        map.put("key","6becc7a720d7c3557d276dbc4c57a508");
//        map.put("address","中国");
//        map.put("city","中国");
//        map.put("output","json");
//        String s = HttpUtil.get("https://restapi.amap.com/v3/geocode/geo",map);
//        System.out.println(s);
////        System.out.println("==========================================================");
////        System.out.println(HttpUtil.get("https://restapi.amap.com/v3/geocode/geo?address=南山区&city=深圳市&output=json&key=6becc7a720d7c3557d276dbc4c57a508"));
//        System.out.println(JSONUtil.toBean((JSONObject) ((List) JSONUtil.toBean(s, Map.class).get("geocodes")).get(0),Map.class).get("location"));
//        String a = "";
//        String parent = (String) JSONUtil.toBean(a, Map.class).get("parent");
//        System.out.println(parent);
//        System.out.println(JSONUtil.toBean(parent, Map.class).get("dictionaryNo"));
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        System.out.println("iwww.maoblog.comi123.maoblog.com".getBytes(StandardCharsets.UTF_8).length);
        String keys = new String(key, CharsetUtil.CHARSET_UTF_8);
        keys = "";
        System.out.println("密钥====="+keys);
        AES aes = new AES(Mode.CTR, Padding.PKCS5Padding,"1234567890abcdefabcedf1234567890".getBytes(),"abcedf1234567890".getBytes());
        String abcs = aes.encryptHex("1234567890123456789012345678901234567890123456789012345678901234");
        System.out.println("加密后结果=="+abcs);
        byte[] s = aes.decrypt("d3329e9246a2538f7ad66c8b51ebcde6edc0b4afc8d820c5ac6e8821bbc67afef67123960bdd5c751d552450cc4e93db5470f2516f9d91d6efe1937733b89d4c");
        System.out.println("解密后结果=="+new String(s,"utf-8"));

    }
}
