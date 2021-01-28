package Resourses;

public class C extends Resource {
    public C(int availableCount){
        super();
        setName(this.getClass().getName());
        setAvailableCount(availableCount);
        setResourceType(ResourceType.C);
    }
}
