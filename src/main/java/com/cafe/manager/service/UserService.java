package com.cafe.manager.service;

import com.cafe.manager.domain.User;

public interface UserService {
    User getUserById(Long id);
    User getUserByEmail(String email);

    User register(User creationRequest);

    User modify(User user);

}
