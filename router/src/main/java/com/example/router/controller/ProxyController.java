package com.example.router.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.util.JSONPObject;

import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ProxyController {


    @Autowired
    RestTemplate restTemplate;

    @GetMapping(path="/route/{url}",produces= MediaType.APPLICATION_JSON_VALUE)
    public String routeToProxy(@PathVariable String url){

        String destinationUrl = "https://catfact.ninja/fact";

        // You can customize the request method, headers, and body as needed
        return restTemplate.getForObject(destinationUrl, String.class);
    }
}
