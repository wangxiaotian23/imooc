package cn.bugstack.springframework.java;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

import static com.sun.javafx.runtime.async.BackgroundExecutor.getExecutor;

/**
 * @Auther: 李清依
 * @Date: 2022/11/7 14:32
 * @Description:
 */
class LockDemo implements Runnable {

    private String locka;
    private String lockb;

    public LockDemo(String locka, String lockb) {
        this.locka = locka;
        this.lockb = lockb;
    }

    @Override
    public void run() {
        synchronized (locka) {
            System.out.println(Thread.currentThread().getName() + "\t 自己持有" + locka + "\t 尝试获取：" + lockb);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            synchronized (lockb) {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有" + lockb + "\t 尝试获取：" + locka);
            }
        }
    }

    /**
     * 分割list为多个子list
     *
     * @param list     要进行分割的list
     * @param childNum 每个list的中item的数量大小
     * @return 分割后的所有list组合
     */
    public static <E> List<List<E>> split(List<E> list, int childNum) {
        if (childNum <= 0) {
            throw new IllegalArgumentException("Param childNum can't less than zero!");
        }
        if (CollectionUtils.isEmpty(list)) {
            int initialCapacity = (list.size() % childNum == 0) ? list.size() / childNum : list.size() / childNum + 1;
            List<List<E>> result = new ArrayList<List<E>>();
            for (int i = 0; i < initialCapacity; i++) {
                result.add(list.subList(i * childNum, Math.min((i + 1) * childNum, list.size())));
            }
            return result;
        }
        return Collections.emptyList();
    }

    /**
     * 将任务拆分为子任务使用线程进行执行，加快任务分析速度
     *
     * @param childTaskReses  子任务要处理的数据列表
     * @param childTaskLogic  每个子任务的处理逻辑
     * @param errorHandler    子任务执行异常的回调方法
     * @param progressHandler 执行进度回调方法
     */
    public <E> void splitTaskExec(List<List<E>> childTaskReses, ObjIntConsumer<List<E>> childTaskLogic, ObjIntConsumer<Exception> errorHandler, DoubleConsumer progressHandler) {
        int taskCount = childTaskReses.size();
        // 控制多个子线程开始的计数器
        CountDownLatch begin = new CountDownLatch(1);
        // 控制多个子线程结束的计数器，计数器初始数为子任务的数量
        CountDownLatch end = new CountDownLatch(taskCount);
        for (int i = 0; i < childTaskReses.size(); i++) {
            // 如果存在线程嵌套问题，那么把线程丢进Cache线程池中，防止阻塞发生
            List<E> childTaskRe = childTaskReses.get(i);
            // 记录子任务的位置
            int location = i;
            Runnable runnable = () -> {
                try {
                    begin.await();
                    childTaskLogic.accept(childTaskRe, location);
                } catch (InterruptedException e) {
                    System.err.println("子任务执行异常：" + Thread.currentThread().getName() + "->" + e.getMessage());
                    if (errorHandler != null) {
                        errorHandler.accept(e, location);
                    }
                } finally {
                    // 自任务执行结束后减少计数
                    end.countDown();
                    if (progressHandler != null) {
                        progressHandler.accept((taskCount - end.getCount()) * 1.0 / taskCount);
                    }
                }
            };
            // 使用线程池执行
            getExecutor().submit(runnable);
        }
        try {
            begin.countDown();
            // 调用分割子任务的线程等待计数器执行结束（等待所有子任务执行结束）
            end.await();
        } catch (InterruptedException e) {
            System.err.println("主任务执行异常：" + e.getMessage());
        }
    }


}


public class DeadLock {


    public static void main(String[] args) {

    }
}
