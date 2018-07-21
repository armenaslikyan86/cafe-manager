package com.cafe.manager.service;

import com.cafe.manager.domain.Table;
import com.cafe.manager.domain.User;
import com.cafe.manager.dto.TableDto;
import com.cafe.manager.dto.UserDto;

import java.util.List;

public interface TableService {
    Table getTableById(Long id);

    Table register(Table createRequest);

    List<Table> findAll();

    User findAssignedWaiter(Long id);
}
