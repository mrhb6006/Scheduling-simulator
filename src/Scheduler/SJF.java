package Scheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Process.Task;
public class SJF implements Scheduler, Comparator<Task> {
    @Override
    public void schedule(ArrayList<Task> tasks) {

        Collections.sort(tasks,this);
    }

    public String getName() {
        return "SJF";
    }

    @Override
    public int compare(Task task1, Task task2) {
        return task1.getBurstTime()-task2.getBurstTime();
    }
}
