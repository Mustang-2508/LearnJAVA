<h2>CopyOnWriteArrayList:</h2>

* CopyOnWriteArrayList create copy of internal array on every modification; and modification is performed on newly crated array.
* at last the reference is changed to new internal array.
* and iteration will be performed on Snapshot of internal array which was taken at the time of creating Iterator.
* hence modifying CopyOnWriteArrayList will not throw ConcurrentModificationException.


Refer:

[copyOnWriteArrayListPrac/Main.java](src%2Fmain%2Fjava%2Forg%2Fjavaeight%2FcopyOnWriteArrayListPrac%2FMain.java)


[copyOnWriteArrayListPrac/ExamplWithThread.java](src%2Fmain%2Fjava%2Forg%2Fjavaeight%2FcopyOnWriteArrayListPrac%2FExamplWithThread.java)