package com.Controller;

import com.ErrorHandler.ApiResponse;
import com.Jwt.RefreshToken;
import com.Service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RefreshController {

    private final JwtService jwtService;

    @PostMapping("/refresh")
    public ApiResponse validateRefreshToken(@RequestBody RefreshToken bodyJson) {
        return jwtService.newAccessToken(bodyJson);

    }
}
