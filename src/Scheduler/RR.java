package Scheduler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

import Process.Task;

public class RR implements Scheduler, Comparator {
    public int quantum = 1;
    @Override
    public void schedule(LinkedList<Task> tasks) {

    }

    @Override
    public SchedulerAlgorithm getAlgorithm() {
        return SchedulerAlgorithm.RR;
    }

    @Override
    public int compare(Object o, Object t1) {
        return 0;
    }
}
