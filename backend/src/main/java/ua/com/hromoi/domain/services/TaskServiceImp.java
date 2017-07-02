package ua.com.hromoi.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.hromoi.dao.repositories.ProjectRepository;
import ua.com.hromoi.dao.repositories.TaskRepository;
import ua.com.hromoi.domain.utils.Validator;
import ua.com.hromoi.infrastructure.domain.TaskService;
import ua.com.hromoi.infrastructure.exceptions.EntityAlreadyExistsException;
import ua.com.hromoi.infrastructure.exceptions.EntityNotFoundException;
import ua.com.hromoi.infrastructure.exceptions.InvalidDataException;
import ua.com.hromoi.infrastructure.mappers.TaskMapper;
import ua.com.hromoi.infrastructure.models.Project;
import ua.com.hromoi.infrastructure.models.Task;
import ua.com.hromoi.infrastructure.viewmodels.Task.TaskAsListItem;
import ua.com.hromoi.infrastructure.viewmodels.Task.TaskForSave;
import ua.com.hromoi.infrastructure.viewmodels.Task.TaskForView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Viacheslav_Khromoi on 02.07.2017.
 */
@Service
public class TaskServiceImp implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public TaskForView find(Integer id) throws EntityNotFoundException {
        Task task = taskRepository.findOne(id);
        if (task == null) {
            throw new EntityNotFoundException(Task.class.getSimpleName());
        }
        return TaskMapper.mapView(task);
    }

    @Override
    public List<TaskAsListItem> findAll() {
        return taskRepository
                .findAll()
                .stream()
                .map(s -> TaskMapper.mapListItem(s))
                .collect(Collectors.toList());
    }


    @Override
    public Integer save(TaskForSave newEntity) throws EntityAlreadyExistsException, EntityNotFoundException, InvalidDataException {
        Task task = taskRepository.findOne(newEntity.getId());
        Project project = projectRepository.findOne(newEntity.getProjectId());

        if (project == null) {
            throw new EntityNotFoundException(Project.class.getSimpleName());
        }

        Task taskWithSameName = taskRepository.findByNameIgnoreCase(newEntity.getName());

        if (task == null && taskWithSameName == null) {
            task = new Task(newEntity.getName(),newEntity.isDone(),newEntity.getDeadLineTmstmp(), newEntity.getOrder());
            task.setTproject(project);
        } else if (task != null && (taskWithSameName == null || task.getId() == taskWithSameName.getId())) {
            task.setOrder(newEntity.getOrder());
            task.setName(newEntity.getName());
            task.setDeadLineTmstmp(newEntity.getDeadLineTmstmp());
            task.setDone(newEntity.isDone());
        } else {
            throw new EntityAlreadyExistsException(Task.class.getSimpleName());
        }

        if (Validator.isValid(task)) {
            task = taskRepository.save(task);
        } else {
            throw new InvalidDataException(Task.class.getSimpleName(), Arrays.asList("name"));
        }

        return task.getId();

    }

    @Override
    public void delete(Integer id) {
        if (id != null) {
            taskRepository.delete(id);
        }
    }
}
