package com.parking.rentparking.application.services;

import com.parking.rentparking.domain.models.Task;
import com.parking.rentparking.domain.ports.in.CreateTaskUseCase;
import com.parking.rentparking.domain.ports.in.DeleteTaskUseCase;
import com.parking.rentparking.domain.ports.in.RetriverTaskUseCase;
import com.parking.rentparking.domain.ports.in.UpdateTaskUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {
    @Mock
    DeleteTaskUseCase deleteTaskUseCase;
    @Mock
    RetriverTaskUseCase retriverTaskUseCase;
    @Mock
    UpdateTaskUseCase updateTaskUseCase;
    @Mock
    CreateTaskUseCase createTaskUseCase;
    @InjectMocks
    TaskService taskService;

    @Test
    void createTask(){
        Task task = new Task(1L, "test", 1);
        when(createTaskUseCase.createTask(task)).thenReturn(new Task(1L, "test", 1));
        Task saveTask = taskService.createTask(task);
        assertEquals(1,saveTask.getId());
    }

    @Test
    void getTask(){
        Task task = new Task(1L, "test", 1);
        when(retriverTaskUseCase.getTask(1L)).thenReturn(Optional.of(task));
        Task getTask = taskService.getTask(1L).orElse(null);
        assertEquals(1,getTask.getId());
    }

    @Test
    void updateTask(){
        Task task = new Task(1L, "test", 1);
        when(updateTaskUseCase.updateTask(1L, task)).thenReturn(Optional.of(task));
        Optional<Task> updatedTask = taskService.updateTask(1L, task);
        assertEquals(1,updatedTask.get().getId());
    }

    @Test
    void deleteTask(){
        doReturn(true).when(deleteTaskUseCase).deleteTask(1L);
        boolean result = taskService.deleteTask(1L);
        assertEquals(true, result);
    }


}
