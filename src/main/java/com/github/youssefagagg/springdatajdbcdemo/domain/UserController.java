package com.github.youssefagagg.springdatajdbcdemo.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserOtpRepository userOtpRepository;

    @GetMapping("/users")
    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }
    @PostMapping("/users")
    public User createUser(@RequestParam String name){
        var user = User.builder()
                .authorities(Set.of(new Authority("ROLE_USER")))
                .name(name)
                .fileExtensions(List.of(FileExtension.PDF,FileExtension.PNG))
                .build();

        return userRepository.save(user);
    }
    @PostMapping("/otp")
    public UserOtp generateOtp(@RequestParam Long userId, String otp){
        var user = userRepository.findById(userId).orElseThrow();

        var userOtp= UserOtp.builder()
                .otp(otp)
                .user(AggregateReference.to(userId))
                .build();
        return userOtpRepository.save(userOtp);
    }
    @GetMapping("/otp")
    public UserOtp getOtpByUser(@RequestParam Long userId){
        return userOtpRepository.findFirstByUser(userId).orElse(null);
    }
    @GetMapping("/user-from-otp")
    public User geUserByOtp(@RequestParam Long userId){
        var otp= userOtpRepository.findFirstByUser(userId).orElseThrow();
        return userRepository.findById(otp.user().getId()).orElseThrow();
    }

}
