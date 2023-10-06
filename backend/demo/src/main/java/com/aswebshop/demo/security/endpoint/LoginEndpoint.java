package com.aswebshop.demo.security.endpoint;

import com.aswebshop.demo.security.logic.JwtGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

@RestController
@RequestMapping("/login")
public class LoginEndpoint {
    private final JwtGenerator jwtGenerator;
    public LoginEndpoint(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @GetMapping
    String jwt (Authentication authentication) {
        return jwtGenerator.generate(authentication);
    }
}
