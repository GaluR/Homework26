package pl.javastart.todo.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Task {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long ID;
    private String title;
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate taskTerm;

    @Enumerated(EnumType.STRING)
    private TaskComplited complited;

    public TaskComplited getComplited() {
        return complited;
    }

    public void setComplited(TaskComplited complited) {
        this.complited = complited;
    }

    public Task(String title, String description, LocalDate taskTerm, TaskComplited complited) {
        this.title = title;
        this.description = description;
        this.taskTerm = taskTerm;
        this.complited = complited;
    }

    public Task() {
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTaskTerm() {
        return taskTerm;
    }

    public void setTaskTerm(LocalDate taskTerm) {
        this.taskTerm = taskTerm;
    }

}
