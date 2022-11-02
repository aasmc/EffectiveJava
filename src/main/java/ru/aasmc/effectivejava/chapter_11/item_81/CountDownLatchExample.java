package ru.aasmc.effectivejava.chapter_11.item_81;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CountDownLatchExample {
    public static long time(Executor executor, int concurrency, Runnable action) throws InterruptedException {
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(concurrency);

        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                ready.countDown(); // Tell timer we are ready
                try {
                    start.await(); // Wait till peers are ready
                    action.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    done.countDown(); // Tell timer we are done
                }
            });
        }
        ready.await(); // Wait for all workers to be ready
        long startNanos = System.nanoTime();
        start.countDown(); // Tell workers to proceed with action
        done.await(); // Wait for all workers to finish
        return System.nanoTime() - startNanos;
    }

    public static void main(String[] args) throws InterruptedException {
        var executor = Executors.newFixedThreadPool(10);
        System.out.println(time(executor, 10, () -> System.out.println("Hello from worker " + Thread.currentThread().getName())));
        executor.shutdown();
    }
}
