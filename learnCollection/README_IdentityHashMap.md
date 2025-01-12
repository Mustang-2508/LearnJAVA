<H2>Identity HashMap:</H2>
* An IdentityHashMap is a specialized implementation of the Map interface in Java.
* It uses reference equality (==) and references hashcode instead of object's equality (equals()) and hashCode() for comparing keys.
* i.e. it uses object class hashCode() method, which generates hashcode using memory address.
* Even though you override hashCode() and equals(), IdentityHashMap will use Object class's hashCode() for hashcode generation and == operator for equality checks.
* Refer : [Main.java](src%2Fmain%2Fjava%2Forg%2Fjavaeight%2FidentityHahsMapPrac%2FMain.java)