package org.javaeight.ConcurrentLinkedQueuePrac;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TaskSubmissionSystem {
    private static BlockingQueue<String> taskQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        Thread producer = new Thread(()->{
           while(true){
               try {
                   taskQueue.put("Task "+System.currentTimeMillis());
               }
               catch (Exception e){
                    e.printStackTrace();
               }
           }
        });

        Thread consumer = new Thread(()->{
            while(true){
                try {
                    String task = taskQueue.take();
                    System.out.println("Processing: "+task);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
