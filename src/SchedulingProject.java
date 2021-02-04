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
        int quantum=1;
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
                System.out.println("enter quantum : ");
                quantum = scanner.nextInt();
                scanner.nextLine();

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + temp);
        }
        if (scheduler instanceof RR){
           ((RR) scheduler).quantum = quantum;
        }
        ResourceManager resourceManager = ResourceManager.getInstance();
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
        CPU cpu = new CPU(scheduler);

        System.out.println("Enter task number");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter Task info");

        for (int i = 0; i < taskNumber; i++) {
            Task task = null;
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
            CPU.ready.add(task);
        }

        cpu.processing();
        System.exit(0);
    }
}
