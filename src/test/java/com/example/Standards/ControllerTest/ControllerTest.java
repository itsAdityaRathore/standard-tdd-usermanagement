package com.example.Standards.ControllerTest;

import com.example.Standards.Model.Users;
import com.example.Standards.Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.function.RequestPredicates.accept;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Test
    public void createBulk() throws Exception {

        when(userService.createBulkUser()).thenReturn("Bulk Create Completed");

        mockMvc.perform(
                get("/api/createBulk")
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().string(containsString("Bulk Create Completed"))
        );

        verify(userService).createBulkUser();
    }

    @Test
    public void getUsers() throws Exception {

        mockMvc.perform(
                get("/api/users")
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().contentType(MediaType.APPLICATION_JSON)
        );

        verify(userService).getUsers();
    }

    @Test
    public void createUser() throws Exception {

        Users u = new Users("ADITYA", "UDAIPUR", "9090909090", "SM", "1003");

        when(userService.createUser(u)).thenReturn("Users Created");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(u);

        mockMvc.perform(
                post("/api/users/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().string(containsString(""))
        );

        verify(userService).createUser(anyObject());
    }
}
