package com.abdul.auth_service.service.auth.user;

import com.abdul.auth_service.data.model.AppUser;

public interface UserService {
    AppUser getUserInfo(String userId);

    void changePassword(String userId, String oldPassword, String newPassword);

    AppUser updateName(String userId, String name);

    AppUser updateEmail(String userId, String email);
}
