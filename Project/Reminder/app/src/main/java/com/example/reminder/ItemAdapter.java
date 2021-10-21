package com.example.reminder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {
    private ArrayList<Item> mList;


    public static class ItemHolder extends RecyclerView.ViewHolder {
        public TextView mtextView;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            mtextView = itemView.findViewById(R.id.textView);
        }
    }
    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent,false);
        ItemHolder itm = new ItemHolder(v);
        return itm;
    }
    public ItemAdapter(ArrayList<Item> arrayList) {
        mList = arrayList;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Item current = mList.get(position);
        holder.mtextView.setText(current.getTextView());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }



}
