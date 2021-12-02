package model;

import android.os.Build;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FakeData {
    public static LocalDateTime fakeDdl = LocalDateTime.of(2002, 9, 28,22, 24);
    public static List<TaskModel> fakeList = new ArrayList<>();

    public static void faking() {
        for(int i=0; i < 6 ; i++) {
        fakeList.add(new TaskModel(fakeDdl, "Fake Title"));
    }}




}
