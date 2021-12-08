package com.example.tasklist;

import static com.example.tasklist.CalendarUtils.dateInMonth;
import static com.example.tasklist.CalendarUtils.monthYearFromDate;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;

import Adapter.CalendarAdapter;

public class MainActivity_Monthly_Calendar extends AppCompatActivity implements CalendarAdapter.OnItemListener {

    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private CalendarAdapter.OnItemListener onItemListener;



    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_monthly_calendar);
        initWidget();
        CalendarUtils.selectedDate = LocalDate.now();
        onItemListener = new CalendarAdapter.OnItemListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getApplicationContext(), MainActivity_Weekly_Calendar.class);
                startActivity(intent);
            }
        };
        setMonthView();

    }




    private void initWidget() {
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.Month);

    }



    private void setMonthView() {

        monthYearText.setText(monthYearFromDate(CalendarUtils.selectedDate));
        ArrayList<LocalDate> dateInMonth = dateInMonth(CalendarUtils.selectedDate);
        CalendarAdapter calendarAdapter = new CalendarAdapter(dateInMonth, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);

    }

    private void setOnClickListener() {

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void previousMonth(View view) {
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.minusMonths(1);
        setMonthView();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void nextMonth(View view) {
        CalendarUtils.selectedDate = CalendarUtils.selectedDate.plusMonths(1);
        setMonthView();
    }
    @Override
    public void onItemClick(int position) {
        startActivity(new Intent(this, MainActivity_Weekly_Calendar.class));
    }

    public void weekly(View view) {
        startActivity(new Intent(this, MainActivity_Weekly_Calendar.class));
    }
}