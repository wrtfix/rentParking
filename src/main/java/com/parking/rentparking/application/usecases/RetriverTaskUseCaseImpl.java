package com.parking.rentparking.application.usecases;

import com.parking.rentparking.domain.models.Task;
import com.parking.rentparking.domain.ports.in.RetriverTaskUseCase;
import com.parking.rentparking.domain.ports.out.TaskRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetriverTaskUseCaseImpl implements RetriverTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;
    public RetriverTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Task> getTask(Long taskId) {
        return this.taskRepositoryPort.findById(taskId);
    }

    @Override
    public List<Task> getTasks() {
        return this.taskRepositoryPort.findAll();
    }
}
