**Stack:**  

* Stack extends Vector class.
* and hence synchronized, making it thread safe.
* LIFO structure:


* Stack Methods:
  * push(element): to add element to stack.
  * pop(): to get and remove top element.
  * peek(): to get last inserted(top) element.
  * isEmpty(): to check if stack is empty.
  * search(Object): to find index of Object in stack. 

* As stack extends Vector class we can execute.
  * remove(index): remove from middle of stack.
  * add(index, element): add in the middle of the stack.

**If we want stack functionality we can use stack related method, but we are not limited to there only we can use Vector class method also.**

**Stack using LinkedList:**
* Can use linked list method to implement stack
* As Stack class is synchronized there is performance overhead, in single threaded env we can use LinkedList as stack
* linkedList.addLast();//push
* linkedList.removeLast();//pop
* linkedList.getLast();//peek
* linkedList.isEmpty();
* linkedList.size();
