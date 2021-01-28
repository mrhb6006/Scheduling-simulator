package Process;

import Resourses.Resource;
import Resourses.ResourceType;

public class Task {

    protected String name;
    protected int priority;
    protected final int defaultPriority;
    protected ResourceType[] resources;
    protected int requiredTime;
    protected Status status;
    protected int processTime;


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

    public void setResources(ResourceType[] resources){
        this.resources = resources;
    }

    public ResourceType[] getResources() {
        return resources;
    }

    public int getRequiredTime() {
        return requiredTime;
    }

    public void setRequiredTime(int requiredTime) {
        this.requiredTime = requiredTime;
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


