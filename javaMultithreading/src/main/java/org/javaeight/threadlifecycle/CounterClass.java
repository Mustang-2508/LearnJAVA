package org.javaeight.threadlifecycle;

public class CounterClass {

    private int counter = 0;

    public void incrementCounter(){
        synchronized (this){
            this.counter++;
        }

    }

    public int getCounter(){
        return this.counter;
    }
}
