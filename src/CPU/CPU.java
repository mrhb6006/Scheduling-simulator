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



}
