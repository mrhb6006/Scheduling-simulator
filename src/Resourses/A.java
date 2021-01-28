package Resourses;

public class A extends Resource {
    public A(int availableCount){
        super();
        setName(this.getClass().getName());
        setAvailableCount(availableCount);
        setResourceType(ResourceType.A);
    }
}
