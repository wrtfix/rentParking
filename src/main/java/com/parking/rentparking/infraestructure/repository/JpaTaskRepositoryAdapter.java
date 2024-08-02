package com.parking.rentparking.infraestructure.repository;

import com.parking.rentparking.domain.models.Task;
import com.parking.rentparking.domain.ports.out.TaskRepositoryPort;
import com.parking.rentparking.infraestructure.entities.TaskEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaTaskRepositoryAdapter implements TaskRepositoryPort {

    private final JpaTaskRepository jpaTaskRepository;

    public JpaTaskRepositoryAdapter(JpaTaskRepository jpaTaskRepository) {
        this.jpaTaskRepository = jpaTaskRepository;
    }

    @Override
    public Task createTask(Task task) {
        TaskEntity entity = TaskEntity.fromDomainModel(task);
        TaskEntity entitySaved = jpaTaskRepository.save(entity);
        return entitySaved.saveModel();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return jpaTaskRepository.findById(id).map(TaskEntity::saveModel);
    }

    @Override
    public List<Task> findAll() {
        return jpaTaskRepository.findAll().stream()
                .map(TaskEntity::saveModel)
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
            TaskEntity entity = TaskEntity.fromDomainModel(task);
            TaskEntity entityUpdated = jpaTaskRepository.save(entity);
            return Optional.of(entityUpdated.saveModel());
        }
        return Optional.empty();
    }
}
