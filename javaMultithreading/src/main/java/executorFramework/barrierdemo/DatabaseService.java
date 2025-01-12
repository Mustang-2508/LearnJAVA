package executorFramework.barrierdemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class DatabaseService implements Runnable{
    private CyclicBarrier barrier;
    private int time;

    public DatabaseService(int time, CyclicBarrier barrier){
        this.time = time;
        this.barrier = barrier;
    }
    @Override
    public void run() {


        try {
            System.out.println("DatabaseService initialization started");
            Thread.sleep(time);
            System.out.println("DatabaseService waiting at barrier");
            barrier.await();
            System.out.println("DatabaseService initialization Completed");
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }


    }
}
