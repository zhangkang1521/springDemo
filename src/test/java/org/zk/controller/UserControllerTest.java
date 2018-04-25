package org.zk.controller;

import com.oracle.webservices.internal.api.message.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.zk.config.MvcConfig;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 4/25/2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MvcConfig.class })
@WebAppConfiguration("src/main/resources")
public class UserControllerTest {

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext wac;

    @Before
    public void before() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testPage() throws Exception {
        mockMvc.perform(get("/user/hello"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
                .andExpect(forwardedUrl("/view/hello.jsp"))
                .andExpect(model().attribute("username", "zk"));
    }

    @Test
    public void testRest() throws Exception{
        mockMvc.perform(get("/user/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string("{\"id\":100,\"username\":null,\"age\":null}"));
    }
}