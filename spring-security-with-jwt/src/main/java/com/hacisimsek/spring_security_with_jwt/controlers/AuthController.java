package com.hacisimsek.spring_security_with_jwt.controlers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.hacisimsek.spring_security_with_jwt.model.LoginRequest;
import com.hacisimsek.spring_security_with_jwt.model.RegisterRequest;
import com.hacisimsek.spring_security_with_jwt.services.AuthService;

@RestController
@RequestMapping(path = "api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping(path = "/register")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void register(@RequestBody RegisterRequest registerRequest) {
        authService.register(registerRequest);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }
}
