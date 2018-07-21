package com.cafe.manager.service;

import com.cafe.manager.domain.User;
import com.cafe.manager.dto.UserDto;
import com.cafe.manager.service.exception.EmailExistException;

public interface UserService {
    User getUserById(Long id);
    User getUserByEmail(String email);
    User register(UserDto creationRequest) throws EmailExistException;

}
