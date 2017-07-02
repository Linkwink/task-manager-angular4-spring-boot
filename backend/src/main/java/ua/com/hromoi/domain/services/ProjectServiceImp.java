package ua.com.hromoi.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.hromoi.dao.repositories.ProjectRepository;
import ua.com.hromoi.domain.utils.Validator;
import ua.com.hromoi.infrastructure.domain.ProjectService;
import ua.com.hromoi.infrastructure.domain.TaskService;
import ua.com.hromoi.infrastructure.exceptions.EntityAlreadyExistsException;
import ua.com.hromoi.infrastructure.exceptions.EntityNotFoundException;
import ua.com.hromoi.infrastructure.exceptions.InvalidDataException;
import ua.com.hromoi.infrastructure.mappers.ProjectMapper;
import ua.com.hromoi.infrastructure.models.Project;
import ua.com.hromoi.infrastructure.models.Task;
import ua.com.hromoi.infrastructure.viewmodels.Project.ProjectAsListItem;
import ua.com.hromoi.infrastructure.viewmodels.Project.ProjectForSave;
import ua.com.hromoi.infrastructure.viewmodels.Project.ProjectForView;
import ua.com.hromoi.infrastructure.viewmodels.Task.TaskForSave;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Viacheslav_Khromoi on 02.07.2017.
 */
@Service
public class ProjectServiceImp implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TaskService taskService;

    @Override
    public ProjectForView find(Integer id) throws EntityNotFoundException {
        Project project = projectRepository.findOne(id);
        if (project == null) {
            throw new EntityNotFoundException(Project.class.getSimpleName());
        }
        return ProjectMapper.mapView(project);
    }

    @Override
    public List<ProjectAsListItem> findAll() {
        return projectRepository
                .findAll()
                .stream()
                .map(s -> ProjectMapper.mapListItem(s))
                .collect(Collectors.toList());
    }

    @Override
    public Integer save(ProjectForSave newEntity) throws EntityAlreadyExistsException, InvalidDataException, EntityNotFoundException {
        Project project =  projectRepository.findOne(newEntity.getId());
        Project projectWithSameName =  projectRepository.findOne(newEntity.getId());

        if (project == null && projectWithSameName == null) {
            project = new Project(newEntity.getName());
        } else if (project != null && (projectWithSameName.getId() == newEntity.getId())) {
            project.setName(newEntity.getName());
            for (TaskForSave task : newEntity.getTasks()) {
                task.setProjectId(newEntity.getId());
                taskService.save(task);
            }
        } else {
            throw new EntityAlreadyExistsException(Project.class.getSimpleName());
        }

        if (Validator.isValid(project)) {
            project = projectRepository.save(project);
        } else {
            throw new InvalidDataException(Project.class.getSimpleName(), Arrays.asList("name"));
        }
        return project.getId();
    }

    @Override
    public void delete(Integer id) throws EntityNotFoundException {
        Project project = projectRepository.findOne(id);
        if (project != null) {
            Set<Task> tasks = project.getTasks();
            if (!tasks.isEmpty()) {
                for(Task task : tasks) {
                    taskService.delete(task.getId());
                }
            }
            projectRepository.delete(project);
        } else {
            throw new EntityNotFoundException(Project.class.getSimpleName());
        }
    }
}
