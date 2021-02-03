import CPU.*;
import Resourses.A;
import Resourses.B;
import Resourses.C;
import Resourses.ResourceManager;
import Scheduler.FCFS;
import Scheduler.SJF;
import Scheduler.*;
import Process.*;

import java.util.*;

public class SchedulingProject {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("select scheduler ");
        System.out.println("1)FCFS");
        System.out.println("2)JSF");
        System.out.println("3)RR");
        int temp = scanner.nextInt();
        Scheduler scheduler;
        switch (temp) {
            case 1:
                scheduler = new FCFS();
                break;
            case 2:
                scheduler = new SJF();
                break;
            case 3:
                scheduler = new RR();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + temp);
        }
        ResourceManager resourceManager = new ResourceManager();
        System.out.println("Enter resource Count A,B,C : ");
        for (int i = 0; i < 3; i++) {
            int n = scanner.nextInt();
            for (int j = 0; j < n; j++) {
                switch (i) {
                    case 0:
                        resourceManager.addResource(new A());
                        break;
                    case 1:
                        resourceManager.addResource(new B());
                        break;
                    case 2:
                        resourceManager.addResource(new C());
                        break;
                }
            }
        }
        CPU cpu = new CPU(scheduler,resourceManager);

        System.out.println("Enter task number");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < taskNumber; i++) {
            Task task=null;
            String[] taskInfo = scanner.nextLine().split(" ");
            switch (taskInfo[1]) {
                case "X":
                    task = new X(Integer.parseInt(taskInfo[2]));
                    break;
                case "Y":
                    task = new Y(Integer.parseInt(taskInfo[2]));
                    break;
                case "Z":
                    task = new Z(Integer.parseInt(taskInfo[2]));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + temp);

            }
            task.setName(taskInfo[0]);
            task.setArrivalTime(i);
            CPU.ready.push(task);
        }

        cpu.processing();

    }
}




/*
*
*  Task t1 = new Task("t1",1);
        t1.setBurstTime(5);
        t1.setWaitingTime(10);

        Task t2 = new Task("t2",1);
        t2.setBurstTime(5);
        t2.setWaitingTime(2);
        Task t3 = new Task("t3",1);
        t3.setBurstTime(6);
        t3.setWaitingTime(10);
        Task t4 = new Task("t4",1);
        t4.setBurstTime(5);
        t4.setWaitingTime(2);
//        Task t5 = new Task(1);
//        t5.setArrivalTime(55);
//        Task t6 = new Task(1);
//        t6.setArrivalTime(2);
//        Task t7 = new Task(1);
//        t7.setArrivalTime(1);

        LinkedList<Task> t = new LinkedList<Task>();
        t.add(t1);
        t.add(t2);
        t.add(t3);
        t.add(t4);
//        t.add(t5);
//        t.add(t6);
//        t.add(t7);

        for (int i =0 ; i< 4; i++){
            System.out.println(t.get(i).getName()+" "+t.get(i).getBurstTime()+ " "+t.get(i).getWaitingTime());

        }
        CPU.waiting=t;
        WaitingScheduler sjf = new WaitingScheduler();
        sjf.schedule();
        //PrintUnit.printQueue();

        System.out.println("----------");
        for (int i =0 ; i< 4; i++){
            System.out.println(t.get(i).getName()+" ");
        }
* */

