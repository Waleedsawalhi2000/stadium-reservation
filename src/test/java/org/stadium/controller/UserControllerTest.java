package org.stadium.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;


@WebMvcTest({
        UserController.class
})
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Test
    public void test() throws Exception {
    }
}