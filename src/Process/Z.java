package Process;

import Resourses.ResourceType;

import static Resourses.ResourceType.*;

public class Z extends Task {
    private final static  int priority = 1;
    public Z(int requiredTime) {
        super(priority);
        setName(this.getClass().getName());
        setBurstTime(requiredTime);
        setResources(new ResourceType[]{C,A});
    }
}
