package com.yak.index.service.impl;

import com.yak.index.model.Website;
import com.yak.index.repository.WebsiteRepository;
import com.yak.index.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("websiteService")
public class WebsiteServiceImpl implements WebsiteService {

    @Autowired
    private WebsiteRepository websiteRepository;

    @Override
    public List<Website> getWebsiteList() {
        return websiteRepository.findAll();
    }

}
