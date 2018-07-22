package com.cafe.manager.web;

import com.cafe.manager.common.RoleType;
import com.cafe.manager.dto.ProductDto;
import com.cafe.manager.dto.TableDto;
import com.cafe.manager.dto.UserDto;
import com.cafe.manager.service.CommonTestResource;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class UserControllerTest extends CommonTestResource {

    @Autowired
    private UserController userController;

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

        userController.assignTableToWaiter(Optional.of(10L), Optional.of(20L));


        Assert.assertEquals("Round table", userController.getUser("armenaslikyan@gmail.com"));
    }
}
