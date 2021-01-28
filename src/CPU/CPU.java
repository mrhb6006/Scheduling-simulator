package CPU;

import Process.Task;
import Scheduler.Scheduler;

import java.util.ArrayList;

public class CPU {
    private  Core[] cores = new Core[4] ;
    private PrintUnit printUnit = new PrintUnit();
    private ArrayList<Task> ready = new ArrayList<Task>();
    private ArrayList<Task> waiting = new ArrayList<Task>();
    private  Scheduler scheduler;

}
