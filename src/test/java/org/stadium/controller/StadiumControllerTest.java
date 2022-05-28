package org.stadium.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.stadium.config.BaseWebTest;
import org.stadium.service.StadiumService;

import static org.junit.jupiter.api.Assertions.*;



@RunWith(SpringRunner.class)
@WebMvcTest({
        StadiumController.class,
        StadiumService.class
})
public class StadiumControllerTest extends BaseWebTest {
    @MockBean
    private StadiumService service;

    @Test
    public void getStadiums() throws Exception {
        testGet("stadium");
    }

    @Test
    public void getStadiumById() throws Exception {
        testGet("stadium/1");
    }

    @Test
    public void createStadium() throws Exception {
        testPost("stadium/create");
    }

    @Test
    public void updateStadium() throws Exception {
        testPut("stadium/update/1", null);
    }

    public void deleteStadium() throws Exception {
        testDelete("stadium/1");
    }
}