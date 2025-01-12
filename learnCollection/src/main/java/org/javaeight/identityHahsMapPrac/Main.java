package org.javaeight.identityHahsMapPrac;

import java.util.HashMap;
import java.util.IdentityHashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        String key1 = new String("key");
        String key2 = new String("key");
        hashMap.put(key1, "value1");
        hashMap.put(key2, "value2");

        // Create IdentityHashMap
        IdentityHashMap<String, String> identityMap = new IdentityHashMap<>();
        identityMap.put(key1, "value1");
        identityMap.put(key2, "value2");


        System.out.println(System.identityHashCode(key1));
        System.out.println(System.identityHashCode(key2));
        System.out.println(key1.equals(key2));

        // Print both maps
        System.out.println("HashMap: " + hashMap); // Overwrites value: {key1=value2}
        System.out.println("IdentityHashMap: " + identityMap); // Both entries: {key1=value1, key1=value2}
    }
}
