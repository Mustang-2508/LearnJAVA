package executorFramework.withoutExecutorFramework;

//Without Executor Framework
public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Thread[] threadArray = new Thread[9];
        for (int i = 1; i <10; i++) {
            int finalI = i;
            threadArray[i-1] = new Thread(()->{
                System.out.println("Factorial of "+finalI+": "+factorial(finalI));
            });

            threadArray[i-1].start();
        }

        for(Thread thread : threadArray){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Total time: "+(System.currentTimeMillis()-startTime));
    }





    public static int factorial(int num){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int result=1;
        for (int i = num; i >=1; i--) {
            result *= i;
        }
        return result;
    }
}
