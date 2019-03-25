package com.bootcamp.ActivityLog;

import java.util.Objects;

class Activity {
    private String log;
    private String timeStamp;

    Activity(String log) {
        this.log = log;
    }

    public Activity(String log, String timeStamp) {
        this.log = log;
        this.timeStamp = timeStamp;
    }

    @Override
    public boolean equals(Object anotherActivity) {
        if (this == anotherActivity) return true;
        if (anotherActivity == null || getClass() != anotherActivity.getClass()) return false;
        Activity activity = (Activity) anotherActivity;
        return Objects.equals(log, activity.log) &&
                Objects.equals(timeStamp, activity.timeStamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(log, timeStamp);
    }
}
