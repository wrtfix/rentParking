package com.parking.rentparking.infraestructure.repository;

import com.parking.rentparking.domain.models.Task;
import com.parking.rentparking.infraestructure.mappper.TaskDboMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestPropertySource(locations = "classpath:application.properties")
@Sql("/test-h2.sql")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class JpaTaskRepositoryAdapterTest {
    @Autowired
    JpaTaskRepository jpaTaskRepository;
    JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter;
    TaskDboMapper taskDboMapper = new TaskDboMapper();
    @BeforeEach
    void setUp() {
        jpaTaskRepositoryAdapter = new JpaTaskRepositoryAdapter(jpaTaskRepository, taskDboMapper);
    }
    @Test
    void testFindAll() {
        assertThat(jpaTaskRepositoryAdapter.findAll()).hasSize(2);
    }

    @Test
    void testFindById() {
        assertNotNull(jpaTaskRepositoryAdapter.findById(2L));
    }

    @Test
    void testDeleteTask() {
        boolean deleted = jpaTaskRepositoryAdapter.deleteTask(2L);
        assertTrue(deleted);
    }

    @Test
    void testCreateTask() {
        Task task = new Task(null, "Test task", 10);
        Task createdTask = jpaTaskRepositoryAdapter.createTask(task);
        assertEquals(1, createdTask.getId());
    }

    @Test
    void testUpdateTask() {
        Task task = new Task(2L, "Updated task", 5);
        Optional<Task> updatedTask = jpaTaskRepositoryAdapter.update(task);
        assertTrue(updatedTask.isPresent());
        assertEquals("Updated task", updatedTask.get().getDescription());
        assertEquals(5, updatedTask.get().getTimeRequiredToComplete());
    }

}
