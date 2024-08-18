package com.scalar.taskmanager_springboot.dtos;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UpdateTaskDTO {

    public String description;
    public String deadline;
    public Boolean completed;

    public Boolean getCompleted() {
        return completed;
    }

    public String getDescription() {
        return description;
    }
    public String getDeadline(){
        return deadline;
    }
}
