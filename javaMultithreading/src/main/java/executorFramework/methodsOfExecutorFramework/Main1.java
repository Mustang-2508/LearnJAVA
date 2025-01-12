package executorFramework.methodsOfExecutorFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<Integer> task1 = () ->{
            System.out.println("Task 1");
            Thread.sleep(1000);
            return 1;
        };
        Callable<Integer> task2 = () ->{
            System.out.println("Task 2");
            Thread.sleep(1000);
            return 2;
        };
        Callable<Integer> task3 = () ->{
            System.out.println("Task 3");
            Thread.sleep(1000);
            return 3;
        };
        Callable<Integer> task4 = () ->{
            System.out.println("Task 4");
            Thread.sleep(1000);
            return 4;
        };
        Callable<Integer> task5 = () ->{
            System.out.println("Task 5");
            Thread.sleep(1000);
            return 5;
        };
        Callable<Integer> task6 = () ->{
            System.out.println("Task 6");
            Thread.sleep(1000);
            return 6;
        };


        List<Callable<Integer>> taskList = Arrays.asList(task1,task2, task3, task4, task5, task6);

        try {
            List<Future<Integer>> futures = executorService.invokeAll(taskList);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
        System.out.println("All Tasks completed..");

    }
}
