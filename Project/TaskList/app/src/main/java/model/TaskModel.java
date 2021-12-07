package model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.File;
import java.time.LocalDateTime;

public class TaskModel {
    public LocalDateTime ddl;
    public String taskTitle;
    public String taskDescription;
    public File attachedFile;
    public String courseName;
    public boolean submitted = false;
    public int count = 1;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public TaskModel() {
        ddl = LocalDateTime.now();
        taskTitle = "Task" + "(" + count + ")";
        count++;
        taskDescription = "";
        courseName = "";
    }
    public TaskModel(LocalDateTime ddlSet, String taskTitleSet) {
        this.ddl = ddlSet;
        this.taskTitle = taskTitleSet;
    }
    public TaskModel(LocalDateTime ddlSet, String taskNameSet, String courseNameSet, String taskDescriptionSet) {
        this.ddl = ddlSet;
        this.taskTitle = taskNameSet;
        this.taskDescription = taskDescriptionSet;
        this.courseName = courseNameSet;
    }

    public TaskModel(LocalDateTime ddlSet, String taskNameSet, String courseNameSet) {
        this.ddl = ddlSet;
        this.taskTitle = taskNameSet;
        this.courseName = courseNameSet;
    }










    public void setDdl(LocalDateTime ddl) {
        this.ddl = ddl;
    }

    public void setTaskName(String taskName) {
        this.taskTitle = taskName;
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
        return taskTitle;
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
