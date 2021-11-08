package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tasklist.R;
import com.example.tasklist.Task;

import java.util.List;

import model.TaskModel;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.ViewHolder>{
    private List<TaskModel> taskList;
    private Task activity;

    public TaskListAdapter(Task activity) {
        this.activity = activity;
    }

    public ViewHolder onCreatViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_layout, parent, false);
        return new ViewHolder(itemView);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        TaskModel item = 
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
         CheckBox task;

         ViewHolder(View view) {
             super(view);
             task = view.findViewById(R.id.taskCheckBox);
         }

    }
}
