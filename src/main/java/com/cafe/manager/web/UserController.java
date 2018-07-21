package com.cafe.manager.web;


import com.cafe.manager.domain.User;
import com.cafe.manager.dto.UserDto;
import com.cafe.manager.service.UserService;
import com.cafe.manager.service.exception.EmailExistException;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @GetMapping(value = "/get")
    public UserDto getUser(@Valid @NotBlank @RequestParam("email") final String email) {
        final User user = userService.getUserByEmail(email);
        final UserDto userDto = convertToUserDto(user);
        return userDto;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<UserDto> register(@Valid @NotNull @RequestBody final UserDto creationRequest) throws EmailExistException {
        final User user = userService.register(creationRequest);
        return ResponseEntity.ok(convertToUserDto(user));
    }

    private UserDto convertToUserDto(final User user) {
        final UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setRoleType(user.getRoleType());
        userDto.setTable(user.getTable());
        return userDto;
    }


}
