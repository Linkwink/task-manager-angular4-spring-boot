package ua.com.hromoi.api.http.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.hromoi.infrastructure.domain.ProjectService;
import ua.com.hromoi.infrastructure.exceptions.EntityAlreadyExistsException;
import ua.com.hromoi.infrastructure.exceptions.EntityNotFoundException;
import ua.com.hromoi.infrastructure.exceptions.InvalidDataException;
import ua.com.hromoi.infrastructure.viewmodels.Project.ProjectAsListItem;
import ua.com.hromoi.infrastructure.viewmodels.Project.ProjectForSave;

import java.util.List;

/**
 * Created by Viacheslav_Khromoi on 02.07.2017.
 */
@RestController
@RequestMapping("${spring.data.rest.base-path}/project")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List<ProjectAsListItem> getAll() {
        return projectService.findAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
    public Integer createProject(@RequestBody ProjectForSave projectForSave) throws EntityNotFoundException, InvalidDataException, EntityAlreadyExistsException {
        return projectService.save(projectForSave);
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET, produces = "application/json")
    public boolean deleteProject(@PathVariable Integer id) throws EntityNotFoundException {
        projectService.delete(id);
        return true;
    }
}
