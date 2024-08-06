package com.example.techeazy.student_management_system.mapper;

import com.example.techeazy.student_management_system.dto.UserDto;
import com.example.techeazy.student_management_system.model.ERole;
import com.example.techeazy.student_management_system.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static UserDto mapUserToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getUsername());
        userDto.setPassword("******");
        userDto.setRoles(getRolesList(user));
        return userDto;
    }

    private static List<String> getRolesList(User user) {
        List<ERole> roles = new ArrayList<>();
        user.getRoles().forEach(role -> {
            roles.add(role.getName());
        });

        List<String> rolesList = new ArrayList<>();
        roles.forEach(role -> {
            rolesList.add(role.toString().substring(5).toLowerCase());
        });
        return rolesList;
    }
}
