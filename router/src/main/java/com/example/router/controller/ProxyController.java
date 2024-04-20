package com.example.router.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProxyController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(path="/route")
    public String routeToProxy(){

        String destinationUrl = "https://catfact.ninja/fact";

        // You can customize the request method, headers, and body as needed
        return restTemplate.getForObject(destinationUrl, String.class);
    }
}
