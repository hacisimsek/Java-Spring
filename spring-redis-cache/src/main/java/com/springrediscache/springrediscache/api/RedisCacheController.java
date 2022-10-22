package com.springrediscache.springrediscache.api;

import com.springrediscache.springrediscache.service.RedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RedisCacheController {

    private int sayac = 0;
    @Autowired
    private RedisCacheService redisCacheService;

    @GetMapping
    public String CacheControl() throws InterruptedException {
        if(sayac == 5){
            redisCacheService.clearCache();
            sayac = 0;
        }
        sayac++;
        return redisCacheService.longRunningMethod();
    }
}
