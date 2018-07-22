package com.cafe.manager.web;


import com.cafe.manager.domain.User;
import com.cafe.manager.dto.UserDto;
import com.cafe.manager.service.UserService;
import org.hibernate.validator.constraints.NotBlank;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/get")
    public UserDto getUser(@Valid @NotBlank @RequestParam("email") final String email) {
        final User user = userService.getUserByEmail(email);
        final UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<UserDto> register(@Valid @NotNull @RequestBody final UserDto creationUserDto) {
        final User creationUser = modelMapper.map(creationUserDto, User.class);
        final User user = userService.register(creationUser);
        final UserDto userDto = modelMapper.map(user, UserDto.class);
        return ResponseEntity.ok(userDto);
    }
}
