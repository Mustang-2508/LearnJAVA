package org.javaeight.queuePrac;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(15);
        priorityQueue.add(10);
        priorityQueue.add(30);
        priorityQueue.add(5);
        System.out.println("priorityQueue: "+priorityQueue);
        System.out.println("Removed: "+priorityQueue.remove());
        System.out.println("Removed: "+priorityQueue.remove());
        System.out.println("Removed: "+priorityQueue.remove());
        System.out.println("Removed: "+priorityQueue.remove());
        System.out.println("Top: "+priorityQueue.peek());

    }
}
