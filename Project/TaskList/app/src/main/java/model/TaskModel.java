package model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.File;
import java.time.LocalDateTime;

public class TaskModel {
    private LocalDateTime ddl;
    private String taskName;
    private String taskDescription;
    private File attachedFile;
    private String courseName;
    private boolean submitted = false;
    private int count = 1;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public TaskModel() {
        ddl = LocalDateTime.now();
        taskName = "Task" + "(" + count + ")";
        count++;
        taskDescription = "";
        courseName = "";
    }
    public TaskModel(LocalDateTime ddlSet, String taskNameSet) {
        this.ddl = ddlSet;
        this.taskName = taskNameSet;
    }
    public TaskModel(LocalDateTime ddlSet, String taskNameSet, String courseNameSet, String taskDescriptionSet) {
        this.ddl = ddlSet;
        this.taskName = taskNameSet;
        this.taskDescription = taskDescriptionSet;
        this.courseName = courseNameSet;
    }

    public TaskModel(LocalDateTime ddlSet, String taskNameSet, String courseNameSet) {
        this.ddl = ddlSet;
        this.taskName = taskNameSet;
        this.courseName = courseNameSet;
    }










    public void setDdl(LocalDateTime ddl) {
        this.ddl = ddl;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setAttachedFile(File attachedFile) {
        this.attachedFile = attachedFile;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }

    public final void addTask() {

    }

    public LocalDateTime getDdl() {
        return ddl;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public File getAttachedFile() {
        return attachedFile;
    }

    public String getCourseName() {
        return courseName;
    }

    public boolean isSubmitted() {
        return submitted;
    }
}
