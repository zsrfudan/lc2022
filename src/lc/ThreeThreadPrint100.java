package lc;

public class ThreeThreadPrint100 {

    private static final Object lock = new Object();
    private static final int max = 100;
    private int num = 0;

    private void print(int threadNo) {
        while(true) { // 结束条件放这里的话会多打几个数
            synchronized (lock) {
                while(num % 3 != threadNo) {
                    try {
                        lock.wait();
                    } catch (Exception e) {

                    }
                }
                if (num > max) {
                    break;
                }
                System.out.println(Thread.currentThread().getName() + ":" + num);
                num++;
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        ThreeThreadPrint100 threeThreadPrint100 = new ThreeThreadPrint100();
        new Thread(() -> threeThreadPrint100.print(0), "thread-0").start();
        new Thread(() -> threeThreadPrint100.print(1), "thread-1").start();
        new Thread(() -> threeThreadPrint100.print(2), "thread-2").start();
    }
}