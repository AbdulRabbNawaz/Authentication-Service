package com.abdul.auth_service.service.auth;

import com.abdul.auth_service.service.auth.model.LoginRequest;
import com.abdul.auth_service.service.auth.model.SignUpRequest;

public interface AuthService {

    String signUp(SignUpRequest signUpRequest);

    String login(LoginRequest loginRequest);

    String verifyToken(String accessToken);
}
