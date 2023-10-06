package com.aswebshop.demo.security.endpoint;

import com.aswebshop.demo.security.endpoint.dto.RegisterDTO;
import com.aswebshop.demo.security.logic.RegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("register")
@CrossOrigin(origins = "*")
public class RegisterEndpoint {
    private final RegisterService registerService;

    public RegisterEndpoint(RegisterService registerService) {
        this.registerService = registerService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public int register(@RequestBody RegisterDTO registration) {
        registerService.register(registration);
        //return ResponseEntity.status(HttpStatus.CREATED);
        return HttpStatus.CREATED.value();
    }

}
