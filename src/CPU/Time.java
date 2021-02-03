package CPU;

public class Time {

    private static  int time =0 ;

    public static int getCurrentTime(){
        return time;
    }

    public static void increaseTime(){
        time++;
    }
}
