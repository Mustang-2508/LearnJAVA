package executorFramework.barrierdemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class WebServerService implements Runnable{

    private CyclicBarrier barrier;
    private int time;

    public WebServerService(int time, CyclicBarrier barrier){
        this.time = time;
        this.barrier = barrier;
    }
    @Override
    public void run() {


        try {
            System.out.println("WebServerService initialization started");
            Thread.sleep(time);
            Thread messagingService = new Thread(new MessagingService(1000, barrier));
            messagingService.start();
            System.out.println("WebServerService waiting at barrier");
            barrier.await();
            System.out.println("WebServerService initialization Completed");
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }


    }
}
