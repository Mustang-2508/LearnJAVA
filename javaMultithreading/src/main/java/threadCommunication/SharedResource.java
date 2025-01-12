package threadCommunication;

public class SharedResource {
    private int data;
    private boolean hasData;

    public synchronized void produce(int value){
        while(hasData){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.data= value;
        System.out.println("Produeced: "+data);
        hasData = true;
        notify();
    }

    public synchronized int consume(){
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        System.out.println("Consumed: "+data);
        notify();
        return data;
    }
}
