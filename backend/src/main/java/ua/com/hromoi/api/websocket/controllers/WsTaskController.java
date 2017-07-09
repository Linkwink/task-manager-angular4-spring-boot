package ua.com.hromoi.api.websocket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import ua.com.hromoi.infrastructure.domain.TaskService;
import ua.com.hromoi.infrastructure.exceptions.EntityNotFoundException;
import ua.com.hromoi.infrastructure.viewmodels.Task.TaskForView;

import java.util.Collection;

/**
 * Created by Viacheslav_Khromoi on 08.07.2017.
 */
@Controller
@MessageMapping("/task")
public class WsTaskController {
    @Autowired
    private TaskService taskService;

    @MessageMapping("/new")
    @SendTo("/app/task/new")
    public TaskForView getTask(Integer id) throws EntityNotFoundException {
        return taskService.find(id);
    }
}
