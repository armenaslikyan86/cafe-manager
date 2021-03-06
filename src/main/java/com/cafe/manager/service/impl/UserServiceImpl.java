package com.cafe.manager.service.impl;

import com.cafe.manager.domain.Table;
import com.cafe.manager.domain.User;
import com.cafe.manager.repository.UserRepository;
import com.cafe.manager.service.TableService;
import com.cafe.manager.service.UserService;
import com.cafe.manager.service.exception.EmailExistException;
import com.cafe.manager.service.exception.ResourceDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TableService tableService;


    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceDoesNotExistException("User is not found"));
    }

    @Override
    public User getByEmail(String email) {
        Assert.hasText(email, "email cannot be empty");

        final Optional<User> userOptional = userRepository.findByEmail(email);
        return userOptional.orElseThrow(() -> new ResourceDoesNotExistException("User is not found"));
    }

    @Override
    public User register(User creationUser) throws EmailExistException {
        if (emailExist(creationUser.getEmail())) {
            throw new EmailExistException();
        }
        final User user = new User();
        user.setFirstName(creationUser.getFirstName());
        user.setLastName(creationUser.getLastName());
        user.setEmail(creationUser.getEmail());
        user.setRoleType(creationUser.getRoleType());
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User modify(final User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void assignTableToUser(Long userId, Long tableId) {
        User user = getById(userId);

        Table table = tableService.getById(tableId);

        table.setUser(user);

        tableService.modify(table);
    }

    private boolean emailExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
