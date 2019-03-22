package com.yak.index.modules.yak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {

    @RequestMapping( value = "/" )
    public String index() {

         /*TODO: 查找所有分类，按照 sort 字段排序

         TODO: 循环查找 website 数据，将 website 数据作为子集

         TODO: 渲染数据到前台 */



        return "index";
    }



}
