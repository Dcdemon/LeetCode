package thread;

class Thread1 extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 100; i++) {
            System.out.println(1);
        }
    }
}

class MyRunnable implements Runnable {
    int count = 0;

    @Override
    public synchronized void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "," + count++);
    }
}

public class ThreadPractice {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(runnable, "t" + i);
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }

}
