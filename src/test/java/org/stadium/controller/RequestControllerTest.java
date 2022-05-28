package org.stadium.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.stadium.config.BaseWebTest;
import org.stadium.service.RequestService;

import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest({
        RequestController.class,
        RequestService.class
})
@RunWith(SpringRunner.class)
public class RequestControllerTest extends BaseWebTest {
    @MockBean
    private RequestService service;

    @Test
    public void getRequests() throws Exception {
        testGet("request");
    }

    @Test
    public void getRequestById() throws Exception {
        testGet("request/1");
    }

    @Test
    public void createRequest() throws Exception {
        testPost("request");
    }

    @Test
    public void updateRequest() throws Exception {
        testPut("request", "1");
    }

    @Test
    public void deleteRequest() throws Exception {
        testDelete("request/1");
    }
}