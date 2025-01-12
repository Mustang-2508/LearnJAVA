<H2>Set:</H2>
* Set is a collection that cannot contain duplicate elements.
* as based on hashmap principles Insert, Retrieve, delete Time complexity is O(1).
* Not Thread safe.
* Implementations:
  * HashSet:
    * Unique elements.
    * Unordered.
    * Internal implementation similar to HashMap, with dummy values for keys.
  * LinkedHashSet:
    * Unique elements.
    * Ordered.
  * TreeSet:
    * Unique elements.
    * Sorted.
    * Implements NavigableSet hence provides more navigation methods. like ceiling(), floor(), lower(), descendingSet()
  * EnumSet: 
    * Similar to EnumMap
  * ConcurrentSkipListSet (Weakly consistent):
    * Sorted Elements 
    * Thread safe 
    * Implements NavigableSet hence provides more navigation methods. like ceiling(), floor(), lower(), descendingSet()


* Unmodifiable Set:
  * Using Set.of(1,2,3,4,2,3,5) : Returns UnmodifiableSet, 


* CopyOnWriteArraySet:
  * Thread safe similar to ConcurrentSkipListSet.
  * Elements are not sorted unlike ConcurrentSkipListSet.
  * CopyOnWriteArraySet more consistent than ConcurrentSkipListSet.
  * Refer: [Main.java](src%2Fmain%2Fjava%2Forg%2Fjavaeight%2FsetPrac%2FMain.java) //line No. 32