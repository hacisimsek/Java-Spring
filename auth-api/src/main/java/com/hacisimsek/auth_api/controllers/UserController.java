package com.hacisimsek.auth_api.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hacisimsek.auth_api.entities.CacheData;
import com.hacisimsek.auth_api.entities.User;
import com.hacisimsek.auth_api.repositories.CacheDataRepository;
import com.hacisimsek.auth_api.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/users")
@RestController
public class UserController {
    private final UserService userService;

    private final CacheDataRepository cacheDataRepository;

    private final ObjectMapper objectMapper;

    public UserController(UserService userService , CacheDataRepository cacheDataRepository, ObjectMapper objectMapper) {
        this.userService = userService;
        this.cacheDataRepository = cacheDataRepository;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/me")
    public ResponseEntity<User> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        return ResponseEntity.ok(currentUser);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> allUsers() {
        Optional<CacheData> optionalCacheData = cacheDataRepository.findById("allUsers");

        if (optionalCacheData.isPresent()) {
            String usersAsString = optionalCacheData.get().getValue();

            TypeReference<List<User>> mapType = new TypeReference<List<User>>() {};
            List<User> users = null;
            try {
                users = objectMapper.readValue(usersAsString, mapType);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

            return ResponseEntity.ok(users);
        }

        List <User> users = userService.allUsers();
        String usersAsString = null;
        try {
            usersAsString = objectMapper.writeValueAsString(users);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        CacheData cacheData = new CacheData("allUsers", usersAsString);

        cacheDataRepository.save(cacheData);

        return ResponseEntity.ok(users);
    }
}