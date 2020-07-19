package com.lrh.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EhcoController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/echo/{str}")
    public String echo(@PathVariable String str){
        return "Hello Nacos Discovery " + str+":"+serverPort;
    }
}
