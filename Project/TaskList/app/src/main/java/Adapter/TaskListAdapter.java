package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tasklist.R;
import com.example.tasklist.Task;

import java.util.List;

import model.TaskModel;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.InnerHolder> {
    private List<TaskModel> taskList;

    public TaskListAdapter(List<TaskModel> taskList) {
        this.taskList = taskList;
    }

    @Override
    public InnerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tasklist_layout, parent, false);
        return new InnerHolder(itemView);
    }
    @Override
    public void onBindViewHolder(InnerHolder holder, int position) {
        holder.setTask(taskList.get(position));
    }

    @Override
    public int getItemCount() {
        if (taskList != null) {
            return taskList.size();
        }
        return 0;
    }

    public static class InnerHolder extends RecyclerView.ViewHolder{
         private CheckBox checkBox;
         private TextView taskTitle;

         public InnerHolder(View itemView) {
             super(itemView);
             checkBox = itemView.findViewById(R.id.taskCheckBox);
             taskTitle = itemView.findViewById(R.id.taskTitle);
         }

        public void setTask(TaskModel task) {
            taskTitle.setText(task.taskTitle);
        }
    }
}
