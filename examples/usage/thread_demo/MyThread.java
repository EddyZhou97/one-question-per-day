package thread_demo;

/**
 * thread demo类
 *
 * @author ZhouYi
 * 2021/4/18 10:26 下午
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("my thread name: " + Thread.currentThread().getName() + " timestamp: " + System.currentTimeMillis());
        }
    }
}
