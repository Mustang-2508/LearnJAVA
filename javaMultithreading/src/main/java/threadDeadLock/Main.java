package threadDeadLock;

public class Main {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Paper paper = new Paper();

        Thread t1 = new Thread(new Task1(pen, paper), "Thread-1");
        Thread t2 = new Thread(new Task2(pen, paper), "Thread-2");

        t1.start(); //Thread-1 locks Pen and tries to acquire lock of Paper
        t2.start(); //Thread-2 locks Paper and tries to acquire lock of Pen

        //when the method is marked as synchronized the Thread acquires the lock of the object to
        //which this method belongs
    }
}
