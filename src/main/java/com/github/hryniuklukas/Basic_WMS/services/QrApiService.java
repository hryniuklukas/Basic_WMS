package com.github.hryniuklukas.Basic_WMS.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class QrApiService {

    private final WebClient webClient;

    public QrApiService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://api.qrserver.com/v1/create-qr-code").build();
    }

    public byte[] getQR(String size, String data){
        return webClient
                .get()
                .uri("/?size={0}&data={1}",size,data)
                .retrieve()
                .bodyToMono(byte[].class).block();
    }
}
