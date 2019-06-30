package com.mackittipat.macbootweb.controller.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mackittipat.macbootweb.controller.api.UserRestController;
import com.mackittipat.macbootweb.domain.User;
import com.mackittipat.macbootweb.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
// @WebMvcTest(value = UserControllerTest.class) // Cause error : java.lang.AssertionError: No ModelAndView found
@WebMvcTest
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testCreateGet() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .get("/user/create"))
                .andExpect(MockMvcResultMatchers.view().name("user_create"));

        Mockito.verify(userRepository, Mockito.times(0)).save(Mockito.any(User.class));
    }

    @Test
    public void testCreatePost() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        User user = new User();
        user.setId(1L);
        user.setName("Mac");

        mockMvc.perform(MockMvcRequestBuilders
                .post("/user/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(user)))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(userRepository, Mockito.times(1)).save(Mockito.any(User.class));
    }

    @Test
    public void testList() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .get("/user/"))
                .andExpect(MockMvcResultMatchers.view().name("user_list"));

        Mockito.verify(userRepository, Mockito.times(1)).findAll();
    }
}
