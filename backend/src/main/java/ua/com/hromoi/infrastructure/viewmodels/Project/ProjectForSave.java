package ua.com.hromoi.infrastructure.viewmodels.Project;

import ua.com.hromoi.infrastructure.viewmodels.Task.TaskForSave;
import ua.com.hromoi.infrastructure.viewmodels.ViewModelForSave;

import java.util.List;

/**
 * Created by Viacheslav_Khromoi on 02.07.2017.
 */
public class ProjectForSave implements ViewModelForSave {

    private int id;
    private String name;
    private List<TaskForSave> tasks;

    public ProjectForSave() {
    }

    public ProjectForSave(int id, String name, List<TaskForSave> tasks) {
        this.id = id;
        this.name = name;
        this.tasks = tasks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskForSave> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskForSave> tasks) {
        this.tasks = tasks;
    }
}
