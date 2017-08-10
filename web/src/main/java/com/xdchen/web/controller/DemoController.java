package com.xdchen.web.controller;

import com.xdchen.common.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    private IDemoService demoService;

    @RequestMapping(value = "/test", produces = "application/json; charset=utf-8")
    public String test(){
        return demoService.test();
    }
}
