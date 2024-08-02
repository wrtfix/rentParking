package com.parking.rentparking.domain.ports.in;

import com.parking.rentparking.domain.models.Task;

public interface CreateTaskUseCase {
    Task createTask(Task task);
}
