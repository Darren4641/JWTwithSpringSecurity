package com.Controller;

import com.Jwt.JwtTokenProvider;
import com.Repository.BoardRepository;
import com.Service.JwtService;
import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletRequest;

@AllArgsConstructor
public abstract class Controller {

    private final BoardRepository boardRepository;
    private final JwtService jwtService;
    private final JwtTokenProvider jwtTokenProvider;


    public String getUserInfo(HttpServletRequest request) {
        String token = jwtTokenProvider.getAccessToken(request);
        return jwtTokenProvider.getUserPk(token);
    }


    protected BoardRepository getBoardRepository() {
        return boardRepository;
    }

    protected JwtService getJwtService() {
        return jwtService;
    }








}
