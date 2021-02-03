package CPU;

import java.util.Arrays;

public class PrintUnit extends Thread {
        public static void printCoreInfo(Core core){
            System.out.println(core);
        }

        public static void printQueue(){
            System.out.println("Time : "  +Time.getCurrentTime());
            System.out.println("ready queue : " + Arrays.toString(CPU.ready.toArray()));
            System.out.println("waiting queue : " +Arrays.toString(CPU.waiting.toArray()));
        }
}
