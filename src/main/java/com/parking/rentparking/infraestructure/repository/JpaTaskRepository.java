package com.parking.rentparking.infraestructure.repository;

import com.parking.rentparking.infraestructure.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTaskRepository  extends JpaRepository<TaskEntity, Long> {

}
