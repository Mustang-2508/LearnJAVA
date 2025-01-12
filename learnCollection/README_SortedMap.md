

<H2>TreeMap <------ NavigableMap <------ SortedMap</H2>

<h2>Sorted Map:</h2>
* SortedMap is an interface that extends Map interface and gaureents that the entries are sorted based on keys, either 
in natural ordering or by specified comparator.
* It implements Map interface but also provides it's own methods:
  * .firstKey(): first key of sorted map.
  * .lastKey(): last key of sorted map.
  * .headMap(toKey): returns entries upto provided key.  
  * .tailMap(formKey): returns entries from provided key to end.
  * .subMap(fromKey, toKey):




<h2>TreeMap:</h2>
* Implements SortedMap interface.
* Null keys not allowed.
* Internally uses red-black tree(balanced binary tree).
* hence time complexity is O(log n).

<h4>Balanced Tree:</h4>
* A Binary Search Tree (BST) is a binary tree where each node has the following properties:
  * The left child contains values smaller than the node.
  * The right child contains values larger than the node.
  * There are no duplicate nodes (in a typical BST).

<h4>Red-Black Tree:</h4>
* A Red-Black Tree is a self-balancing binary search tree that maintains balance by enforcing the following properties:
* Balances for evey insert or removal operation.
  * Each node is either red or black.
  * The root is always black.
  * No two consecutive red nodes are allowed (no "red-red" violations).
  * Every path from a node to its descendant null pointers (NIL nodes) has the same number of black nodes (black height).


<h2>Navigable Map:</h2>
* Extends SortedMap interface, providing more powerful navigation options.
* Like finding the closest matching key or retrieving map in reverse order.
* Methods:
  * .lowerKey(key): returns greatest key strictly less than given key.
  * .ceilingKey(key): returns smallest key strictly greater than or equal to given key.
  * .higherEntry(key):
  * .descendingMap():