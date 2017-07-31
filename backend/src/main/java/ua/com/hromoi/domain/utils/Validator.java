package ua.com.hromoi.domain.utils;

import ua.com.hromoi.infrastructure.constants.FieldConstraints;
import ua.com.hromoi.infrastructure.models.Project;
import ua.com.hromoi.infrastructure.models.Task;

import java.time.LocalDateTime;

/**
 * Created by Viacheslav_Khromoi on 02.07.2017.
 */
public class Validator {

    /**
     * Check is valid task name
     * @param task
     * @return
     */
    public static boolean isValid(Task task) {
        int length = task.getName().length();
        return (length  >= FieldConstraints.Task.NAME_MIN_LENGTH && length <= FieldConstraints.Task.NAME_MAX_LENGTH);
    }


    /**
     * Check is valid project name
     * @param project
     * @return
     */
    public static boolean isValid(Project project) {
        int length = project.getName().length();
        return (length >= FieldConstraints.Project.NAME_MIN_LENGTH && length <= FieldConstraints.Project.NAME_MAX_LENGTH);
    }
}
