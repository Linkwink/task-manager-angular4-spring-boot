package ua.com.hromoi.infrastructure.mappers;

import ua.com.hromoi.infrastructure.models.Project;
import ua.com.hromoi.infrastructure.viewmodels.Project.ProjectAsListItem;
import ua.com.hromoi.infrastructure.viewmodels.Project.ProjectForView;
import ua.com.hromoi.infrastructure.viewmodels.Task.TaskAsListItem;
import ua.com.hromoi.infrastructure.viewmodels.Task.TaskForView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Viacheslav_Khromoi on 02.07.2017.
 */
public class ProjectMapper {
    public static ProjectForView mapView(Project project) {
        List<TaskForView> tasks = new ArrayList<>();
        project
                .getTasks()
                .forEach(s -> tasks.add(TaskMapper.mapView(s)));
        tasks
                .sort(Comparator.comparingInt(TaskForView::getOrder));
        return new ProjectForView(
                project.getId(),
                project.getName(),
                tasks
        );
    }

    public static ProjectAsListItem mapListItem(Project project) {
        List<TaskAsListItem> tasks = new ArrayList<>();
        project
                .getTasks()
                .forEach(s -> tasks.add(TaskMapper.mapListItem(s)));
        tasks
                .sort(Comparator.comparingInt(TaskAsListItem::getOrder));
        return new ProjectAsListItem(
                project.getId(),
                project.getName(),
                tasks
        );
    }
}
