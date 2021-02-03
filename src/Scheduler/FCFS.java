package Scheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import Process.Task;
public class FCFS implements Scheduler, Comparator<Task> {
    @Override
    public void schedule(LinkedList<Task> tasks) {
        Collections.sort(tasks,this);
    }

    @Override
    public SchedulerAlgorithm getAlgorithm() {
        return SchedulerAlgorithm.FCFS;
    }

    @Override
    public int compare(Task task1, Task task2) {
        return task1.getArrivalTime()-task2.getArrivalTime();
    }


}
