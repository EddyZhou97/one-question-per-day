package thread_demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author ZhouYi
 * 2021/4/18 10:27 下午
 */
public class Demo {

    public static void main(String[] args) {
//        normalThreadDemo();
        threadPoolDemo();
    }

    public static void normalThreadDemo(){
        MyThread myThread = new MyThread();
        myThread.start();

        MyThread myThread2 = new MyThread();
        myThread2.start();

        System.out.println("====================");

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            FatherObj fatherObj = new FatherObj();
            try {
                fatherObj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("匿名thread name: " + Thread.currentThread().getName() + " timestamp: " + System
            .currentTimeMillis());
        }).start();

        MyThreadImplementRunnable runnable = new MyThreadImplementRunnable();
        // 直接调用run 则是在main的主线程上进行执行
//        runnable.run();

        Thread runnableThread = new Thread(runnable);
        runnableThread.start();
    }

    public static void threadPoolDemo(){

//        final ExecutorService threadPoolExecutor = new ThreadPoolExecutor();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Executors.newCachedThreadPool();
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

//            Callable c = new Callable() {
//            }
        }
    }

}
