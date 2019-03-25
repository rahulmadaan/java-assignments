package com.bootcamp.ActivityLog;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ActivityLogTest {
    @Test
    void shouldReturnLogOfActivitiesWithoutTimestamp() {
        ActivityLog activityLog = new ActivityLog(false, "ss");
        ArrayList<Activity> logs = activityLog.log("some text");


        Activity activity = new Activity("some text");
        ArrayList<Activity> expected = new ArrayList<>(asList(activity));
        assertEquals(expected, logs);
    }

    @Test
    void shouldReturnLogOfActivitiesWithTimestamp() {
        ActivityLog activityLog = new ActivityLog(true, "ss");
        ArrayList<Activity> logs = activityLog.log("some text");


        Activity activity = new Activity("some text");
        ArrayList<Activity> expected = new ArrayList<>(asList(activity));
        assertEquals(expected, logs);
    }




}