**Linked List: **
Structure: 
* LinkedList is made up of Node.
* Each node has two fields value and reference to next node.

Types: 
    Singular: Each node has value and reference fields of type Node which points to the next node.
    Doubly: Each node has value and two reference fields to point to previous and next node.
    Circular: The last node contains reference to the first node.

**Linked List in JAVA: **
* Part of collection framework and implements List interface.
* Unlike ArrayList, which uses dynamic array to store elements, LinkedList stores elements as Nodes in doubly linked list.

Structure of java linked list:
* A linked list is a linear data structure where each element is separate object called Node.
* Each node contains two parts:
  * Data: value stored in node.
  * Pointers: Two pointer one pointing the new node and the other pointing to previous node.

Performance Consideration:

* Insertion and Deletion: Better for frequent insertions and deletions in middle of list as it does not requires shifting elements.
* Random Access: LinkedList has slower random access compared to ArrayList, because it has to travers list from beginning to reach desired location.
* Memory Overhead: LinkedList requires more memory than arrayList as each node requires extra memory to store references to next and previous nodes.

Methods of Linked List: 
    linkedList.get(1); //O(n)
    linkedList.add(1); //O(1)
    linkedList.addFirst(1); //O(1)
    linkedList.addLast  (1); //O(1)
    linkedList.removeIf(Predicate);
        linkedList.removeIf(x -> x%2 ==0); //remove all even form list
    linkedList.removeAll(Collection);
        linkedList.removeAll(listContainingElementsToReomve); //removes all elements which are common in linkedList and listContainingElementsToReomve  

