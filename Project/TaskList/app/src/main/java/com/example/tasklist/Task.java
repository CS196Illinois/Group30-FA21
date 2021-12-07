package com.example.tasklist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import Adapter.TaskListAdapter;
import model.FakeData;

public class Task extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FakeData.faking();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasklist_layout);

        RecyclerView taskList = (RecyclerView) findViewById(R.id.taskRecyclerView);

        TaskListAdapter adapter = new TaskListAdapter(FakeData.fakeList);

        taskList.setAdapter(adapter);





    }





}
