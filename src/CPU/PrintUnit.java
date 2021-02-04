package CPU;

import Resourses.ResourceManager;

import java.util.Arrays;

public class PrintUnit extends Thread {

    public static boolean print = false;
    private Core[] cores;
    public PrintUnit(Core[] cores){
        this.cores= cores;
    }

    @Override
    public void run() {
        while (!CPU.finish) {
            if (print) {
                print();
            }
        }
    }

    public void printCoreInfo() {
        for (Core core : cores) {
            System.out.println(core);
        }
    }

    public synchronized void print(){
        printQueue();
        printCoreInfo();
        ResourceManager.getInstance().printResource();
        System.out.println("********************");
        System.out.flush();
        print = false;
    }

    public void printQueue() {
        System.out.println("Time: " + (Time.getCurrentTime()));
        System.out.println("ready queue: " + Arrays.toString(QueueManager.getInstance().getReady().toArray()));
        System.out.println("waiting queue: " + Arrays.toString(QueueManager.getInstance().getWaiting().toArray()));
    }

    public void printIdleTime(){
        for (Core core: cores){
            System.out.println(core.name+" idleTime : "+core.getIdleTime());
        }
    }
}
