package com.parking.rentparking.domain.ports.out;

import com.parking.rentparking.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryPort {
    Task createTask(Task task);
    Optional<Task> findById(Long id);
    List<Task> findAll();
    boolean deleteTask(Long id);
    Optional<Task> update(Task task);
}
