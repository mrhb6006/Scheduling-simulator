package CPU;

import Process.Task;
import Resourses.ResourceManager;
import Scheduler.*;

import java.util.LinkedList;

public class CPU {
    public Core[] cores = new Core[4];
    QueueManager queueManager;
    private ResourceManager resourceManager;
    private Scheduler scheduler;
    public static boolean finish = false;
    public static WaitingScheduler waitingScheduler = new WaitingScheduler();
    PrintUnit printUnit;


    public CPU(Scheduler scheduler) {
        this.scheduler = scheduler;
        queueManager = QueueManager.getInstance();
        resourceManager = ResourceManager.getInstance();
        resourceManager.countingResources();
        for (int i = 0; i < cores.length; i++) {
            cores[i] = new Core();
            cores[i].name = "Core " + (i + 1);
            cores[i].setAlgorithm(scheduler.getAlgorithm());
            if (scheduler instanceof RR) {
                cores[i].setQuantum(((RR) scheduler).quantum);
            }
        }
        printUnit = new PrintUnit(this.cores);
    }


    public void processing() {
        printUnit.start();
        for (int i = 0; i < cores.length; i++) {
            cores[i].start();
        }

        scheduler.schedule(queueManager.getReady());
        printUnit.print();

        while (queueManager.getReadySize() > 0 || queueManager.getWaitingSize() > 0
                || isBusyThreads()) {
            scheduler.schedule(queueManager.getReady());
            for (int i = 0; i < cores.length && queueManager.getReadySize() > 0; i++) {
                if (cores[i].isFree()) {
                    Task task = getHighestPriority();
                    if (task != null) {
                        if (resourceManager.assignResources(task)) {
                            cores[i].assignTask(task);
                        } else {
                            queueManager.readyToWaiting(task);
                            i--;
                        }
                    }
                }
            }

            //PrintUnit.print=true;
            Time.increaseTime();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            queueManager.increaseWaitingTimeOfWaitTaskQueue();
            printUnit.print();
            execute();
        }

        printUnit.print();
        printUnit.printIdleTime();
        finish = false;
    }

    private void execute() {
        for (int i = 0; i < cores.length; i++) {
            if (!cores[i].isFree()) {
                cores[i].doTask();
            } else {
                cores[i].setIdleTime(cores[i].getIdleTime() + 1);
            }
        }
    }

    private void execute2() {
        for (int i = 0; i < cores.length; i++) {
            if (!cores[i].isFree()) {
                cores[i].doTask();
            } else {
                cores[i].setIdleTime(cores[i].getIdleTime() + 1);
            }
        }
    }


    public boolean isBusyThreads() {
        for (Core core : cores) {
            if (!core.isFree()) {
                return true;
            }
        }
        return false;
    }

    public Task getHighestPriority() {
        Task highestPriorityTask = new Task(1);
        for (int i = 0; i < queueManager.getReadySize(); i++) {
            if (queueManager.getTaskFromReadyQueue(i).getPriority() > highestPriorityTask.getPriority()) {
                highestPriorityTask = queueManager.getTaskFromReadyQueue(i);
            }
        }
        return queueManager.poll();
    }

}
