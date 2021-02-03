package CPU;

import Process.Task;
import Resourses.ResourceManager;
import Scheduler.*;

import java.util.LinkedList;

public class CPU {
    private  Core[] cores = new Core[4] ;
    public static LinkedList<Task> ready = new LinkedList<Task>();
    public static LinkedList<Task> waiting = new LinkedList<Task>();
    public static ResourceManager resourceManager;
    private  Scheduler scheduler;
    public static WaitingScheduler waitingScheduler = new WaitingScheduler();

    public CPU(Scheduler scheduler ,ResourceManager resourceManager){
        this.scheduler = scheduler;
        this.setResourceManager(resourceManager);
        resourceManager.countingResources();
        for (int i = 0 ; i<cores.length; i++){
            cores[i]= new Core();
            cores[i].name = "Core "+i;
            cores[i].setAlgorithm(scheduler.getAlgorithm());
        }
    }



    public void processing (){
        for (int i = 0 ; i<cores.length; i++){
            cores[i].start();
        }
        while (ready.size()>0 || waiting.size()>0 || isBusyThreads()){
            scheduler.schedule(ready);
            for (int i=0 ; i<cores.length;i++){
                if (cores[i].isFree()){
                    Task task = getHighestPriority();
                    if (task!=null){
                        if (resourceManager.assignResources(task)){
                            cores[i].assignTask(task);
                        }else {
                            waiting.push(task);
                        }
                    }
                }
            }
            PrintUnit.printQueue();
            for (Core core : cores){
                PrintUnit.printCoreInfo(core);
            }
            increaseWaiting();
            Time.increaseTime();
            increaseThreadTime();
        }
    }

    private void increaseThreadTime() {
        for (int i=0 ; i<cores.length;i++){
            cores[i].setTime(cores[i].getTime()+1);
        }
    }

    public boolean isBusyThreads(){
        for (Core core : cores) {
            if (!core.isFree()) {
                return true;
            }
        }
        return false;
    }

    public Task getHighestPriority(){
        Task highestPriorityTask = new Task(1);
        int index = 0;
        for (int i=0 ; i<ready.size(); i++){
            if (ready.get(i).getPriority()>highestPriorityTask.getPriority()){
                highestPriorityTask = ready.get(i);
                index = i;
            }
        }
        return ready.pollFirst();
    }

    public ResourceManager getResourceManager() {
        return resourceManager;
    }

    public void setResourceManager(ResourceManager resourceManager) {
        CPU.resourceManager = resourceManager;
    }

    private void increaseWaiting(){
        for (Task task: waiting){
            task.setWaitingTime(task.getWaitingTime()+1);
        }
    }

}
