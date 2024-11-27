class SimpleRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread is running.");
    }
}

public class ThreadCreationExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new SimpleRunnable());
        thread.start();
    }
}
