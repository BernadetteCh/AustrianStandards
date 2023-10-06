package com.aswebshop.demo.security.logic;

import com.aswebshop.demo.security.data.User;
import com.aswebshop.demo.security.data.UserRepository;
import com.aswebshop.demo.security.endpoint.dto.RegisterDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(RegisterDTO registerDTO) {
        System.out.println(registerDTO + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        String encodedPassword = passwordEncoder.encode(registerDTO.password());
        User user = new User();
        user.setFirstName(registerDTO.firstName());
        user.setEmail(registerDTO.email());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }
}
