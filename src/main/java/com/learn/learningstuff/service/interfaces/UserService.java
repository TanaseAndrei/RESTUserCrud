package com.learn.learningstuff.service.interfaces;

import com.learn.learningstuff.dto.entities.AddUserDto;
import com.learn.learningstuff.dto.entities.DisplayUserDto;

import java.util.List;

public interface UserService {
    Long add(AddUserDto addUserDTO);

    DisplayUserDto get(Long id);

    List<DisplayUserDto> getAll();

    void delete(Long id);

    void update(Long id, AddUserDto addUserDTO);
}
