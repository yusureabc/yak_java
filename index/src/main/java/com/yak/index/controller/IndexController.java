package com.yak.index.controller;

import com.yak.index.model.Category;
import com.yak.index.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class IndexController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private CategoryService categoryService;

    @RequestMapping( "/" )
    public String index( Model model ) {
        List<Category> categories = categoryService.getCategoryList();
        model.addAttribute( "categories", categories );

        return "index";
    }



}
