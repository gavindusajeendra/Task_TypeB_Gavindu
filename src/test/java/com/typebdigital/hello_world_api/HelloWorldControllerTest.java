package com.typebdigital.hello_world_api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void validTest() throws Exception {
        mockMvc.perform(get("/hello-world").param("name", "alice"))
                .andExpect(status().isOk());
    }

    @Test
    void invalidTest() throws Exception {
        mockMvc.perform(get("/hello-world").param("name", "nancy"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void missingTest() throws Exception {
        mockMvc.perform(get("/hello-world"))
                .andExpect(status().isBadRequest());
    }
}