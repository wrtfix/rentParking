package com.parking.rentparking.application.usecases;

import com.parking.rentparking.domain.models.Task;
import com.parking.rentparking.domain.ports.in.CreateTaskUseCase;
import com.parking.rentparking.domain.ports.out.TaskRepositoryPort;

public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public CreateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Task createTask(Task task) {
        return this.taskRepositoryPort.createTask(task);
    }
}
