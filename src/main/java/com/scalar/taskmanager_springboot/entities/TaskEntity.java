package com.scalar.taskmanager_springboot.entities;

import lombok.Data;
import java.util.Date;

@Data
public class TaskEntity {

    private int id;
    private String title;
    private String description;
    private Date deadline;
    private boolean completed;


    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setComplete(boolean completed) {
        this.completed = completed;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public int getId() {
        return this.id;
    }
}
