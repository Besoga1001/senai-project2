package com.senai.project2.models;

import jakarta.persistence.*;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
public class TaskModel {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(name="tsk_id")
    private Integer id;

    @Column(name="tsk_description")
    private String description;

    @Column(name="tsk_priority")
    private Integer priority;

    @ManyToOne
    @JoinColumn(name = "usr_id")
    private UserModel user;

    @Column(name="tsk_created_at")
    private LocalDate createdAt;

    @Column(name = "tsk_updated_at")
    private LocalDate updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
