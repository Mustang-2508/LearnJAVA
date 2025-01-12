package threadDeadLock;

public class Paper {

    public synchronized void wirteWithPenAndPaper(Pen pen){
        System.out.println(Thread.currentThread().getName()+" is using Paper "+this+" and writing");
        pen.finishWirting();
    }

    public synchronized  void finishWirting(){
        System.out.println(Thread.currentThread().getName()+" finished using Paper "+this);
    }
}
