package com.parking.rentparking.infraestructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.parking.rentparking.domain.models.Task;
import com.parking.rentparking.infraestructure.contorllers.TaskController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.parking.rentparking.DataSet.TASK_ID;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@Sql(scripts = "/test-h2.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@AutoConfigureMockMvc
@AutoConfigureWebTestClient
class TaskControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetTasks() throws Exception {
        mockMvc.perform(get(TaskController.TASK_RESOURCES+ "/{id}", TASK_ID))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(TASK_ID))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @Test
    void testGetTaskNotFound() throws Exception {
        mockMvc.perform(get(TaskController.TASK_RESOURCES+ "/{id}", 999999999))
               .andExpect(MockMvcResultMatchers.status().is(HttpStatus.NOT_FOUND.value()));
    }

    @Test
    void testGetTaskBadRequest() throws Exception {
        mockMvc.perform(get(TaskController.TASK_RESOURCES+ "/{id}", "not_a_number"))
               .andExpect(MockMvcResultMatchers.status().is(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    void testGetTaskMethodNotAllowed() throws Exception {
        mockMvc.perform(get(TaskController.TASK_RESOURCES))
               .andExpect(MockMvcResultMatchers.status().is(HttpStatus.METHOD_NOT_ALLOWED.value()));
    }

    @Test
    void testCreateTask() throws Exception {
        Task task = new Task(100L,"test", 7);
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(task);

        mockMvc.perform(post(TaskController.TASK_RESOURCES)
                .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.CREATED.value()))
                .andReturn()
                .getResponse()
                .getContentAsString();

    }

}
