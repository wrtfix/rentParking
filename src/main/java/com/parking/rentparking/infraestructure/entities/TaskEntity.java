package com.parking.rentparking.infraestructure.entities;


import com.parking.rentparking.domain.models.Task;
import jakarta.persistence.*;

@Entity
@Table(name = "task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private int timeRequiredToComplete;

    public TaskEntity(){
        // Default constructor for JPA
    }
    public TaskEntity(Long id, String description, int timeRequiredToComplete){
        this.id = id;
        this.description = description;
        this.timeRequiredToComplete = timeRequiredToComplete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTimeRequiredToComplete() {
        return timeRequiredToComplete;
    }

    public void setTimeRequiredToComplete(int timeRequiredToComplete) {
        this.timeRequiredToComplete = timeRequiredToComplete;
    }
}
