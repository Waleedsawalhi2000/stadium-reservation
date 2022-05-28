package org.stadium.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.stadium.config.BaseWebTest;
import org.stadium.service.LocationService;



@WebMvcTest({
        LocationController.class,
        LocationService.class
})
@RunWith(SpringRunner.class)
public class LocationControllerTest extends BaseWebTest {
    @MockBean
    private LocationService service;

    @Test
    public void getLocations() throws Exception {
        testGet("location");
    }

    @Test
    public void createLocation() throws Exception {
        testPost("location");
    }

    @Test
    public void updateLocation() throws Exception {
        testPut("location", "id");
    }

    @Test
    public void getLocationById() throws Exception {
        testGet("location/1");
    }

    @Test
    public void deleteLocation() throws Exception {
        testDelete("location/1");
    }
}