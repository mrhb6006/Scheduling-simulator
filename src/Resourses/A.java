package Resourses;

public class A extends Resource {
    A(int availableCount){
        super();
        setName(this.getClass().getName());
        setAvailableCount(availableCount);
    }
}
