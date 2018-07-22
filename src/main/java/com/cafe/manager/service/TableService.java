package com.cafe.manager.service;

import com.cafe.manager.domain.Table;
import com.cafe.manager.domain.User;

import java.util.List;

public interface TableService {
    Table getById(Long id);

    Table modify(Table table);

    List<Table> findAll();

    User findAssignedWaiter(Long userId);
}
