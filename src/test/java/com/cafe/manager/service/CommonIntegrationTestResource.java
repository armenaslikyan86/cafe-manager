package com.cafe.manager.service;

import com.cafe.manager.common.RoleType;
import com.cafe.manager.domain.*;
import com.cafe.manager.repository.ProductInOrderRepository;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
public class CommonIntegrationTestResource {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ProductInOrderRepository productInOrderRepository;

    @Before
    public void initDatabase() {
        final User user = new User();
        user.setId(1L);
        user.setEmail("email");
        user.setPasswordHash(BCrypt.hashpw("password", BCrypt.gensalt(12)));
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setRoleType(RoleType.MANAGER);

        final Table table = new Table();
        table.setId(1L);
        table.setName("Table1");
        table.setCapacity(12);

        final Order order1 = new Order();
        order1.setId(1L);
        order1.setDescription("Description1");
        order1.setTable(table);

        final ProductInOrder prodInOrder1 = new ProductInOrder();
        prodInOrder1.setId(1L);
        prodInOrder1.setAmount(2L);
        prodInOrder1.setOrder(order1);

        final Product product1 = new Product();
        product1.setId(1L);
        product1.setName("Cola");
        product1.setPrice("200");
        prodInOrder1.setProduct(product1);

        final ProductInOrder prodInOrder2 = new ProductInOrder();
        prodInOrder2.setId(2L);
        prodInOrder2.setAmount(1L);
        prodInOrder2.setOrder(order1);

        final Product product2 = new Product();
        product2.setId(2L);
        product2.setName("Burger");
        product2.setPrice("900");
        prodInOrder2.setProduct(product2);

        final Order order2 = new Order();
        order2.setId(2L);
        order2.setDescription("Description2");
        order2.setTable(table);

        final ProductInOrder prodInOrder3 = new ProductInOrder();
        prodInOrder3.setId(3L);
        prodInOrder3.setAmount(2L);
        prodInOrder3.setOrder(order2);

        final Product product3 = new Product();
        product3.setId(3L);
        product3.setName("Fanta");
        product3.setPrice("200");
        prodInOrder3.setProduct(product3);

        final ProductInOrder prodInOrder4 = new ProductInOrder();
        prodInOrder4.setId(4L);
        prodInOrder4.setAmount(1L);
        prodInOrder4.setOrder(order2);

        final Product product4 = new Product();
        product4.setId(4L);
        product4.setName("Sandwich");
        product4.setPrice("900");
        prodInOrder4.setProduct(product4);

        table.setUser(user);

        productInOrderRepository.saveAll(Lists.newArrayList(prodInOrder1, prodInOrder2, prodInOrder3, prodInOrder4));
        entityManager.flush();
        entityManager.clear();
    }
}
