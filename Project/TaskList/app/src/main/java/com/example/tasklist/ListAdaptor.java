package com.example.tasklist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListAdaptor extends ArrayAdapter<User> {
    public ListAdaptor(Context context, ArrayList<User> userArrayList) {
        super(context,R.layout.list_item,userArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        User user = getItem(position);

        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        }


        TextView userName = convertView.findViewById(R.id.courseName);
        TextView lastMsg = convertView.findViewById(R.id.subject);
        TextView time = convertView.findViewById(R.id.date);


        userName.setText(user.name);
        lastMsg.setText(user.subject);
        time.setText(user.date);


        return convertView;
    }


}
