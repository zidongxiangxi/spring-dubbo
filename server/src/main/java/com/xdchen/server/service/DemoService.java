package com.xdchen.server.service;

import com.xdchen.common.service.IDemoService;

public class DemoService implements IDemoService {
    @Override
    public String test() {
        return "hello world!";
    }
}
