package Process;


import Resourses.ResourceType;

import static Resourses.ResourceType.*;

public class X extends Task {
    private final static  int priority = 3;
    public X(int requiredTime) {
        super(priority);
        setBurstTime(requiredTime);
        setResources(new ResourceType[]{A,B});
    }
}
