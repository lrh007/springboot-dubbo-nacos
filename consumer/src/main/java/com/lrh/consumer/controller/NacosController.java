package com.lrh.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NacosController {

    @Autowired
    public LoadBalancerClient loadBalancerClient;
    @Autowired
    public RestTemplate restTemplate;
    @Value("${spring.application.name}")
    private String appName;
    @Value("${serve-url.nacos-user-service}")
    private String serverURL;

    @GetMapping("/echo/app-name")
    public String echoAppName(){
        //Access through the combination of LoadBalanceClient and RestTemplate
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider");
        String path = String.format("http://%s:%s/echo/%s",serviceInstance.getHost(),serviceInstance.getPort(),appName);
        System.out.println("request path:" +path);
        return restTemplate.getForObject(path,String.class);
    }
    @GetMapping("/echo/app-name2")
    public String echoAppName2(){
        return restTemplate.getForObject(serverURL+"/echo/"+appName,String.class);
    }


}
