package com.hacisimsek.spring_security_with_jwt.services;

import com.hacisimsek.spring_security_with_jwt.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .map(user -> User.builder().username(user.getEmail())
                        .password(user.getPassword())
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}