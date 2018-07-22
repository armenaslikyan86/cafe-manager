package com.cafe.manager.web;

import com.cafe.manager.dto.UserDto;
import com.cafe.manager.service.CommonIntegrationTestResource;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserControllerTest extends CommonIntegrationTestResource {

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
    }
}
