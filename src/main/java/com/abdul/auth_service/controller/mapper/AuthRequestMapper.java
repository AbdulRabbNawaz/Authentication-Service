package com.abdul.auth_service.controller.mapper;

import com.abdul.auth_service.controller.dto.AuthRequest;
import com.abdul.auth_service.service.auth.model.LoginRequest;
import com.abdul.auth_service.service.auth.model.SignUpRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthRequestMapper {

    AuthRequestMapper INSTANCE = Mappers.getMapper(AuthRequestMapper.class);

     SignUpRequest mapToSignUpRequest(AuthRequest authRequest);

     LoginRequest mapToLoginRequest(AuthRequest authRequest);
}
