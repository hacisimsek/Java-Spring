package com.springbootaop.springbootaop.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String mesajVer(String param){
        System.out.println("The function give param: " + param);
        return param;
    }
}
