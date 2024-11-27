class NamingRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Running thread: " + Thread.currentThread().getName());
    }
}

public class ThreadNamingExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new NamingRunnable(), "Worker-1");
        Thread t2 = new Thread(new NamingRunnable(), "Worker-2");

        t1.start();
        t2.start();
    }
}
