package com.springboot.restclient.controller;

import com.springboot.restclient.service.ApiServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restclient.entity.Character;

@RestController
public class ApiController {
    private final ApiServiceImpl apiService;

    public ApiController(ApiServiceImpl apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/")
    public ResponseEntity<Character> getCharacters() {
        Character characters = apiService.getAllCharacter();
        return new ResponseEntity<>(characters, HttpStatus.OK);
    }
}
