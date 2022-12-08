package thread_demo;

import java.text.SimpleDateFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledExecutorService demo
 *
 * @author robinson
 * 2021/11/18 10:35
 **/
public class ScheduledExecutorDemo {

    public static void main(String[] args) {
        scheduleDemo();
    }

    public static void scheduleDemo() {
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(1);

        for (int i = 0; i < 5; i++) {
            System.out.println("add thread:" + i);
            TheadRunner theadRunner = new TheadRunner("thread-" + i);
            // 延迟队列会在以延迟执行的先后时间触发执行
            scheduledExecutor.schedule(theadRunner, 10 - i * 2, TimeUnit.SECONDS);
            System.out.println("run thread:" + i);
        }
        // 主动关闭线程池
        scheduledExecutor.shutdown();
    }

    private static class TheadRunner implements Runnable {

        private String name;

        TheadRunner(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(100);
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    System.out.println(this.name + ":" + format.format(System.currentTimeMillis()));
                } catch (InterruptedException ignore) {
                }
            }
        }
    }
}

