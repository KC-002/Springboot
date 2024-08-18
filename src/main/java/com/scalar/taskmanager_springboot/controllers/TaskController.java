package com.scalar.taskmanager_springboot.controllers;

import com.scalar.taskmanager_springboot.dtos.CreateTaskDTO;
import com.scalar.taskmanager_springboot.dtos.UpdateTaskDTO;
import com.scalar.taskmanager_springboot.entities.TaskEntity;
import com.scalar.taskmanager_springboot.dtos.ErrorResponseDTO;
import com.scalar.taskmanager_springboot.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private  final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/getTask")
    public ResponseEntity<List<TaskEntity>> getTasks(){
        var tasks = taskService.getTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTaskById(int id){
        var task = taskService.getTaskById(id);
        if (task == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }
    @GetMapping("")
    public ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDTO body) throws ParseException {
        var task = taskService.addTask(body.getTitle(), body.GetDescription(), body.getDeadLine());
        return ResponseEntity.ok(task);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskEntity> updateTask(@PathVariable int id,@RequestBody UpdateTaskDTO body ) throws ParseException {
        var task  = taskService.updateTask(id, body.getDescription(), body.getDeadline(), body.getCompleted());

        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }







    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleErrors(Exception e){
        if (e instanceof ParseException){
            return ResponseEntity.badRequest().body(new ErrorResponseDTO("Invalid date formate (yyyy-MM-dd) prefered."));
        }

        return ResponseEntity.badRequest().body(new ErrorResponseDTO("Internal Server Error"));
    }



}
