package Resourses;

public class B extends Resource {
    public B(int availableCount){
        super();
        setName(this.getClass().getName());
        setAvailableCount(availableCount);
        setResourceType(ResourceType.B);

    }
}
