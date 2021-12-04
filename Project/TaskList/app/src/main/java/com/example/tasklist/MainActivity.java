package com.example.tasklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.tasklist.databinding.ActivityMainBinding;
import com.example.tasklist.databinding.ActivityUserBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Button btnAdd;
    Button btnRemove;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //int[] imageId = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,
        // R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i};
        String[] name = {"cs196", "cs124", "cs225", "math241", "econ102", "Phy212", "rhet105", "eng100", "stat400"};
        String[] subject = {"CS", "CS", "CS", "Math", "Econ",
                "physics", "writing", "engineering", "statistics"};
        String[] date = {"Monday", "Monday", "Monday", "Monday", "Monday",
                "Monday", "Monday", "Monday", "Monday"};
        String[] meetTime = {"8:45 pm", "9:00 pm", "7:34 pm", "6:32 am", "5:76 am",
                "5:00 am", "7:34 pm", "2:32 am", "7:76 am"};
        String[] description = {"cs honors", "intro to cs", "data structures",
                "calculus 3", "microeconomics", "mechanical physics", "writing course",
                "engineering college intro", "statistics & probability"};

        ArrayList<User> userArrayList = new ArrayList<>();

        for (int i = 0; i < name.length; i++) {

            User user = new User(name[i], subject[i], date[i], meetTime[i], description[i]);
            userArrayList.add(user);

        }


        ListAdaptor listAdaptor = new ListAdaptor(MainActivity.this, userArrayList);

        binding.listview.setAdapter(listAdaptor);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User pos = userArrayList.get(position);

                Intent i = new Intent(MainActivity.this, UserActivity.class);
                i.putExtra("name", pos.getName()); //name[position]
                i.putExtra("meetTime", pos.meetTime);
                i.putExtra("description", pos.description);
                startActivity(i);

            }
        });


        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnRemove = (Button) findViewById(R.id.btnRemove);
        editText = (EditText) findViewById(R.id.et_name);

        //add button
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userString = editText.getText().toString();
                String[] userStringList = userString.split(",");
                if (userStringList.length == 5) {
                    for (int i = 0; i < userStringList.length; i++) {
                        userStringList[i].trim();
                    }
                    User user = new User(userStringList[0], userStringList[1], userStringList[2], userStringList[3], userStringList[4]);
                    userArrayList.add(user);
                    binding.listview.setAdapter(listAdaptor);
                    listAdaptor.notifyDataSetChanged();
                } else {
                    final Toast toast = Toast.makeText(MainActivity.this, "invalid input", Toast.LENGTH_SHORT);
                    toast.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 1000);
                }

            }
        });

        //remove button
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < userArrayList.size(); i++) {
                    String getName = editText.getText().toString();
                    if (userArrayList.get(i).getName().equals(getName)) {
                        userArrayList.remove(i);

                        listAdaptor.notifyDataSetChanged();
                    } else {
                        final Toast toast = Toast.makeText(MainActivity.this, "no items name matched", Toast.LENGTH_SHORT);
                        toast.show();
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                toast.cancel();
                            }
                        }, 1000);
                    }
                }

            }
        });

    }
}