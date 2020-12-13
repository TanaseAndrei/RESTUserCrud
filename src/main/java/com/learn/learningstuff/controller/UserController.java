package com.learn.learningstuff.controller;

import com.learn.learningstuff.dto.entities.AddUserDto;
import com.learn.learningstuff.dto.entities.DisplayUserDto;
import com.learn.learningstuff.service.interfaces.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<DisplayUserDto>> getAll(){
        List<DisplayUserDto> displayUserDtoList = userService.getAll();
        return new ResponseEntity<>(displayUserDtoList, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Long> addUser(@Valid @RequestBody AddUserDto addUserDTO){
        Long id = userService.add(addUserDTO);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<DisplayUserDto> getUser(@PathVariable("id") Long id){
        DisplayUserDto displayUserDTO = userService.get(id);
        return new ResponseEntity<>(displayUserDTO, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        userService.delete(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AddUserDto> update(@PathVariable("id") Long id, @RequestBody AddUserDto addUserDTO){
        userService.update(id, addUserDTO);
        return new ResponseEntity<>(addUserDTO, HttpStatus.OK);
    }
}
