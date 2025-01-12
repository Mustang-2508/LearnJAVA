package org.javaeight.threadlifecycle;

import java.util.Date;

public class LifeCycleDemo extends  Thread{

    @Override
    public void run(){
        System.out.println("RUNNING");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LifeCycleDemo lifeCycleDemo = new LifeCycleDemo();  //NEW
        System.out.println(lifeCycleDemo.getState());
        lifeCycleDemo.start(); //RUNNABLE
        System.out.println(lifeCycleDemo.getState());
        Thread.sleep(100);//TIMED_WAITING
        System.out.println(lifeCycleDemo.getState());
        lifeCycleDemo.join();
        System.out.println(lifeCycleDemo.getState());

    }
}
