package CPU;

import java.util.LinkedList;

import Process.Task;

public class QueueManager {
    private static QueueManager queueManager = new QueueManager();

    private LinkedList<Task> ready = new LinkedList<Task>();
    private LinkedList<Task> waiting = new LinkedList<Task>();

    private QueueManager() {
    }

    public static QueueManager getInstance() {
        return queueManager;
    }

    public void addToReadyQueue(Task task) {
        ready.add(task);
    }

    public void addToWaitingQueue(Task task) {
        waiting.add(task);
    }

    public void readyToWaiting(Task task) {
        waiting.add(task);
        ready.remove(task);
    }

    public void waitingToReady(Task task) {
        ready.add(task);
        waiting.remove(task);
    }

    public Task getTaskFromReadyQueue(int index) {
        return ready.get(index);
    }

    public Task getTaskFromWaitingQueue(int index) {
        return waiting.get(index);
    }

    public LinkedList<Task> getReady() {
        return ready;
    }

    public void setReady(LinkedList<Task> ready) {
        this.ready = ready;
    }

    public LinkedList<Task> getWaiting() {
        return waiting;
    }

    public void setWaiting(LinkedList<Task> waiting) {
        this.waiting = waiting;
    }

    public int getReadySize() {
       return ready.size();
    }

    public int getWaitingSize(){
        return waiting.size();
    }

    public Task poll() {
        return ready.pollFirst();
    }

    public void increaseWaitingTimeOfWaitTaskQueue() {
        for (Task task : waiting) {
            task.setWaitingTime(task.getWaitingTime() + 1);
        }
    }
}
