package org.javaeight.LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private int capacity;
    public LRUCache(int capacity){
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> lruCache = new LRUCache<>(3);

        lruCache.put("Sukhoi", 2120);
        lruCache.put("Mirage", 2530);
        lruCache.put("Rafal", 2222);
        lruCache.get("Sukhoi");
        lruCache.put("Mig-29", 2445);
        lruCache.get("Sukhoi");
        lruCache.put("Tejas", 2205);

        System.out.println(lruCache);
    }
}
