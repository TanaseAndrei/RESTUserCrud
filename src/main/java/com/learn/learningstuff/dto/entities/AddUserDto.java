package com.learn.learningstuff.dto.entities;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
public class AddUserDto {

    @NotNull(message = "The username should not be null")
    @Size(min = 5, max = 20, message = "The username must have between 5 and 20 characters")
    private String username;

    @NotNull(message = "The password should not be null")
    @Size(min = 8, message = "The password must contain at least 8 characters")
    private String password;

    @NotNull(message = "The email should not be null")
    @NotBlank(message = "The email should not be empty")
    private String email;

    @NotNull(message = "The city should not be null")
    @NotBlank(message = "The city should not be blank")
    private String city;

    @NotNull(message = "The country should not be null")
    @NotBlank(message = "The country should not be blank")
    private String country;
}
