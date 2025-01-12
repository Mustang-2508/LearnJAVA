package org.javaeight.threadlifecycle;

public class SyncronizationDemo extends Thread{

    CounterClass counter;

    public SyncronizationDemo(CounterClass counter){
        this.counter=counter;
    }

    @Override
    public void run(){
        for (int i=0;i<10000;i++){
            this.counter.incrementCounter();
        }
    }

    public static void main(String[] args) {

        CounterClass counter = new CounterClass();

        SyncronizationDemo thread1 = new SyncronizationDemo(counter);
        SyncronizationDemo thread2 = new SyncronizationDemo(counter);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter value : "+counter.getCounter());

    }

}
