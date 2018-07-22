package com.cafe.manager.service.impl;

import com.cafe.manager.domain.Table;
import com.cafe.manager.domain.User;
import com.cafe.manager.repository.TableRepository;
import com.cafe.manager.service.TableService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableServiceImpl implements TableService {

    @Autowired
    private TableRepository tableRepository;

    @Override
    public Table getById(Long id) {
        return tableRepository.findById(id).get();
    }

    @Override
    public Table modify(Table table) {
        return tableRepository.save(table);
    }

    @Override
    public List<Table> findAll() {
        return Lists.newArrayList(tableRepository.findAll());
    }

    @Override
    public User findAssignedWaiter(Long tableId) {
        return tableRepository.findById(tableId).get().getUser();
    }
}
