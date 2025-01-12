<H2>Garbage Collection:</H2>
* Cleaning up unused memory.
* We mostly use strong references in our java program
```java
    Plane plane = new Plane("Sukhoi", 3000); 
    //plane is a string reference. the memory allocated to "new Plane("Sukhoi", 3000)" will not be removed until plane contains it's references.
    plane = null;
    //now if JVM runs GC it will clean uo memory allocated to "new Plane("Sukhoi", 3000)"  
```
* We can use weak references(Only suitable for caching purposes).

```java
    import java.lang.ref.WeakReference;
    WeakReference<Plane> planeWeakReference = new WeakReference<Plane>(new Plane("Sukhoi", 3000));
    //now if JVM runs GC memory allocated to "new Plane("Sukhoi", 3000)" will be removed
```


<H2>WeakHashMap:</H2>
* WeakHashMap is a special implementation of the Map interface in Java that uses weak references for its keys. It is part of the java.util package and is primarily used in scenarios where you want the garbage collector (GC) to automatically remove entries when keys are no longer in use elsewhere in the application.
* Weak References for Keys:
  - The keys in a WeakHashMap are stored as weak references.
  - A weak reference does not prevent the GC from reclaiming the referenced object.
* Automatic Removal of Entries:
  - When a key becomes weakly reachable (i.e., there are no strong references to it), the entry is automatically removed from the map during the next GC cycle.
* Refer: [Main.java](src%2Fmain%2Fjava%2Forg%2Fjavaeight%2FWeakHashMapPrac%2FMain.java)