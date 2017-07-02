package ua.com.hromoi.infrastructure.viewmodels.Project;

import ua.com.hromoi.infrastructure.viewmodels.Task.TaskAsListItem;
import ua.com.hromoi.infrastructure.viewmodels.ViewModelAsListItem;

import java.util.List;

/**
 * Created by Viacheslav_Khromoi on 02.07.2017.
 */
public class ProjectAsListItem implements ViewModelAsListItem {

    private int id;
    private String name;
    private List<TaskAsListItem> tasks;

    public ProjectAsListItem() {
    }

    public ProjectAsListItem(int id, String name, List<TaskAsListItem> tasks) {
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

    public List<TaskAsListItem> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskAsListItem> tasks) {
        this.tasks = tasks;
    }
}
