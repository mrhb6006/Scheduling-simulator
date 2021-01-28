package Scheduler;

import java.util.ArrayList;
import java.util.Collections;

import Process.Task;
public class SJF implements Scheduler {

    @Override
    public void schedule(ArrayList<Task> tasks) {
        Collections.sort(tasks);
    }
}
