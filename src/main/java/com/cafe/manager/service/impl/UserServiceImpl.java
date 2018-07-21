package com.cafe.manager.service.impl;

import com.cafe.manager.domain.User;
import com.cafe.manager.dto.UserDto;
import com.cafe.manager.repository.UserRepository;
import com.cafe.manager.service.UserService;
import com.cafe.manager.service.exception.EmailExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import java.util.Optional;


public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User getUserById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User getUserByEmail(String email) {
        Assert.hasText(email, "email cannot be empty");

        final Optional<User> userOptional = userRepository.findByEmail(email);
        return userOptional.orElseThrow(() -> new IllegalStateException("User is not found"));
    }

    @Override
    public User register(UserDto creationRequest) throws EmailExistException {
        if(emailExist(creationRequest.getEmail())) {
            throw new EmailExistException("Email already exists");
        }
        final User user = new User();
        user.setFirstName(creationRequest.getFirstName());
        user.setLastName(creationRequest.getLastName());
        user.setEmail(creationRequest.getEmail());
        user.setRoleType(creationRequest.getRoleType());
        return userRepository.save(user);
    }

    private boolean emailExist(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return true;
        }
        return false;
    }

    public User convertToUser(UserDto userDto) {
        final User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setRoleType(userDto.getRoleType());
        user.setTable(userDto.getTable());
        return user;
    }
}
