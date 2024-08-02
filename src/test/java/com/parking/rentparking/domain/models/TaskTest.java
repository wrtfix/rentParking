package com.parking.rentparking.domain.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TaskTest {

    @Test
    void testTaskCreation() {
        Task task = new Task(1L, "Test task", 10);
        assertEquals(1,task.getId());
        assertEquals("Test task",task.getDescription());
        assertEquals(10, task.getTimeRequiredToComplete());

    }

    @Test
    void testTaskUpdating() {
        Task task = new Task(1L, "Test task", 10);
        task.setDescription("Updated task");
        assertEquals("Updated task", task.getDescription());
        task.setTimeRequiredToComplete(5);
        assertEquals(5, task.getTimeRequiredToComplete());
    }

    @Test
    void testTaskEquality() {
        Task task1 = new Task(1L, "Test task", 10);
        Task task2 = new Task(1L, "Test task", 10);
        assertTrue(task1.equals(task2));
    }
}
