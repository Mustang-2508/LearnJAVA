package threadDeadLock;

public class Task1 extends Thread{
    private Pen pen;
    private Paper paper;

    public Task1(Pen pen, Paper paper){
        this.pen=pen;
        this.paper=paper;
    }

    @Override
    public void run(){
        pen.wirteWithPenAndPaper(paper);
    }
}
