package Process;

import Resourses.ResourceType;

import static Resourses.ResourceType.*;

public class Y extends Task {
    private final static  int priority = 2;
    public Y(int requiredTime) {
        super(priority);
        setBurstTime(requiredTime);
        setResources(new ResourceType[]{C,B});
    }
}
