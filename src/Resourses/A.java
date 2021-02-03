package Resourses;

public class A extends Resource {
    public A(){
        super();
        setName(this.getClass().getName());
        setResourceType(ResourceType.A);
    }
}
