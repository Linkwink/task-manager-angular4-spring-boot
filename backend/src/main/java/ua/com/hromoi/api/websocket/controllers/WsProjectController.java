package ua.com.hromoi.api.websocket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import ua.com.hromoi.infrastructure.domain.ProjectService;
import ua.com.hromoi.infrastructure.exceptions.EntityNotFoundException;
import ua.com.hromoi.infrastructure.viewmodels.Project.ProjectForView;

/**
 * Created by Viacheslav_Khromoi on 09.07.2017.
 */
@Controller
@MessageMapping("/project")
public class WsProjectController {

    @Autowired
    private ProjectService projectService;

    @MessageMapping("/new")
    @SendTo("/app/project/new")
    public ProjectForView getProject(Integer id) throws EntityNotFoundException {
      return projectService.find(id);
    }

    @MessageMapping("/remove")
    @SendTo("/app/project/remove")
    public Integer removeProject(Integer id) throws EntityNotFoundException {
        projectService.delete(id);
        return id;
    }

}
