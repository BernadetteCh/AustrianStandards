package com.aswebshop.demo.security.endpoint;

import com.aswebshop.demo.security.UserPrincipal;
import com.aswebshop.demo.security.data.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageEndpoint {

    @GetMapping
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String unauthorized() {
        return "This message will never be displayed due to unauthorization";
    }

    @GetMapping("/authorized")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String authorized() {
        return "You are authorized to be here";
    }

    @GetMapping("/authorized/customized")
    @ResponseStatus(HttpStatus.ACCEPTED)
    String customized(Authentication authentication) {
        return authentication.getName();
    }
}
