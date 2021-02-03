package Resourses;

public class B extends Resource {
    public B(){
        super();
        setName(this.getClass().getName());
        setResourceType(ResourceType.B);

    }
}
