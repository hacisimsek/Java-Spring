package com.springboot.restclient.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import com.springboot.restclient.entity.Character;

@Service
public class ApiServiceImpl implements ApiService {
    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;

    private static final String CHARACTER_API = "https://rickandmortyapi.com/api/character";

    public ApiServiceImpl(HttpHeaders httpHeaders, RestTemplate restTemplate) {
        this.httpHeaders = httpHeaders;
        this.restTemplate = restTemplate;
    }

    @Override
    public Character getAllCharacter() {

        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<Character> response = restTemplate.exchange(CHARACTER_API, HttpMethod.GET, entity, Character.class);

        return response.getBody();
    }
}
