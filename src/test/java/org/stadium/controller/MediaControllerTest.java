package org.stadium.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.stadium.config.BaseWebTest;
import org.stadium.service.MediaService;




@WebMvcTest({
        MediaController.class,
        MediaService.class
})
@RunWith(SpringRunner.class)
public class MediaControllerTest extends BaseWebTest {
    @MockBean
    private MediaService service;

    @Test
    public void addImage() throws Exception {
        testPost("media");
    }

    @Test
    public void getImage() throws Exception {
        testGet("media/1");
    }

    @Test
    public void deleteImage() throws Exception {
        testDelete("media/1");
    }
}