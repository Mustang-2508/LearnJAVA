package org.javaeight.copyOnWriteArrayListPrac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {

/*
        Example 1:
        In below code if you use ArrayList the code will throw ConcurrentModificationException  as we are
        changing state of ArrayList while Iterating.

        But using CopyOnWriteArrayList will work fine:
            CopyOnWriteArrayList create copy of internal array on every modification; and modification is
            is performed on newly crated array.
            at last the reference is changed to new internal array.

            and iteration will be performed on Snapshot of internal array which was taken at the time of
            creating Iterator.

            hence modifying CopyOnWriteArrayList will not throw ConcurrentModificationException.

*/

//        ArrayList<String> arrayList = new ArrayList<>();
        CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();
        arrayList.add("Sukhoi");
        arrayList.add("Tejas");
        arrayList.add("Mirage");
        arrayList.add("Rafal");
        arrayList.add("Mig-21");

        for(String jet: arrayList){
            System.out.println(jet);
            if(jet.equals("Mig-21")){
                arrayList.add("Mig-29");
                System.out.println("Added Mig-29 to List");//line 1
            }
            System.out.println("Address: "+System.identityHashCode(arrayList.toArray()));//Address 1
        }

        System.out.println("Updated Fighter List: "+arrayList);//line 2
        System.out.println("Address: "+System.identityHashCode(arrayList.toArray()));//Address 2

    }
}
