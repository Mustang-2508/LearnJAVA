<H2>ConcurrentHashMap:</H2>
* Implements ConcurrentMap.
* It is a Concurrent version of HashMap


<H2>ConcurrentSkipListMap:</H2>
* It is a Concurrent version of TreeMap and stores elements in sorted order.
* It contains multiple skip-able layer 
* e.g.
  *       L1     1 - - - - 6 - - - - - 11
          L2     1 - 3 - - 6 - - 9  -  11
          L3     1 2 3 4 5 6 7 8 9  10 11


<H2>EnumMap:</H2>
* If all the key of Map are values from single enum then it is recommended to use enum map as specific implementation.
* We pass the enum we are using in constructor.
* Hence rehashing and HashCode computations are not required as all the key are already known to EnumMap.
* <h4>Internals:</h4>
  * Internally, EnumMap uses an array to store the mapping between the enum keys and their corresponding values.
  * The index of each enum key in the array is determined by its ordinal value (the position of the enum constant in its declaration).
  * This allows for fast lookups, insertions, and deletions with a time complexity of 𝑂(1).
  * Elements as stored in same sequence as that of enums. i.e. entry with key MONDAY at 1 position. despite when it is inserted. 

```java
import java.util.EnumMap;
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
public class EnumMapExample {
    public static void main(String[] args) {
        EnumMap<Day, String> schedule = new EnumMap<>(Day.class);
    }
}
```
<H2>Immutable:</H2>
* Cannot change elements of Map once created.
* We can make map immutable using Collections.

```java
    Map<String, Integer> map = new HashMap<>();
    map.add("One",1);
    Map<String, Integer> map1 = Collections.unmodifiableMap(map);
```
* Using Map.of(): Limited for 10 entries.
```java
  Map<String, Integer> map = Map.of("One", 1, "Two", 2);
```
* Using Map.ofEntries():
```java
  Map<String, Integer> map = Map.ofEntries(Map.Entry("One", 1), Map.Entry("Two", 2));
```