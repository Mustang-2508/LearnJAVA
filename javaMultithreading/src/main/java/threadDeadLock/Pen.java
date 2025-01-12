package threadDeadLock;

public class Pen {
    public synchronized void wirteWithPenAndPaper(Paper paper){
        System.out.println(Thread.currentThread().getName()+" is using Pen "+this+" and writing");
        paper.finishWirting();
    }

    public synchronized  void finishWirting(){
        System.out.println(Thread.currentThread().getName()+" finished using pen "+this);
    }
}
