package com.hacisimsek.auth_api.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash("cacheData")
public class CacheData {
    @Id
    private String key;

    @Indexed
    private String value;

    public CacheData() {
    }

    public CacheData(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public CacheData setKey(String key) {
        this.key = key;
        return this;
    }

    public String getValue() {
        return value;
    }

    public CacheData setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return "CacheData{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}