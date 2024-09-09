package com.parking.rentparking.application.usecases;

import com.parking.rentparking.domain.models.Task;
import com.parking.rentparking.domain.ports.in.UpdateTaskUseCase;
import com.parking.rentparking.domain.ports.out.TaskRepositoryPort;

import java.util.Optional;

public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;
    public UpdateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Task> updateTask(Long taskId, Task updatedTask) {
        return this.taskRepositoryPort.update(updatedTask);
    }
}
