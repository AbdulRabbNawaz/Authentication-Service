package com.abdul.auth_service.controller;

import com.abdul.auth_service.constant.LoggingConstants;
import com.abdul.auth_service.controller.dto.ChangePasswordRequest;
import com.abdul.auth_service.controller.dto.UserDetails;
import com.abdul.auth_service.controller.dto.UserInfo;
import com.abdul.auth_service.controller.mapper.UserInfoMapper;
import com.abdul.auth_service.service.auth.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // Get user info
    @GetMapping("/{userId}")
    public ResponseEntity<UserInfo> getUserInfo(@PathVariable String userId){
        var methodName = "UserController:getUserInfo";
        log.info(LoggingConstants.START_METHOD_LOG, methodName, userId);

        var appUser = userService.getUserInfo(userId);

        log.info(LoggingConstants.END_METHOD_LOG, methodName);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(UserInfoMapper.INSTANCE.mapToUserInfo(appUser));
    }

    // Change password
    @PostMapping("/{userId}/change-password")
    public ResponseEntity<Void> changePassword(
            @PathVariable String userId,
            @RequestBody ChangePasswordRequest changePasswordRequest
    ){
        var methodName = "UserController:changePassword";
        log.info(LoggingConstants.START_METHOD_LOG, methodName, userId);

        userService.changePassword(
                userId,
                changePasswordRequest.getOldPassword(),
                changePasswordRequest.getNewPassword()
        );

        log.info(LoggingConstants.END_METHOD_LOG, methodName);

        return ResponseEntity
                .ok()
                .build();
    }

    // update user details
    @PostMapping("/{userId}/")
    public ResponseEntity<UserInfo> updateUserDetails(
            @PathVariable String userId,
            @RequestBody UserDetails userDetails
    ){
        var methodName = "UserController:changePassword";
        log.info(LoggingConstants.START_METHOD_LOG, methodName, userId);

        var appUser = switch(userDetails.getRequestType()){
            case UPDATE_EMAIL -> userService.updateEmail(userId, userDetails.getEmail());
            case UPDATE_NAME -> userService.updateName(userId, userDetails.getName());
        };

        log.info(LoggingConstants.END_METHOD_LOG, methodName);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(UserInfoMapper.INSTANCE.mapToUserInfo(appUser));
    }
}
