package com.demo.controller;

import com.demo.AbstractSpringWebIT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MainControllerTest extends AbstractSpringWebIT {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "user1", password = "pwd")
    public void query() throws Exception {
        mockMvc.perform(get("/query"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("username", equalTo("user1")))
                .andExpect(model().attribute("accounts", hasSize(3)))
                .andExpect(model().attribute("farms", hasSize(3)))
                .andExpect(model().attribute("accounts",
                        hasItem(
                                allOf(
                                        hasProperty("name", is("account1"))
                                )
                        )))
                .andExpect(model().attribute("farms",
                        hasItem(
                                allOf(
                                        hasProperty("name", is("farms1"))
                                )
                        )));
    }
}
