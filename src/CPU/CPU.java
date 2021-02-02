package CPU;

import Process.Task;
import Scheduler.Scheduler;

import java.util.LinkedList;

public class CPU {
    private  Core[] cores = new Core[4] ;
    private PrintUnit printUnit = new PrintUnit();
    private LinkedList<Task> ready = new LinkedList<Task>();
    private LinkedList<Task> waiting = new LinkedList<Task>();
    private  Scheduler scheduler;

    public CPU(Scheduler scheduler){
        this.scheduler = scheduler;
        for (int i = 0 ; i<cores.length; i++){
            cores[i]= new Core();
        }
    }

    public void Processing (){
        for (int i = 0 ; i<cores.length; i++){
            cores[i].start();
        }
        while (ready.size()>0 || waiting.size()>0){
            scheduler.schedule(ready);
            for (int i=0 ; i<cores.length;i++){
                if (cores[i].isFree()){
                    Task task = getHighestPriority();
                    if (task!=null){
                        cores[i].assignTask(task);
                    }
                }
            }

        }
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

}
