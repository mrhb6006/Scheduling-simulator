package Scheduler;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import Process.Task;


public class HRRN implements Scheduler, Comparator<Task> {

    @Override
    public void schedule(LinkedList<Task> tasks) {
        Collections.sort(tasks,this);
    }

    @Override
    public SchedulerAlgorithm getAlgorithm() {
        return SchedulerAlgorithm.HRRN;
    }

    @Override
    public int compare(Task t1, Task t2) {
        return ((t1.getWaitingTime() + t1.getBurstTime()) / t1.getBurstTime()) - ((t2.getWaitingTime() + t2.getBurstTime()) / t2.getBurstTime());
    }
}
