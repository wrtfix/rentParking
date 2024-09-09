package com.parking.rentparking.infraestructure.repository;

import com.parking.rentparking.domain.models.Task;
import com.parking.rentparking.domain.ports.out.TaskRepositoryPort;
import com.parking.rentparking.infraestructure.entities.TaskEntity;
import com.parking.rentparking.infraestructure.mappper.TaskDboMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaTaskRepositoryAdapter implements TaskRepositoryPort {

    @Autowired
    private TaskDboMapper taskDboMapper;

    private final JpaTaskRepository jpaTaskRepository;

    public JpaTaskRepositoryAdapter(JpaTaskRepository jpaTaskRepository, TaskDboMapper taskDboMapper) {
        this.taskDboMapper = taskDboMapper;
        this.jpaTaskRepository = jpaTaskRepository;
    }

    @Override
    public Task createTask(Task task) {
        TaskEntity entity = taskDboMapper.toDbo(task);
        TaskEntity entitySaved = jpaTaskRepository.save(entity);
        return taskDboMapper.toDomain(entitySaved);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return jpaTaskRepository.findById(id)
                .map( entity -> taskDboMapper.toDomain(entity));
    }

    @Override
    public List<Task> findAll() {
        return jpaTaskRepository.findAll().stream()
                .map(entity -> taskDboMapper.toDomain(entity))
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteTask(Long id) {
        if (jpaTaskRepository.existsById(id)) {
            jpaTaskRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Task> update(Task task) {
        if (jpaTaskRepository.existsById(task.getId())){
            TaskEntity entity = taskDboMapper.toDbo(task);
            TaskEntity entityUpdated = jpaTaskRepository.save(entity);
            return Optional.of(taskDboMapper.toDomain(entityUpdated));
        }
        return Optional.empty();
    }
}
