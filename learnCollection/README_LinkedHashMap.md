<H2>LinkedHashMap:</H2>
* LinkedHashMap is a subclass of HashMap that maintains a predictable iteration order.
* Constructors:
```java 
    //Default Constructor
    LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap();
    //Creates an empty map with a default capacity of 16 and a load factor of 0.75.

    //With Initial Capacity and Load Factor:
    LinkedHashMap<K, V> map = new LinkedHashMap<>(initialCapacity, loadFactor);
    
    //With Access Order:
    LinkedHashMap<K, V> map = new LinkedHashMap<>(initialCapacity, loadFactor, accessOrder);

```
* accessOrder:
* true: Entries reordered based on access. The element that you will access using get will be moved to end of linked list.
* false: Entries retain insertion order.

<H4>Characteristics:</H4>
* Uses Double linked List to store elements internally.
* Slow in comparison to HashMap
* Same time complexity;
* Will use when order is important
* Not Thread Safe

<H2>LRU(Least Recently Used) Cache:</H2>
* Will override and make use of one method present removeEldestEntry(Map.Entry<K, V> eldest).
* and is invoked by put() and pputAll() after inserting record.
* This removes eldest entry present in array i.e fist element present in order 
* then it can be Insertion order or Access order.
* Refer [LRUCache.java](src%2Fmain%2Fjava%2Forg%2Fjavaeight%2FLRUCache%2FLRUCache.java)