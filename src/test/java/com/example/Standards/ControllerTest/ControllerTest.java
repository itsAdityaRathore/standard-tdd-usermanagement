package com.example.Standards.ControllerTest;

import com.example.Standards.Model.Users;
import com.example.Standards.Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.matchers.JUnitMatchers.containsString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getUsers() throws Exception {

        List<Users> u = Arrays.asList(
                new Users("Mohan", "Ajmer", "9090901234", 2, "1001"),
                new Users("Amit", "Kolkata", "9093456090", 2, "1001"));

        when(userService.getUsers()).thenReturn(u);

        mockMvc.perform(
                get("/api/users")
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                jsonPath("$[0].uName").value("Mohan")
        );

        verify(userService).getUsers();
    }

    @Test
    public void createUser() throws Exception {

        Users u = new Users("ADITYA", "UDAIPUR", "9090909090", 2, "1003");

        when(userService.createUser(anyObject())).thenReturn("User Created");

        mockMvc.perform(
                post("/api/users/new")
                        .content(asJsonString(u))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andDo(
                print()
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().string("User Created")
        );

        verify(userService, times(1)).createUser(anyObject());

    }

    @Test
    public void findUserByManager() throws Exception {
        List<Users> u = Arrays.asList(
                new Users("Mohan", "Ajmer", "9090901234", 2, "1001"),
                new Users("Amit", "Kolkata", "9093456090", 2, "1001"));

        when(userService.getUserByUmanager("1001")).thenReturn(u);

        mockMvc.perform(
                get("/api/users/{manager}", "1001")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andDo(
                print()
        ).andExpect(
                status().isOk()
        ).andExpect(
                jsonPath("$[0].uManager").value("1001")
        );


    }
}
