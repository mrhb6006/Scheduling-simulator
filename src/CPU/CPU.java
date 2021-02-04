package CPU;

import Process.Task;
import Resourses.ResourceManager;
import Scheduler.*;
import java.util.LinkedList;

public class CPU {
    public Core[] cores = new Core[4];
    public static LinkedList<Task> ready = new LinkedList<Task>();
    public static LinkedList<Task> waiting = new LinkedList<Task>();
    private ResourceManager resourceManager;
    private Scheduler scheduler;
    public static boolean finish = false;
    public static WaitingScheduler waitingScheduler = new WaitingScheduler();
    PrintUnit printUnit;


    public CPU(Scheduler scheduler) {
        this.scheduler = scheduler;
        resourceManager = ResourceManager.getInstance();
        resourceManager.countingResources();
        for (int i = 0; i < cores.length; i++) {
            cores[i] = new Core();
            cores[i].name = "Core " + (i + 1);
            cores[i].setAlgorithm(scheduler.getAlgorithm());
            if (scheduler instanceof RR){
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

        scheduler.schedule(ready);
        printUnit.print();

        while (ready.size() > 0 || waiting.size() > 0 || isBusyThreads()) {
            scheduler.schedule(ready);
            for (int i = 0; i < cores.length && ready.size() > 0; i++) {
                if (cores[i].isFree()) {
                    Task task = getHighestPriority();
                    if (task != null) {
                        if (resourceManager.assignResources(task)) {
                            cores[i].assignTask(task);
                        } else {
                            waiting.add(task);
                            i--;
                        }
                    }
                }
            }

            Time.increaseTime();
            increaseWaiting();
            printUnit.print();
            execute();
        }

        printUnit.print();
        printUnit.printIdleTime();
        finish = false;
    }

    private void execute() {
        for (int i = 0; i < cores.length; i++) {
            if (!cores[i].isFree()){
                cores[i].doTask();
            }else {
                cores[i].setIdleTime(cores[i].getIdleTime()+1);
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
        for (int i = 0; i < ready.size(); i++) {
            if (ready.get(i).getPriority() > highestPriorityTask.getPriority()) {
                highestPriorityTask = ready.get(i);
            }
        }
        return ready.pollFirst();
    }

    private void increaseWaiting() {
        for (Task task : waiting) {
            task.setWaitingTime(task.getWaitingTime() + 1);
        }
    }

}
