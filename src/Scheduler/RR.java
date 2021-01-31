package Scheduler;

import java.util.ArrayList;
import java.util.Comparator;
import Process.Task;

public class RR implements Scheduler, Comparator {
    @Override
    public void schedule(ArrayList<Task> tasks) {

    }

    @Override
    public int compare(Object o, Object t1) {
        return 0;
    }
}
