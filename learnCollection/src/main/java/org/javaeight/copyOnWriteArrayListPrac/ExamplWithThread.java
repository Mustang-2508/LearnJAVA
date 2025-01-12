package org.javaeight.copyOnWriteArrayListPrac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class ExamplWithThread {
    public static void main(String[] args) {
//        ArrayList<String> jetsInventory = new ArrayList<>();
        CopyOnWriteArrayList<String> jetsInventory = new CopyOnWriteArrayList<>();
        jetsInventory.add("Sukhoi");
        jetsInventory.add("Tejas");
        jetsInventory.add("Mirage");
        jetsInventory.add("Rafal");
        jetsInventory.add("Mig-21");
        jetsInventory.add("Jaguar");

        Thread readerThread = new Thread(()->{
            int i=0;
           while(true){
               for (String jet : jetsInventory){
                   System.out.println("Gen "+i+" : "+jet);
                   try {
                       Thread.sleep(100);
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
               }
               i++;
           }
        });

        Thread writeThread = new Thread(()->{
            try {
                Thread.sleep(500);
                jetsInventory.add("Mig-29");
                System.out.println("Added Mig-29 to inventory.");
                Thread.sleep(500);
                jetsInventory.remove("Mig-21");
                System.out.println("Retired Mig-21");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        readerThread.start();
        writeThread.start();
    }
}
