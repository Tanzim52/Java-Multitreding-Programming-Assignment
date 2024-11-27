import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class DeadlockExample {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread-1 locked lock1");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ignored) {}
                synchronized (lock2) {
                    System.out.println("Thread-1 locked lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread-2 locked lock2");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ignored) {}
                synchronized (lock1) {
                    System.out.println("Thread-2 locked lock1");
                }
            }
        });

        t1.start();
        t2.start();

        detectDeadlock();
    }

    private static void detectDeadlock() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        while (true) {
            long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
            if (deadlockedThreads != null) {
                System.err.println("Deadlock detected!");
                System.exit(1);
            }
        }
    }
}
