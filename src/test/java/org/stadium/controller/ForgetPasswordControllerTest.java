package org.stadium.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.stadium.config.BaseWebTest;
import org.stadium.service.EmailService;



@WebMvcTest({
        ForgetPasswordController.class,
        EmailService.class
})
@RunWith(SpringRunner.class)
public class ForgetPasswordControllerTest extends BaseWebTest {
    @MockBean
    private EmailService service;

    @Test
    public void changePassword() throws Exception {
        testPut("forget-password/Hi?password=10343214&email=sawalhi1000waleed@gmail.com", null);
    }
}