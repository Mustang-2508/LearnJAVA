package threadLocks;

public class Main {
    public static void main(String[] args) {

        Bank sbi  = new Bank();

        Thread thread1 = new Thread(() -> {
            sbi.withdrawMoney(500);
        });

        Thread thread2 = new Thread(() -> {
            sbi.withdrawMoney(250);
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Remaining Amount : "+ sbi.getBalance());

    }
}
