package com.springbootaop.springbootaop.service;

import org.springframework.stereotype.Service;

@Service
public class SecondMessageService {

    public void message(String param){
        System.out.println(param);
    }
}
