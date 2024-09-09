package com.parking.rentparking.application.services;

import com.parking.rentparking.domain.models.Task;
import com.parking.rentparking.domain.ports.in.CreateTaskUseCase;
import com.parking.rentparking.domain.ports.in.DeleteTaskUseCase;
import com.parking.rentparking.domain.ports.in.RetriverTaskUseCase;
import com.parking.rentparking.domain.ports.in.UpdateTaskUseCase;

import java.util.List;
import java.util.Optional;

public class TaskService implements CreateTaskUseCase, DeleteTaskUseCase, RetriverTaskUseCase, UpdateTaskUseCase {

    private final DeleteTaskUseCase deleteTaskUseCase;
    private final RetriverTaskUseCase retrieverTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final CreateTaskUseCase createTaskUseCases;

    public TaskService(DeleteTaskUseCase deleteTaskUseCase, RetriverTaskUseCase retrieverTaskUseCase, UpdateTaskUseCase updateTaskUseCase, CreateTaskUseCase createTaskUseCases) {
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.retrieverTaskUseCase = retrieverTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
        this.createTaskUseCases = createTaskUseCases;
    }


    @Override
    public Optional<Task> updateTask(Long taskId, Task updatedTask) {
        return updateTaskUseCase.updateTask(taskId, updatedTask);
    }

    @Override
    public boolean deleteTask(Long taskId) {
        return deleteTaskUseCase.deleteTask(taskId);
    }

    @Override
    public Optional<Task> getTask(Long taskId) {
        return retrieverTaskUseCase.getTask(taskId);
    }

    @Override
    public List<Task> getTasks() {
        return retrieverTaskUseCase.getTasks();
    }

    @Override
    public Task createTask(Task task) {
        return createTaskUseCases.createTask(task);
    }
}
