package com.yak.index.controller;

import com.yak.index.model.Category;
import com.yak.index.model.Website;
import com.yak.index.service.CategoryService;
import com.yak.index.service.WebsiteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class IndexController {
    private Logger logger = LoggerFactory.getLogger( this.getClass() );

    @Resource
    private CategoryService categoryService;

    @Resource
    private WebsiteService websiteService;

    @RequestMapping( "/" )
    public String index( Model model ) {
        List< Category > categories = categoryService.getCategoryList();
        List< Website > websites = websiteService.getWebsiteList();


        Map< Integer, List< Website > > map = new HashMap<>();
        websites.forEach( website -> {
            List< Website > item = map.get( website.getCategoryId() );
            if ( CollectionUtils.isEmpty( item ) ) {
                item = new ArrayList<>();
            }
            item.add( website );
            map.put( website.getCategoryId(), item );
        } );

        model.addAttribute( "categories", categories );
        model.addAttribute( "websites", map );

        return "index";
    }



}
