package Scheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import Process.Task;
public class SJF implements Scheduler, Comparator<Task> {
    @Override
    public void schedule(LinkedList<Task> tasks) {

        Collections.sort(tasks,this);
    }
    @Override
    public SchedulerAlgorithm getAlgorithm() {
        return SchedulerAlgorithm.SJF;
    }

    public String getName() {
        return "SJF";
    }

    @Override
    public int compare(Task task1, Task task2) {
        return task1.getBurstTime()-task2.getBurstTime();
    }
}
