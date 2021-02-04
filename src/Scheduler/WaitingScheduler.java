package Scheduler;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import CPU.CPU;
import Process.Task;
import Resourses.ResourceManager;

public class WaitingScheduler implements Comparator<Task> {

    public synchronized void schedule(){
        CPU.waiting.sort(this);
        for (int i = 0 ; i<CPU.waiting.size() ; i++){
            Task task = CPU.waiting.get(i);
            if (ResourceManager.getInstance().canBeAssign(task)){
                if (task.getWaitingTime()>task.getBurstTime()/2){
                    task.setPriority(task.getPriority()+1);
                }else if(task.getBurstTime()-task.getWaitingTime()<0){
                    task.setPriority(task.getPriority()+2);
                }
                CPU.waiting.remove(i);
                CPU.ready.add(task);
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
