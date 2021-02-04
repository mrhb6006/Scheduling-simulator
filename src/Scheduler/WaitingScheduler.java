package Scheduler;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import CPU.*;
import Process.Task;
import Resourses.ResourceManager;

public class WaitingScheduler implements Comparator<Task> {

    public synchronized void schedule(){

        LinkedList<Task> waiting = QueueManager.getInstance().getWaiting();
        waiting.sort(this);
        for (int i = 0 ; i<waiting.size() ; i++){
            Task task = waiting.get(i);
            if (ResourceManager.getInstance().canBeAssign(task)){
                if (task.getWaitingTime()>task.getBurstTime()/2){
                    task.setPriority(task.getPriority()+1);
                }else if(task.getBurstTime()-task.getWaitingTime()<0){
                    task.setPriority(task.getPriority()+2);
                }
                QueueManager.getInstance().waitingToReady(task);
            }
        }
    }

    @Override
    public int compare(Task t1, Task t2) {
        int t1Time = t1.getBurstTime()-t1.getWaitingTime();
        int t2Time = t2.getBurstTime()-t2.getWaitingTime();
        if (t1Time>t2Time){
            return 1;
        }else if (t1Time<t2Time){
            return -1;
        }
        return 0;
    }
}
