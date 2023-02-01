package main.java.other;

/**
 * @author chenguanglei
 * @date 2023/1/30
 */
public class AtomicityTest {

    static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {
        AtomicityTest obj = new AtomicityTest();
        Thread t1 = new Thread(() -> {
            obj.add();
        }, "A");

        Thread t2 = new Thread(() -> {
            obj.add();
        }, "B");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("main线程输入结果为==>" + count);
    }

    public void add() {
        synchronized (AtomicityTest.class) {
            for (int i = 0; i < 100000; i++) {
                count++;
            }
        }
    }

}
