package com.firstapp.homeworkview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.firstapp.homeworkview.databinding.ActivityMainBinding;
import com.firstapp.homeworkview.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {

    ActivityUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if (intent != null){

            String name = intent.getStringExtra("Name");
            String meetingTimes = intent.getStringExtra("Meeting Times");
            String description = intent.getStringExtra("Description");

            binding.nameProfile.setText(name);
            binding.phoneProfile.setText(meetingTimes);
            binding.countryProfile.setText(description);




        }

    }
}

