package ua.com.hromoi.infrastructure.viewmodels.Task;

import ua.com.hromoi.infrastructure.viewmodels.ViewModelForView;

import java.time.LocalDateTime;

/**
 * Created by Viacheslav_Khromoi on 02.07.2017.
 */
public class TaskForView implements ViewModelForView {

    private int id;
    private String name;
    private boolean isDone;
    private LocalDateTime deadLineTime;
    private int order;
    private int projectId;

    public TaskForView() {
    }

    public TaskForView(int id, String name, boolean isDone, LocalDateTime deadLineTmstmp, int order, int projectId) {
        this.id = id;
        this.name = name;
        this.isDone = isDone;
        this.deadLineTime = deadLineTmstmp;
        this.order = order;
        this.projectId = projectId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
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

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public LocalDateTime getDeadLineTime() {
        return deadLineTime;
    }

    public void setDeadLineTime(LocalDateTime deadLineTime) {
        this.deadLineTime = deadLineTime;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
