package ua.com.hromoi.api.http.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.hromoi.infrastructure.domain.TaskService;
import ua.com.hromoi.infrastructure.exceptions.EntityAlreadyExistsException;
import ua.com.hromoi.infrastructure.exceptions.EntityNotFoundException;
import ua.com.hromoi.infrastructure.exceptions.InvalidDataException;
import ua.com.hromoi.infrastructure.viewmodels.Task.TaskForSave;

/**
 * Created by Viacheslav_Khromoi on 09.07.2017.
 */
@RestController
@RequestMapping("${spring.data.rest.base-path}/task")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
    public Integer createTask(@RequestBody TaskForSave taskForSave) throws EntityNotFoundException, InvalidDataException, EntityAlreadyExistsException {
        return taskService.save(taskForSave);
    }
}
