package thread_demo;

/**
 * thread demo类
 * 当一个类继承了其他类型时，无法直接继承Thread 可以 实现一个Runnable的接口
 *
 * @author ZhouYi
 * 2021/4/18 10:26 下午
 */
public class MyThreadImplementRunnable extends FatherObj implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("runnable interface thread name: " + Thread.currentThread().getName() + " timestamp: " + System.currentTimeMillis());
        }
    }
}
