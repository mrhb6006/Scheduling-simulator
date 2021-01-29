package Scheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Process.Task;
public class FCFS implements Scheduler, Comparator<Task> {
    @Override
    public void schedule(ArrayList<Task> tasks) {
        Collections.sort(tasks,this);
    }

    @Override
    public int compare(Task task1, Task task2) {
        return task1.getArrivalTime()-task2.getArrivalTime();
    }
}
