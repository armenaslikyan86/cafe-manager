package com.cafe.manager.service.impl;

import com.cafe.manager.domain.Table;
import com.cafe.manager.domain.User;
import com.cafe.manager.repository.TableRepository;
import com.cafe.manager.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TableServiceImpl implements TableService
{

    @Autowired
    private TableRepository tableRepository;

    @Override
    public Table getTableById(Long id) {
        return tableRepository.findOne(id);
    }

    @Override
    public Table register(Table createRequest) {
        return tableRepository.save(createRequest);
    }

    @Override
    public List<Table> findAll() {
        return (List<Table>) tableRepository.findAll();
    }

    @Override
    public User findAssignedWaiter(Long id) {
        return tableRepository.findOne(id).getUser();
    }
}
