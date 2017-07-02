package ua.com.hromoi.infrastructure.viewmodels.Project;

import ua.com.hromoi.infrastructure.viewmodels.Task.TaskForView;
import ua.com.hromoi.infrastructure.viewmodels.ViewModelForView;

import java.util.List;

/**
 * Created by Viacheslav_Khromoi on 02.07.2017.
 */
public class ProjectForView implements ViewModelForView {

    private int id;
    private String name;
    private List<TaskForView> tasks;

    public ProjectForView() {
    }

    public ProjectForView(int id, String name, List<TaskForView> tasks) {
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

    public List<TaskForView> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskForView> tasks) {
        this.tasks = tasks;
    }
}
