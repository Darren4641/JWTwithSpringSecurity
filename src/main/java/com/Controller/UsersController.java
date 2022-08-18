package com.Controller;

import com.ErrorHandler.ApiResponse;
import com.Model.Users;
import com.Repository.UsersRepository;
import com.Role.Role;
import com.Service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UsersController {

    private final PasswordEncoder passwordEncoder;

    private final UsersRepository usersRepository;

    private final JwtService jwtService;

    @PostMapping("/test")
    public String test(){
        return "<h1>test 통과</h1>";
    }

    @PostMapping("/join")
    public String signUp(@RequestBody Map<String, String> user) {
        Role role = Role.from(user.get("role"));
        return usersRepository.save(Users.builder()
                .id(user.get("id"))
                .password(passwordEncoder.encode(user.get("password")))
                .email(user.get("email"))
                .gender(user.get("gender"))
                .phone(user.get("phone"))
                .role(role)
                .roles(Collections.singletonList(role.getValue()))
                .build()).toString();
    }

    @PostMapping("/login")
    public ApiResponse login(HttpServletRequest request,  @RequestBody Map<String, String> user, @RequestHeader("User-Agent") String userAgent) {
        return jwtService.login(request, user, userAgent);
    }

}