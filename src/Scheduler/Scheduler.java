package Scheduler;

import java.util.ArrayList;
import java.util.LinkedList;

import Process.Task;
public interface Scheduler {
    public void schedule(LinkedList<Task> tasks);
}
