package org.stadium.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.stadium.config.BaseWebTest;
import org.stadium.dto.UserDto;
import org.stadium.repository.UserRepository;
import org.stadium.service.EmailService;
import org.stadium.service.UserService;


@WebMvcTest(controllers = {
        UserController.class,
        UserService.class
}
)
@RunWith(SpringRunner.class)
public class UserControllerTest extends BaseWebTest {
    @MockBean
    private UserService service;

    @Test
    public void getUsersTest() throws Exception {
        testGet("user");
    }

    @Test
    public void updateLoggedInUser() throws Exception {
        testPut("user", "1");
    }

    @Test
    public void createUser() throws Exception {
        testPost("user");
    }
}