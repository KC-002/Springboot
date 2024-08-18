package com.scalar.taskmanager_springboot.dtos;

import com.scalar.taskmanager_springboot.service.TaskService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateTaskDTO {
    String title;
    String description;
    String deadline;

    public String getTitle(){
        return title;
    }

    public String GetDescription() {
        return description;

    }

    public String getDeadLine() {
        return deadline;
    }
}
