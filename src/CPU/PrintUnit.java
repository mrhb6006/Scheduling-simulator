package CPU;

import java.util.Arrays;

public class PrintUnit extends Thread {
        public static void printCoreInfo(Core core){
            System.out.println(core.name+" : "+core.getActiveTask().getName());
        }

        public static void printQueue(){
            System.out.println(Arrays.toString(CPU.ready.toArray()));
            System.out.println(Arrays.toString(CPU.waiting.toArray()));
        }
}
