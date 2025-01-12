package org.javaeight.setPrac;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class Main {
    public static void main(String[] args) {

        CopyOnWriteArraySet<Integer> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        ConcurrentSkipListSet<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>();

        for(int i = 1; i<=5; i++){
            copyOnWriteArraySet.add(i);
            concurrentSkipListSet.add(i);
        }

        System.out.println("copyOnWriteArraySet : "+copyOnWriteArraySet);
        System.out.println("concurrentSkipListSet : "+concurrentSkipListSet);
        System.out.println("-----------------------------------------------------");

        for(Integer i : copyOnWriteArraySet){
            System.out.println("copyOnWriteArraySet: "+i);
            if(i==5)
                copyOnWriteArraySet.add(6);
        }
        System.out.println("copyOnWriteArraySet : "+copyOnWriteArraySet);
        System.out.println("-----------------------------------------------------");

        for(Integer i : concurrentSkipListSet){
            System.out.println("concurrentSkipListSet: "+i);
            if(i==5)  //On Commenting this line it will add 6 at iteration also
                concurrentSkipListSet.add(6);
        }
        System.out.println("concurrentSkipListSet : "+concurrentSkipListSet);
    }
}
