package com.abdul.auth_service.controller.mapper;

import com.abdul.auth_service.controller.dto.UserInfo;
import com.abdul.auth_service.data.model.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserInfoMapper {

    UserInfoMapper INSTANCE = Mappers.getMapper(UserInfoMapper.class);

    UserInfo mapToUserInfo(AppUser appUser);
}
