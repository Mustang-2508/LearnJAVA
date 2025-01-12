**Thread lifeCycle:**
(refer LifeCycleDemo class)

    1. New = Object Crated
    2. Runnable = Start() method called on thread object
    3. Running = CPU is allocated for the thread
    4. Timed_Wait/Blocked = waiting for resource/input or blocked
    5. Terminated = thread completes it's execution

**Thread Vs Runnable:**

    If the class which we are making as thread class is already extending another class then we cannot
    extend Thread class as java doesn't supports multiple inheritance for that class we can implement
    Runnable interface in that case.

**Thread Class Methods:**

    start(): to start the execution of the thread.
    run(): contains body/instructions set to be executed by thread.
    sleep(): sleeps thread for specified time period.
    join(): the running thread waits for the thread on which the join method is called to complete its task.
    setPriority(): set the priority for the thread, it just gives hint to JVM for high priority, but actual priority depends on code and JVM.
    interrupt(): when called on thread throws InterrutedExecption, if thread is in Sleep, Wait or in Join state. it sets the flag is Interrupted which we can use to check if thread is interrupted
    yield(): this method hints thread scheduler to give chance to another thread to execute, but scheduler is free to ignore this hint.

**Daemon Thread:**

* Normal threads are the user thread, Daemon threads are the one which runs as service for user thread
JVM does not waits for the Demon thread to complete its task, it will wait for user thread to complete
and will terminate program as soon as it completes it's execution.

      It is crated using .setDaemon(true) method on created thread.

**Synchronization:**
(refer SyncronizationDemo)

* Critical section: The part of the program where the shared resources are accessed and modified by multiple threads is called as critical section.

* Race condition: When two or more thread try to access shared data simultaneously and the result depends on the sequence or timing of execution.

* Mutual Exclusion: In multi threaded environment it ensures that only one thread can access critical section at a time.

_We can use Synchronization to overcome the problem of race condition. and ensures Mutual Exclusion_

_We can make either method synchronized or make the block of code synchronized._

**Disadvantages of Synchronization:**

    1. Blocking: will wait indefinitely to achieve lock
    2. Fairness: can cause starvation as no fairness is achieved
    3. Interruptibility: cannot interrupt
    4. Read/write Locking: synchronization doesn't know which lock is read and which is for write

_we use Lock to overcome this disadvantages._

**Lockes:**
(refer threadLocks)

Both Synchronization and Locks are the mechanisms to achieve Mutual Exclusion.

* Synchronization provide less flexibility as it starts lock as thread enters synchronized block or
method. In Locks you can achieve locks if lock is available tryLock(), with timeout
tryLock(time, timeUnit) or achieve lock interruptibly lockInterruptibly().

**ReentrantLock:**
        
* This is the implementation class of Lock interface, as name suggest it keeps track of
number of time same thread acquires lock and will decrease this number for number of times
unlock is called. i.e if same thread tries to acquired lock on same object it will allow to
acquire lock.

        Lock.lock(): it will wait for indefinitely
        Lock.tryLock(): will check for lock if available, otherwise will move forward
        Lock.tryLock(10, TimeUnit.SECOND): will wait for 10 Seconds to acquire lock

**Unfairness of Lock:**
        
This term decides which lock will first acquire lock, if multiple threads are trying to
acquire lock. lock will be acquired in First Come First Serve manner, i.e for which thread
scheduler makes request will acquire lock first

This can be done by passing parameter to ReentrantLock

```java
    Lock lock = new ReentrantLock(true);
```
    

it helps to avoid Starvation to achieve lock.

**Read Write Locking:**
        
Read Write locks allows multiple thread to resources concurrently as long as not thread is
writing to the thread, it allows exclusive access to read resources.
        
 ```java
    RaedWriteLock lock = new ReentrentReadWriteLock();
    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();
```
        

* As it both readLock and writeLock locks are part of same lock object the can communicate
if writeLock is acquired by any thread or not and based on this it will allow multiple other
thread to achieve readLock.

**DeadLock:**
 (refer threadDeadLock)

There are 4 conditions for deadlock to occur

           1. Mutual Exclusion : one thread can access resource at time
           2. Hold and wait : holding one resource and waiting for another
           3. No-preemption : resource cannot taken forcefully
           4. Circular dependency : threads waiting for each other

_The main reason for deadlock is the sequence of acquiring lock of resources.
In example thread-1 have lock of pen and waiting for paper and thread-2 have lock of paper
and waiting for pen which caused deadlock._

_But if we update thread-2 task (as commented) where first we will acquire lock of pen
and then only we will lock paper and pen_

**Thread Communication:**
(refer threadCommunication)

What is Busy-waiting?

* It is a process where process continuously checks for condition to be true without yielding control of CPU.
which leds to insufficient CPU uses since no other tasks are executed while waiting.

Why need communication?

* Without thread communication threads might end up in busy-waiting state, leading to wastage of CPU resources
and potential deadlocks.

Methods used for communication?

            1.wait()
            2.notify()
            3.notifyAll()
            These are the methods used for thread communication. these methods are called within synchronized context only

            wait(): release the lock and wait until another thread calls notify() or notifyAll() on same object.
            notify(): wakes up single thread that is waiting on same objects monitor.
            notifyAll(): wakes up all the threads that are waiting on same objects monitor.



**Thread Safety:**

What is mean by thread safe?

        If object ensures that it will not create race condition and it will not give unexpected results
        when multiple threads tries to access the same object.

**Threads using lambda expression:**

* We can us Runnable to create thread using lambda expression as Runnable interface is a Functional Interface.
    
   ```java
     Runnable task = () -> {
        System.out.println("Task to be executed");
     };
        
     Thread thread = new Thread(task);
     thread.run();
   ``` 
**Thread Pools:**

* Collection of pre initialized threads fixed number of threads that are ready to perform the task.

Why?

        1. Resource Management: creataion and detroying thread everytime is expensive and have overhead.
        2. Response Time improvement: don't have to create thread from scratch.
        3. Control over thread count: Fixed number of thread, limits maz number of threads.

**Executor Framework:**
(refer withoutExecutorFramework and withExecutorFramework)
  
* Introduced in java 5
* Simplifies development of concurrent appliaction by abstracting complexities of creating and managing threads.

*Problems without Executor Framework:*
* Manual Resource Handling
* Resource Management
* Scalability
* Thread Reuse
* Error Handling

in withoutExecutorFramework example:
* We are manually creating threads for every task
* We are not reusing threads

in withExecutorFramework example:
* Threads are crated using Executors.newFixedThreadPool() method.
* We are using executorService.submit() method to directly submit task to be executed.
* No need to start threads
* Used executorService.awaitTermination(10, TimeUnit.SECONDS) to wait to complete all threds to complete their tasks


**Methods to create Thread Pools:**
  * newFixedThreadPool(): Creates a thread pool that reuses a fixed number of threads operating off a shared unbounded queue.
  * newSingleThreadExecutor(): Creates an Executor that uses a single worker thread operating off an unbounded queue.
  * newCachedThreadPool(): Creates Thread pool that creates new threads as needed. Threads that are not used for 60 sec will be terminated.
  

**Methods of Executor framework**
  * submit(Runnable task): Submites Runnable task for exection and returns Future representing that task. Future's get() mwthod will return null on successfull complition.
  * submit(Callable\<T> task): Submites value returning task for execution and returns Future representing pending result of task.
  * submit(Runnable task, T result): Submites Runnable task for exection and returns Future representing that task. Future's get() mwthod will return result on successfull complition.
  * shutdown(): Will start the orderly shutdown for all threads where previously sumbimmted tasks will be exexuted but no new tasks will be accepted. 
  * shutdownNow(): This method does not waits for actively executing tasks to complete their execution.
  * awaitTermination(): Blocks until all tasks have completed execution after a shutdown request, or the timeout occurs, or the current thread is interrupted, whichever happens first
  * isShutdown(): Returns true if this executor has been shut down.
  * isTerminated(): Returns true if all tasks have completed following shut down. Note that isTerminated is never true unless either shutdown or shutdownNow was called first.
  * invokeAll(Collection\<Callable\<T>> list): Takes list of tasks, Blocks Main thread until all tasks are completed.
  * invokeAll(Collection\<Callable\<T>> list, long timeout, TimeUnit unit): If all tasks are not completed within given time, it will abandon the task.
  * invokeAny(Collection\<Callable\<T>> list): Will return result of that task which executes first.
  * invokeAny(Collection\<Callable\<T>> list, long timeout, TimeUnit unit): Will return result of that task which executes first.

**Future:**

* What is Future

Future respresents the result of asychronous computation,It provides a way to retrieve the result of a computation
that might take time to complete, allowing the main thread to continue running other tasks while waiting for the result.

* Methods of Future 
  * get(): This method waits for the computation to complete and then retrieves the result, blocks the calling thread until task is completed
  * get(long time, TimeUnit unit): Similar to get, but allows to specify max waiting time. otherwise throws TimeoutException.
  * isDone(): It returns true if the task has finished executing, either successfully or via an exception.
  * cancel(Boolean mayInterruptIfRunning): This method attempts to cancel the execution of the task. If the task is already completed or canceled, it returns false. If the task has not started, it will be canceled without executing. If mayInterruptIfRunning is set to true, it interrupts the thread running the task (if possible).
  * isCancelled(): This method checks whether the task was canceled before it completed. It returns true if the task was canceled, either because it was still running or it never started.
  

**Runnable Vs Callable:**

* Return Type
  * Ruannble task return void while Callabel can return any type of value. 


* Interface methods
  * Runnable has void run() method while Callable has V call() method.


* Method Signature (callable Throws Exception)

  * for Runnable
    * public abstract void run();
  * for Callable 
    * V call() throws Exception;

**Scheduled Executor Service**

To perform task after delay or to perform periodic task.

```java
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
```

* Methods:
  * schedule(Rubbale task, Time initialDelay, TimeUnit unit): To perform task after initial delay.
  * scheduledAtFixedRate(Rubbale task, Time initialDelay, Time period, TimeUnit unit): To perform task after initial delay and after every defined period.
  * scheduledAtFixedDelay(Rubbale task, Time initialDelay, Time delay, TimeUnit unit): similar to scheduledAtFixedRate, Difference is
    
    
    scheduledAtFixedRate this method starts another task after specified period irrespective of earlier task is completed or not
    scheduledAtFixedDelay this method starts another task with specified delay only after completing previous task
  
**CountDownLatch**

* In java multithreading, CountDownLatch is sychronozation aid that allows one or more threads to wait unitl the task being executed in other threds completes.
* It is initialized using count(Integer value), which represents number of tasks or threads must complete befor waiting thread continues it's execution
* Each time one of the operation completes, countdown() method is called on latch which decrements the count by one
* as soon as count reaches to 0 waiting thread continues it's execution.

Create CountDownLatch:
```java
  CountDownLatch latch = new CountDownLatch(3); // Latch will wait for 3 countDown() calls
```
**Methods:**
* await():Causes current thread to wait until the countdown in lactch reaches to 0, unless interrupted
* countDwon(): Decrements the count by one, If it reaches 0 all waiting threads are released. this methid idealy used within the task inside finally block.
* getCount(): Returns current count of latch.

**Uses of CountDownLatch:**
* Waiting for several services to start before starting main service.
* Thread Joining: When multiple threads need to compelete before another thread continue it execution.

**CyclicBarrier**
(refer barrierdemo package)
* Similar to CountDownLatch but it can be resued unlike countdownlatch.
* CyclicBarrier is sychronization aid that allows threads to wait for each other at comman barrier, once all threads are reached barrier the can all proceed simultaneously.
* It is inititialized with initial counter, which is used to keep track of number of threads(Parties) have reached barrier.
* Each time await() method is called, counter is decreased, and when it reaches to Zero barrier is broken and it gets reset to initial count, so that it can be resued again if required.

Create CyclicBarrier:
```java
  CyclicBarrier barrier = new CyclicBarrier(3); // 3 threads must reach the barrier
```

**Methods:**

* await():This method is called by each thread to wait at the barrier. When the number of threads that have called await() equals the number of parties, all threads are released to proceed.
* await(long timeout, TimeUnit unit): This method allows a thread to wait at the barrier for a maximum amount of time. If all threads do not reach the barrier within this time, the waiting thread proceeds, and a TimeoutException is thrown.
* getParties(): Returns the number of threads that must invoke await() before the barrier is broken.
* isBroken(): Checks if the barrier is in a broken state (i.e., if one or more threads failed to reach the barrier, or if the barrier was manually reset or broken).
* reset(): Resets the barrier to its initial state. If there are any threads currently waiting at the barrier, they will receive a BrokenBarrierException.

**Uses of CyclicBarrier:**
* Cyclic phases: Coordinating multiple threads working in phases, where they need to wait at the end of each phase before starting the next.
* Parallel computation: Dividing a large task into smaller parallel tasks, with each thread processing a part and then synchronizing at regular intervals.
* Simulation: Running simulations where multiple threads need to simulate certain actions and then wait for all participants to reach a checkpoint.
