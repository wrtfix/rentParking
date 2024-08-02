package com.parking.rentparking.infraestructure.config;

import com.parking.rentparking.application.services.TaskService;
import com.parking.rentparking.application.usecases.CreateTaskUseCaseImpl;
import com.parking.rentparking.application.usecases.DeleteTaskUseCaseImpl;
import com.parking.rentparking.application.usecases.RetriverTaskUseCaseImpl;
import com.parking.rentparking.application.usecases.UpdateTaskUseCaseImpl;
import com.parking.rentparking.domain.ports.out.TaskRepositoryPort;
import com.parking.rentparking.infraestructure.repository.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort){
        return new TaskService( new DeleteTaskUseCaseImpl(taskRepositoryPort),
                new RetriverTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort),
                new CreateTaskUseCaseImpl(taskRepositoryPort));
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter){
        return jpaTaskRepositoryAdapter;
    }



}
