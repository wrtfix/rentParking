package com.parking.rentparking.domain.ports.in;

import com.parking.rentparking.domain.models.Task;

import java.util.List;
import java.util.Optional;
public interface RetriverTaskUseCase {
    Optional<Task> getTask(Long taskId);
    List<Task> getTasks();
}
