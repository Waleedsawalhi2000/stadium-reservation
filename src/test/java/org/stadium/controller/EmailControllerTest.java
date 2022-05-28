package org.stadium.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.stadium.config.BaseWebTest;
import org.stadium.service.EmailService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {
        EmailController.class,
        EmailService.class
}
)
public class EmailControllerTest extends BaseWebTest {
    @MockBean
    private EmailService service;

    @Test
    public void sendPasswordVerificationCode() throws Exception {
        testPost("email/change-password");
    }

    @Test
    public void sendEmailVerificationCode() throws Exception {
        testPost("email/verify");
    }
}