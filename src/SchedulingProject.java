import Process.Task;
import Scheduler.FCFS;
import Scheduler.SJF;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SchedulingProject {

    public static void main(String[] args) {
        Task t1 = new Task(1);
        t1.setArrivalTime(7);
        Task t2 = new Task(1);
        t2.setArrivalTime(5);
        Task t3 = new Task(1);
        t3.setArrivalTime(15);
        Task t4 = new Task(1);
        t4.setArrivalTime(51);
        Task t5 = new Task(1);
        t5.setArrivalTime(55);
        Task t6 = new Task(1);
        t6.setArrivalTime(2);
        Task t7 = new Task(1);
        t7.setArrivalTime(1);

        ArrayList<Task> t = new ArrayList<Task>();
        t.add(t1);
        t.add(t2);
        t.add(t3);
        t.add(t4);
        t.add(t5);
        t.add(t6);
        t.add(t7);

        for (int i =0 ; i< 7; i++){
            System.out.println(t.get(i).getArrivalTime()+" ");
        }

        FCFS sjf = new FCFS();
        sjf.schedule(t);
        System.out.println("----------");
        for (int i =0 ; i< 7; i++){
            System.out.println(t.get(i).getArrivalTime()+" ");
        }
    }
}
