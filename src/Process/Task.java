package Process;

import Resourses.ResourceType;

public class Task{

    protected String name;
    protected int priority;
    protected final int defaultPriority;
    protected ResourceType[] resources;
    protected int burstTime;
    protected Status status;
    protected int processTime;
    protected int remainingTime;
    protected int arrivalTime ;
    protected boolean isDone =  false;


    public Task(int defaultPriority) {
        this.defaultPriority = defaultPriority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getDefaultPriority() {
        return defaultPriority;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public void setResources(ResourceType[] resources){
        this.resources = resources;
    }

    public ResourceType[] getResources() {
        return resources;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getProcessTime() {
        return processTime;
    }

    public void setProcessTime(int processTime) {
        this.processTime = processTime;
    }


}


