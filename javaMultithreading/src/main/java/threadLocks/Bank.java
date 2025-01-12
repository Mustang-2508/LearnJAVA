package threadLocks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    private int balance=500;

    private final Lock lock = new ReentrantLock();

    public  void withdrawMoney(int amount) {
        System.out.println(Thread.currentThread().getName()+" Attempting for withdrawal of "+ amount);
        try {
            if(lock.tryLock(4, TimeUnit.SECONDS)){
                if(amount <= balance){
                    System.out.println(Thread.currentThread().getName()+" Proceeding for withdrawal of "+ amount);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    balance-=amount;
                    System.out.println(Thread.currentThread().getName()+" Completed withdrawal of "+ amount);

                }
                else{
                    System.out.println(Thread.currentThread().getName()+" Insufficient balance");
                }
            }
            else{
                System.out.println(Thread.currentThread().getName()+" could not acquire lock");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            lock.unlock();
        }

    }

    public  int getBalance(){
        return this.balance;
    }
}
