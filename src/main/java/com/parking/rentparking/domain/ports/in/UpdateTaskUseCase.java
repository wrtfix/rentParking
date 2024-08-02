package com.parking.rentparking.domain.ports.in;

import com.parking.rentparking.domain.models.Task;

import java.util.Optional;

public interface UpdateTaskUseCase {

    Optional<Task> updateTask(Long taskId, Task updatedTask);
}
