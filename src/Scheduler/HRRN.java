package Scheduler;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import CPU.Time;
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
        int w1 = Time.getCurrentTime()-t1.getArrivalTime();
        int w2 = Time.getCurrentTime()-t2.getArrivalTime();
        int temp = (w1 + t1.getBurstTime())/t1.getBurstTime()-((w2+ t2.getBurstTime()) / t2.getBurstTime());
        if (temp<0){
            return 1;
        }else if (temp>0){
            return -1;
        }
        return 0;
    }
}
