package executorFramework.barrierdemo;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("All Services started...");
            }
        });

        Thread webService = new Thread(new WebServerService( 2000, barrier));
        Thread databaseService = new Thread(new DatabaseService(3000, barrier));

        MessagingService messagingService = new MessagingService(10, barrier);



        webService.start();
        databaseService.start();



        System.out.println("Main Ended..");
    }
}
