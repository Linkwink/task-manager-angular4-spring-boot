package ua.com.hromoi.infrastructure.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Viacheslav_Khromoi on 02.07.2017.
 */
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String name;

    private boolean isDone;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deadLineTime;

    @Column(name="orderInList")
    private int order;

    @ManyToOne
    private Project tproject;

    public Task() {
    }

    public Task(String name, boolean isDone, LocalDateTime deadLine, int order) {
        this.name = name;
        this.isDone = isDone;
        this.deadLineTime = deadLine;
        this.order = order;
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

    public Project getTproject() {
        return tproject;
    }

    public void setTproject(Project tproject) {
        this.tproject = tproject;
    }
}
