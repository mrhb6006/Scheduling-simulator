package Resourses;

public class C extends Resource {
    public C(){
        super();
        setName(this.getClass().getName());
        setResourceType(ResourceType.C);
    }
}
