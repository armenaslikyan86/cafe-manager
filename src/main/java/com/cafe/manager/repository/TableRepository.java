package com.cafe.manager.repository;

import com.cafe.manager.domain.Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends CrudRepository<Table, Long> {
}
