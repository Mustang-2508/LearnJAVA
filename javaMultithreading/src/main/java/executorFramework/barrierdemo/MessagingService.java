package executorFramework.barrierdemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MessagingService implements Runnable{

    private CyclicBarrier barrier;
    private int time;

    public MessagingService(int time, CyclicBarrier barrier){
        this.time = time;
        this.barrier = barrier;
    }
    @Override
    public void run() {


        try {
            System.out.println("MessagingService initialization started");
            Thread.sleep(time);
            System.out.println("MessagingService waiting at barrier");
            barrier.await();
            System.out.println("MessagingService initialization Completed");
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }


    }
}
