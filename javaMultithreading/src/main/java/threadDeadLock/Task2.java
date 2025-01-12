package threadDeadLock;

public class Task2 extends Thread{
    private Pen pen;
    private Paper paper;

    public Task2(Pen pen, Paper paper){
        this.pen=pen;
        this.paper=paper;
    }

    @Override
    public void run(){
        paper.wirteWithPenAndPaper(pen);

//        synchronized (pen){
//            paper.wirteWithPenAndPaper(pen);
//        }

    }
}
