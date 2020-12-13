package com.learn.learningstuff.service.implementations;

import com.learn.learningstuff.dto.entities.AddUserDto;
import com.learn.learningstuff.dto.entities.DisplayUserDto;
import com.learn.learningstuff.exception.exceptions.AlreadyExistsException;
import com.learn.learningstuff.exception.exceptions.NotFoundException;
import com.learn.learningstuff.model.User;
import com.learn.learningstuff.repository.UserRepository;
import com.learn.learningstuff.service.interfaces.UserService;
import com.learn.learningstuff.utils.mapper.UserDTOMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final String NOT_FOUND_MESSAGE = "The user has not been found";

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long add(AddUserDto addUserDTO) {
        makeValidations(addUserDTO);
        User user = UserDTOMapper.addUserDTOToUser(addUserDTO);
        return userRepository.save(user).getId();
    }

    @Override
    public DisplayUserDto get(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException(NOT_FOUND_MESSAGE));
        return UserDTOMapper.userToDisplayUserDTO(user);
    }

    @Override
    public List<DisplayUserDto> getAll() {
        List<User> userList = userRepository.findAll();
        return UserDTOMapper.userListToUserDTOList(userList);
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException(NOT_FOUND_MESSAGE));
        userRepository.delete(user);
    }

    @Override
    public void update(Long id, AddUserDto addUserDTO) {
        makeValidations(addUserDTO);
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException(NOT_FOUND_MESSAGE));
        UserDTOMapper.replaceUserWithAddUserDTOFields(user, addUserDTO);
        userRepository.save(user);
    }

    //for single responsability principle
    private void makeValidations(AddUserDto addUserDTO) {
        if (userRepository.findByUsername(addUserDTO.getUsername()).isPresent()) {
            throw new AlreadyExistsException("The username already exists");
        }

        if (userRepository.findByEmail(addUserDTO.getEmail()).isPresent()) {
            throw new AlreadyExistsException("The email already exists");
        }
    }
}
