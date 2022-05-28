package org.stadium.config;


import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.stadium.controller.EmailController;
import org.stadium.service.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles({"test", "services"})
public abstract class BaseWebTest {
    @Autowired
    protected MockMvc mockMvc;


    public void testList(final String baseFeature, final String baseUrl) throws Exception {
        final MvcResult result = mockMvc.perform(get("/" + baseUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    public void testListWithExtension(final String baseFeature, final String baseUrl, final String extension) throws Exception {
        final MvcResult result = mockMvc.perform(get("/" + baseUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }


    public void testGet(final String baseUrl) throws Exception {
        final MvcResult result = mockMvc.perform(get("/api/" + baseUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    public void testPut(final String url, final Object id) throws Exception {
        final MvcResult result = mockMvc.perform(put("/api/" + url))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    public void testPost(final String baseUrl) throws Exception {
        final MvcResult result = mockMvc.perform(post("/api/" + baseUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    public void testDelete(final String baseUrl) throws Exception {
        final MvcResult result = mockMvc.perform(delete("/api/" + baseUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    private MockHttpServletRequestBuilder post(final String url) {
        return MockMvcRequestBuilders.post(url).secure(false);
    }

    private MockHttpServletRequestBuilder put(final String url) {
        return MockMvcRequestBuilders.put(url).secure(false);
    }

    private MockHttpServletRequestBuilder delete(final String url) {
        return MockMvcRequestBuilders.post(url).secure(false);
    }

    private MockHttpServletRequestBuilder get(final String url) {
        return MockMvcRequestBuilders.get(url).secure(false);
    }
}