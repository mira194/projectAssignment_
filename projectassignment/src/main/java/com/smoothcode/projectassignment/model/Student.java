package com.smoothcode.projectassignment.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "average")
    private double average;
    @ManyToMany
    @JoinTable(
            name = "student_project",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    @OrderColumn(name = "project_order")
    private List<Project> projects;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void setAverage(double average) {
        this.average = average;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAverage() {
        return average;
    }

    public List<Project> getProjects() {
        return projects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", average=" + average +
                ", projects=" + projects +
                '}';
    }
}
