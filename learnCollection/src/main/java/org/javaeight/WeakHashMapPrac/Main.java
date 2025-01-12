package org.javaeight.WeakHashMapPrac;

import java.util.HashMap;
import java.util.WeakHashMap;
/**
 * The 3 in the code is an autoboxed integer literal.
 * Java caches integer literals in the range -128 to 127 (as part of the Integer Cache).
 * Thus, the autoboxed Integer object for 3 is stored in the integer cache and has a strong reference to it in the cache.
 * Since there is a strong reference to the Integer object for 3, it is not eligible for garbage collection.
 * Consequently, the entry for the key 3 remains in the WeakHashMap.
 */
public class Main {
    public static void main(String[] args) {
        WeakHashMap<Integer, String> weakHashMap = new WeakHashMap<>();
        weakHashMap.put(new Integer(1), new String("Saffron"));
        weakHashMap.put(new Integer(2), new String("White"));
        weakHashMap.put(3, new String("Green"));

        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(new Integer(1), new String("Saffron"));
        hashMap.put(new Integer(2), new String("White"));
        hashMap.put(3, new String("Green"));

        System.out.println("weakHashMap Before: "+weakHashMap);
        System.out.println("hashMap Before: "+hashMap);
        System.gc();
        simulateSomeWork();
        System.out.println("weakHashMap After: "+weakHashMap);
        System.out.println("hashMap After: "+hashMap);

    }

    public static void simulateSomeWork(){
        try {
            System.out.println("Simulating Some Work.");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
