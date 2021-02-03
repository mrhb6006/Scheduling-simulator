package Resourses;

import Process.Task;

import java.util.ArrayList;

public class ResourceManager {
    private ArrayList<Resource> resources = new ArrayList<>();
    private int aAvailableCount = 0;
    private int bAvailableCount = 0;
    private int cAvailableCount = 0;

    public void addResource(Resource resource) {
        resources.add(resource);
    }

    private void countingResources() {
        for (Resource resource : resources) {
            switch (resource.getResourceType()) {
                case A:
                    aAvailableCount++;
                    break;
                case B:
                    bAvailableCount++;
                    break;
                case C:
                    cAvailableCount++;
                    break;
            }
        }
    }

    public synchronized boolean assignResources(Task task) {
        int aR = 0;
        int bR = 0;
        int cR = 0;
        for (ResourceType resourceType : task.getResources()) {
            switch (resourceType) {
                case A:
                    aR++;
                    if (aAvailableCount == 0) {
                        return false;
                    }
                    break;
                case B:
                    bR++;
                    if (bAvailableCount == 0) {
                        return false;
                    }
                    break;
                case C:
                    cR++;
                    if (cAvailableCount == 0) {
                        return false;
                    }
                    break;
            }
        }

        if(aAvailableCount - aR>=0 && bAvailableCount - bR>=0 && cAvailableCount - cR>=0){
            aAvailableCount -= aR;
            bAvailableCount -= bR;
            cAvailableCount -= cR;
            return true;
        }
        return false;

    }

    public synchronized void freeResources(Task task){
        int aR = 0;
        int bR = 0;
        int cR = 0;
        for (ResourceType resourceType : task.getResources()) {
            switch (resourceType) {
                case A:
                    aR++;
                    break;
                case B:
                    bR++;
                    break;
                case C:
                    cR++;
                    break;
            }
        }
        aAvailableCount += aR;
        bAvailableCount += bR;
        cAvailableCount += cR;
    }

    public synchronized boolean canBeAssign(Task task) {
        int aR = 0;
        int bR = 0;
        int cR = 0;
        for (ResourceType resourceType : task.getResources()) {
            switch (resourceType) {
                case A:
                    aR++;
                    if (aAvailableCount == 0) {
                        return false;
                    }
                    break;
                case B:
                    bR++;
                    if (bAvailableCount == 0) {
                        return false;
                    }
                    break;
                case C:
                    cR++;
                    if (cAvailableCount == 0) {
                        return false;
                    }
                    break;
            }
        }

        return aAvailableCount - aR >= 0 && bAvailableCount - bR >= 0 && cAvailableCount - cR >= 0;
    }
}
