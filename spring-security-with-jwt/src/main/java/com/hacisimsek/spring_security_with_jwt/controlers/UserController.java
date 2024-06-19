package com.hacisimsek.spring_security_with_jwt.controlers;

import com.hacisimsek.spring_security_with_jwt.model.User;
import com.hacisimsek.spring_security_with_jwt.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class UserController {
    private final UserRepository userRepository;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}