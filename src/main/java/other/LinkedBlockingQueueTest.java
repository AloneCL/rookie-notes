package main.java.other;


import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author chenguanglei
 * @date 2022/11/3
 */
public class LinkedBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<>(1000);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    queue.offer(new Object());
                    queue.remove();
                }
            }).start();
        }
        while (true) {
            System.out.println("begin scan, i still alive");
            queue.stream()
                    .filter(Objects::isNull)
                    .findFirst()
                    .isPresent();
            Thread.sleep(1000);
            System.out.println("finish scan, i still alive");
        }
    }
}
