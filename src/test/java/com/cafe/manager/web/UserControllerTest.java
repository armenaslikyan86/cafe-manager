package com.cafe.manager.web;

import com.cafe.manager.common.RoleType;
import com.cafe.manager.domain.Table;
import com.cafe.manager.domain.User;
import com.cafe.manager.dto.ProductDto;
import com.cafe.manager.dto.TableDto;
import com.cafe.manager.dto.UserDto;
import com.cafe.manager.service.CommonTestResource;
import com.cafe.manager.service.TableService;
import com.cafe.manager.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.EntityManager;

public class UserControllerTest extends CommonTestResource {

    @Autowired
    private UserController userController;

    @Autowired
    private UserService userService;

    @Autowired
    private TableService tableService;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void getUser() {
        final UserDto result = userController.getUser("email");
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.getId().longValue());
        Assert.assertEquals("firstName", result.getFirstName());
    }

    @Test
    public void register() {
        final UserDto userDto = new UserDto();
        userDto.setId(2L);
        userDto.setEmail("armenaslikyan@gmail.com");
        userDto.setFirstName("armen");
        userDto.setLastName("aslikyan");
        userDto.setRoleType(RoleType.MANAGER);
        ResponseEntity<UserDto> response = userController.register(userDto);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void addTable() {
        final TableDto tableDto = new TableDto();
        tableDto.setId(10L);
        tableDto.setName("Round table");
        tableDto.setCapacity(6);
        ResponseEntity<TableDto> response = userController.addTable(tableDto);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void addProduct() {
        final ProductDto productDto = new ProductDto();
        productDto.setId(20L);
        productDto.setName("sushi");
        productDto.setPrice("1500");
        ResponseEntity<ProductDto> response = userController.addProduct(productDto);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void assignTableToWaiter() {


        final User armen = new User();
        armen.setId(10L);
        armen.setEmail("armenaslikyan@gmail.com");
        armen.setFirstName("Armen");
        armen.setLastName("Aslikyan");
        armen.setPasswordHash(BCrypt.hashpw("armen", BCrypt.gensalt(12)));
        armen.setRoleType(RoleType.WAITER);

        Long userId = userService.modify(armen).getId();

        entityManager.flush();
        entityManager.clear();

        final Table roundTable = new Table();
        roundTable.setId(20L);
        roundTable.setName("Round table");
        roundTable.setCapacity(10);

        Long tableId = tableService.modify(roundTable).getId();

        entityManager.flush();
        entityManager.clear();

        final User userBefore = userService.getById(userId);
        Assert.assertNull(userBefore.getTable());
        userController.assignTableToWaiter(userId, tableId);
        entityManager.flush();
        entityManager.clear();

        final User userAfter = userService.getById(userId);
        Assert.assertNotNull(userAfter.getTable());

        Assert.assertEquals(tableId, userAfter.getTable().getId());
    }
}
