class SleepRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is starting.");
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted: " + e.getMessage());
        }
        System.out.println(Thread.currentThread().getName() + " has finished.");
    }
}

public class ThreadSleepExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new SleepRunnable(), "Thread-1");
        Thread t2 = new Thread(new SleepRunnable(), "Thread-2");

        t1.start();
        t2.start();
    }
}
