package org.javaeight.iteratorPrac;

import java.util.ArrayList;
import java.util.Iterator;

/*
You cannot modify list structure while iterating it will throw exception as list structure changes and
iterator is unaware of that.
But you can use remove() method of iterator which will safely update the list structure and iterator internals

Fail-Fast Behavior:
Java List implementations like ArrayList and LinkedList use a modCount field (modification count) to track structural modifications (add, remove, etc.).
When you iterate over a List using an Iterator, the Iterator keeps a snapshot of the modCount at the start of the iteration.
If a structural modification occurs directly on the List (not through the Iterator), the modCount of the List changes. When the Iterator detects this mismatch, it throws a ConcurrentModificationException.


Fail Safe behavior:
Fail-safe iterators do not throw exceptions when the collection is modified during iteration.
Instead of operating directly on the collection, they iterate over a copy or snapshot of the collection's data.
Fail-safe iterators are typically implemented in concurrent collections like:
CopyOnWriteArrayList
ConcurrentHashMap
*/

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);


        for(Integer i : list){
            System.out.println("Item: "+i);
            //list.remove(Integer.valueOf(i));  //throws ConcurrentModificationException
        }

        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext()){
            Integer i = itr.next();
            System.out.println("Iterator Item: "+i);
            //list.remove(Integer.valueOf(i)); //throws ConcurrentModificationException
            if(i==3)
                itr.remove(); //will not throw exception.
        }


        System.out.println("Final List: "+list);

    }
}
