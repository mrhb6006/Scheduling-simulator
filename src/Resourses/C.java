package Resourses;

public class C extends Resource {
    C(int availableCount){
        super();
        setName(this.getClass().getName());
        setAvailableCount(availableCount);
    }
}
