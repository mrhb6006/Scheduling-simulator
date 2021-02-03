package CPU;

import Process.Task;

public class Core extends Thread {
    public String name;
    private int idleTime = 0;
    private Task activeTask;
    private SchedulerAlgorithm algorithm;
    private int quantum = 1;

    @Override
    public void run() {
        while (true){
            if (activeTask != null) {
                doTask();
            } else {
                idleTime++;
            }
        }
    }

    private void doTask() {
        switch (algorithm) {
            case RR:
                doTaskWithQuantum();
                break;
            case SJF:
            case FCFS:
                doTaskWithoutQuantum();
                break;
        }
        if (!activeTask.isDone()){
            CPU.ready.push(activeTask);
            CPU.resourceManager.freeResources(activeTask);
        }
        activeTask = null;
    }

    private void doTaskWithoutQuantum() {
        while (activeTask.getRemainingTime() != 0) {
            activeTask.setProcessTime(activeTask.getProcessTime() + 1);
        }
    }

    private void doTaskWithQuantum() {
        int time = 0;
        while (time != quantum) {
            activeTask.setProcessTime(activeTask.getProcessTime() + 1);
            time++;
        }
    }


    public int getIdleTime() {
        return idleTime;
    }

    public boolean isFree() {
        return activeTask==null;
    }

    public void assignTask(Task Task) {
        this.activeTask = Task;
    }

    public SchedulerAlgorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(SchedulerAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public int getQuantum() {
        return quantum;
    }

    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }

    public Task getActiveTask() {
        return activeTask;
    }

    public void setActiveTask(Task activeTask) {
        this.activeTask = activeTask;
    }
}

enum SchedulerAlgorithm {SJF, FCFS, RR}
