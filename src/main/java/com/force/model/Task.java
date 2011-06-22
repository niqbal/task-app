package com.force.model;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: niqbal
 * Date: 6/20/11
 * Time: 11:19 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;

    String name;

    String desc;

    @ManyToOne
    Project project;

    public Task() {
    }

    public Task(String id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        String format = "Id:%s; Name:%s; Description:%s";
        return String.format(format,id, name, desc);
    }
}
