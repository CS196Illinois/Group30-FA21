package com.example.tasklist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class Task extends AppCompatActivity {

    String[] taskArray = {"A","B","C","D",
            "E","F","G","H"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasklist_layout);
        final Intent i = new Intent(Task.this, MainActivity.class);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.tasklist_layout, taskArray);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.taskRecyclerView);
        recyclerView.setAdapter(adapter);
    }





}
