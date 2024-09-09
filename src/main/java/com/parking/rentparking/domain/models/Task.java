package com.parking.rentparking.domain.models;

public class Task {
    private Long id;
    private String description;
    private int timeRequiredToComplete;

    public Task(Long id, String description, int timeRequiredToComplete) {
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

    public boolean equals(Task task){
        return this.id.equals(task.getId())
                && this.description.equals(task.getDescription())
                && this.timeRequiredToComplete == task.getTimeRequiredToComplete();
    }
}
