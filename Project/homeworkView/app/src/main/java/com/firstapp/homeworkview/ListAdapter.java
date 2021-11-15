package com.firstapp.homeworkview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<User> {

    public ListAdapter(Context context, ArrayList<User> userArrayList) {
        super(context,R.layout.list_item,userArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        User user = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        TextView name= convertView.findViewById(R.id.course);
        TextView meeting = convertView.findViewById(R.id.meetingTimes);
        TextView time = convertView.findViewById(R.id.specificTime);

        name.setText(user.name);
        meeting.setText(user.description);
        time.setText(user.meetingTimes);

        return convertView;

    }

}
