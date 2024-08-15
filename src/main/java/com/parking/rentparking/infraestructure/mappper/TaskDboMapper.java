package com.parking.rentparking.infraestructure.mappper;

import com.parking.rentparking.domain.models.Task;
import com.parking.rentparking.infraestructure.entities.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskDboMapper {

    public TaskEntity toDbo(Task task){
        return new TaskEntity(task.getId(), task.getDescription(), task.getTimeRequiredToComplete());
    }

    public Task toDomain(TaskEntity entity){
        return new Task(entity.getId(), entity.getDescription(), entity.getTimeRequiredToComplete());
    }
}
