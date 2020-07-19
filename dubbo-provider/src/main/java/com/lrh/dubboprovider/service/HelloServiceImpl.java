package com.lrh.dubboprovider.service;

import org.apache.dubbo.config.annotation.DubboService;
import service.HelloService;

@DubboService
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        return "provider say hello "+name;
    }
}
