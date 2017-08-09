package com.xdchen.web.service;

import com.xdchen.common.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private IDemoService demoService;
}
