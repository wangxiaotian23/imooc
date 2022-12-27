package cn.bugstack.springframework.test;

import sun.misc.Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: 李清依
 * @Date: 2022/11/16 17:24
 * @Description:
 */
public class main4 {
    public static void main(String[] args) {
        main4 main4 = new main4();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                main4.printa();
            }
        }, "t1").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                main4.printb();
            }
        }, "t2").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                main4.printc();
            }
        }, "t3").start();
    }

    int num = 1;
    static int i = 1;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    void printa() {
        lock.lock();
        try {
            while (num != 1) {
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + i);
            i++;
            num = 2;
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void printb() {
        lock.lock();
        try {
            while (num != 2) {
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + i);
            i++;
            num = 3;
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void printc() {
        lock.lock();
        try {
            while (num != 3) {
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + i);
            i++;
            num = 1;
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
