package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/task")
public class TaskController {

    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    public List<TaskDto> getTasks(){
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTask")
    public TaskDto getTask(String taskId){
        return new TaskDto((long)1, "GetTask", "GetTask");
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteTask(String taskId){

    }

    @RequestMapping(method = RequestMethod.PUT)
    public TaskDto updateTask(TaskDto taskDto){
        return new TaskDto((long)1, "Updated task", "Updated task up");
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createTask(TaskDto taskDto){

    }
}
