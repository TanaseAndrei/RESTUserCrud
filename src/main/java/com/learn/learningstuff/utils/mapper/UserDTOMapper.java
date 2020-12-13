package com.learn.learningstuff.utils.mapper;

import com.learn.learningstuff.dto.entities.AddUserDto;
import com.learn.learningstuff.dto.entities.DisplayUserDto;
import com.learn.learningstuff.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDTOMapper {

    public static User addUserDTOToUser(AddUserDto addUserDTO) {
        User user = new User();
        user.setCity(addUserDTO.getCity());
        user.setCountry(addUserDTO.getCountry());
        user.setEmail(addUserDTO.getEmail());
        user.setPassword(addUserDTO.getPassword());
        user.setUsername(addUserDTO.getUsername());
        return user;
    }

    public static DisplayUserDto userToDisplayUserDTO(User user) {
        DisplayUserDto displayUserDTO = new DisplayUserDto();
        displayUserDTO.setCity(user.getCity());
        displayUserDTO.setUsername(user.getUsername());
        displayUserDTO.setCountry(user.getCountry());
        displayUserDTO.setEmail(user.getEmail());
        return displayUserDTO;
    }

    public static List<DisplayUserDto> userListToUserDTOList(List<User> userList) {
        return userList
                .stream()
                .map(UserDTOMapper::createDisplayUserDto)
                .collect(Collectors.toList());
    }

    private static DisplayUserDto createDisplayUserDto(User user) {
        DisplayUserDto displayUserDTO = new DisplayUserDto();
        displayUserDTO.setEmail(user.getEmail());
        displayUserDTO.setUsername(user.getUsername());
        displayUserDTO.setCity(user.getCity());
        displayUserDTO.setCountry(user.getCountry());
        return displayUserDTO;
    }

    public static void replaceUserWithAddUserDTOFields(User user, AddUserDto addUserDTO){
        user.setUsername(addUserDTO.getUsername());
        user.setPassword(addUserDTO.getPassword());
        user.setEmail(addUserDTO.getEmail());
        user.setCountry(addUserDTO.getCountry());
        user.setCity(addUserDTO.getCity());
    }
}
