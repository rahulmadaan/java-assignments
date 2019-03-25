package com.bootcamp.ActivityLog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class ActivityLog {
    private ArrayList<Activity> activities;
    private boolean timeStamp;
    private String timePrecision;


    ActivityLog(boolean timeStamp, String timePrecision) {
        this.timeStamp = timeStamp;
        this.timePrecision = timePrecision;
        this.activities = new ArrayList<>();
    }

    ArrayList<Activity> log(String activity) {
        if(this.timeStamp) {
            String timeStamp = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:mm").format(new Date());
            System.out.println(timeStamp);
            this.activities.add(new Activity(activity, timeStamp));
            return new ArrayList<>(activities);
        }
        this.activities.add(new Activity(activity));
        return new ArrayList<>(activities);
    }

}
