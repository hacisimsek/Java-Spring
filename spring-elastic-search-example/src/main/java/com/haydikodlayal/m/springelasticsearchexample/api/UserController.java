package com.haydikodlayal.m.springelasticsearchexample.api;

import com.haydikodlayal.m.springelasticsearchexample.entity.User;
import com.haydikodlayal.m.springelasticsearchexample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    @PostConstruct
    public void init() {
        User user = new User();
        user.setName("haci");
        user.setSurname("simsek");
        user.setEmail("");
        user.setPassword("123456");
        userRepository.save(user);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<User>> getUsers(@PathVariable String search) {
        return ResponseEntity.ok(userRepository.findByNameOrSurnameLike(search, search));
    }

    @GetMapping("/custom/{search}")
    public ResponseEntity<List<User>> getUsersCustom(@PathVariable String search) {
        return ResponseEntity.ok(userRepository.findByNameOrSurnameOrEmailLike(search, search, search));
    }
}
