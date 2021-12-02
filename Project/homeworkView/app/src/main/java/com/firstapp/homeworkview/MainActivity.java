package com.firstapp.homeworkview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.firstapp.homeworkview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button button;
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);

        String[] name = {"CS124", "cs196", "RHET105"};
        String[] meetingTimes = {"8:00 am Monday", "4:00 pm Tuesday", "11:30 Thursday"};
        String[] description = {"intro to computer science", "cs 124 honors", "intro to college writing"};

        ArrayList<User> userArrayList = new ArrayList<>();

        for (int i = 0; i < name.length; i++) {
            User user = new User(name[i], meetingTimes[i],description[i]);
            userArrayList.add(user);
        }

        ListAdapter listAdapter = new ListAdapter(MainActivity.this,userArrayList);

        binding.listView.setAdapter(listAdapter);
        binding.listView.setClickable(true);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(MainActivity.this,UserActivity.class);
                i.putExtra("Name", name[position]);
                i.putExtra("Meeting Times", meetingTimes[position]);
                i.putExtra("Description", description[position]);
                startActivity(i);
            }
        });


    /*
        button = (Button) findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditor();
            }
        });

     */
    }


    public void openEditor() {
        Intent intent = new Intent(this, ScrollingFragmentHWView.class);
        startActivity(intent);
    }


    /*
    // create an action bar button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // R.menu.  is a reference to an xml file named mymenu.xml which should be inside your res/menu directory.
        // If you don't have res/menu, just create a directory named "menu" inside res
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mybutton) {
            // do something here
        }
        return super.onOptionsItemSelected(item);
    }
    */


}