package com.springrediscache.springrediscache.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {

   @Cacheable("longRunningMethod")
    public String longRunningMethod() throws InterruptedException {
        Thread.sleep(5000L);
        return "Hello World";
    }

    @CacheEvict("longRunningMethod")
    public void clearCache() {
        System.out.println("Cache cleared");
    }
}
