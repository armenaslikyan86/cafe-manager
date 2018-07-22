package com.cafe.manager.service;

import com.cafe.manager.domain.User;

public interface UserService {
    User getById(Long id);

    User getByEmail(String email);

    User register(User creationRequest);

    User modify(User user);


    void assignTableToUser(Long userId, Long tableId);
}
