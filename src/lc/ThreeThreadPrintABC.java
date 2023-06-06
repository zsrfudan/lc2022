package lc;

// 两个交替打印的题写法类似 1.定义3个变量：锁，业务轮数，计数器 2.大循环里面跟着上锁 3.自旋 wait 4.业务输出，计数器++，notifyall
// 3个现成交替打印ABC，打印10轮
public class ThreeThreadPrintABC {

    private static final Object lock = new Object();
    private static final int round = 10;
    private int num = 0;

    private void print(int threadNo) {
        for (int i = 0 ; i < round ; i++) {
            synchronized (lock) {
                while(num % 3 != threadNo) { // 自旋
                    try {
                        lock.wait();
                    } catch (Exception e) {

                    }
                }
                num++;
                System.out.println(Thread.currentThread().getName());
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        ThreeThreadPrintABC threeThreadPrintABC = new ThreeThreadPrintABC();
        new Thread(() -> threeThreadPrintABC.print(0), "A").start();
        new Thread(() -> threeThreadPrintABC.print(1), "B").start();
        new Thread(() -> threeThreadPrintABC.print(2), "C").start();
    }
}