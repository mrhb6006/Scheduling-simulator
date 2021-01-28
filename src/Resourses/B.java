package Resourses;

public class B extends Resource {
    B(int availableCount){
        super();
        setName(this.getClass().getName());
        setAvailableCount(availableCount);
    }
}
