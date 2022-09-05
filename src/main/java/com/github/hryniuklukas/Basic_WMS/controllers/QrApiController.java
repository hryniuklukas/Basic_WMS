package com.github.hryniuklukas.Basic_WMS.controllers;

import com.github.hryniuklukas.Basic_WMS.services.QrApiService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qr")
public class QrApiController {
    QrApiService qrApiService;
    public QrApiController(QrApiService qrApiService){
        this.qrApiService = qrApiService;
    }
    @GetMapping(produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody byte[] getQR(@RequestParam String size, @RequestParam String data){
        return qrApiService.getQR(size, data);
    }
}
