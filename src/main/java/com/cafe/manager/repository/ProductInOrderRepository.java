package com.cafe.manager.repository;

import com.cafe.manager.domain.ProductInOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInOrderRepository extends CrudRepository<ProductInOrder, Long> {
}
