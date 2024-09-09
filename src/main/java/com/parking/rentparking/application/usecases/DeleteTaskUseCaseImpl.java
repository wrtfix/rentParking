package com.parking.rentparking.application.usecases;

import com.parking.rentparking.domain.ports.in.DeleteTaskUseCase;
import com.parking.rentparking.domain.ports.out.TaskRepositoryPort;

public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    public DeleteTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }
    @Override
    public boolean deleteTask(Long taskId) {
        return this.taskRepositoryPort.deleteTask(taskId);
    }
}
