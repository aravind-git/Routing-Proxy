package com.example.router.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.ProxyProvider;

@Configuration
public class WebClientConfig {

    @Value("${proxy.host}") // Configure these values in application.properties
    private String proxyHost;

    @Value("${proxy.port}")
    private int proxyPort;

    @Bean
    public WebClient.Builder webClientBuilder() {
        HttpClient httpClient = HttpClient.create()
                .proxy(proxy -> proxy.type(ProxyProvider.Proxy.HTTP)
                        .host(proxyHost)
                        .port(proxyPort));
        return WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient));
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
