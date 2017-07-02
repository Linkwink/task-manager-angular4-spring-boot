package ua.com.hromoi.infrastructure.mappers;

import ua.com.hromoi.infrastructure.models.Task;
import ua.com.hromoi.infrastructure.viewmodels.Task.TaskAsListItem;
import ua.com.hromoi.infrastructure.viewmodels.Task.TaskForView;

/**
 * Created by Viacheslav_Khromoi on 02.07.2017.
 */
public class TaskMapper {
    public static TaskForView mapView(Task task) {
        return new TaskForView(
                task.getId(),
                task.getName(),
                task.isDone(),
                task.getDeadLineTmstmp(),
                task.getOrder()
        );
    }

    public static TaskAsListItem mapListItem(Task task) {
        return new TaskAsListItem(
                task.getId(),
                task.getName(),
                task.isDone(),
                task.getDeadLineTmstmp(),
                task.getOrder()
        );
    }
}
