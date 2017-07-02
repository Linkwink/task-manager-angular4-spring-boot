package ua.com.hromoi.infrastructure.models;

import javax.persistence.*;

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

    private long deadLineTmstmp;

    @Column(name="orderInList")
    private int order;

    @ManyToOne
    private Project tproject;

    public Task() {
    }

    public Task(String name, boolean isDone, long deadLine, int order) {
        this.name = name;
        this.isDone = isDone;
        this.deadLineTmstmp = deadLine;
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

    public long getDeadLineTmstmp() {
        return deadLineTmstmp;
    }

    public void setDeadLineTmstmp(long deadLineTmstmp) {
        this.deadLineTmstmp = deadLineTmstmp;
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
