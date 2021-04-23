package wait_notify_demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ZhouYi
 * 2021/4/23 11:41 下午
 */
public class Demo {

    public static void main(String[] args) throws InterruptedException {
        LinkedList<Integer> list1 = new LinkedList<>(Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15, 17, 19));
        LinkedList<Integer> list2 = new LinkedList<>(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16, 18, 20));
        List<Integer> res = new ArrayList<>();
        new Thread(() -> {
            synchronized (list1) {
                while (list1.size() > 0) {
                    res.add(list1.pop());
                    System.out.println("pop list1:" + Arrays.toString(res.toArray()));
                    synchronized (list2) {
                        list2.notify();
                    }
                    try {
                        if (list1.size() > 0) {
                            list1.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (list2) {
                while (list2.size() > 0) {
                    res.add(list2.pop());
                    System.out.println("pop list2:" + Arrays.toString(res.toArray()));
                    synchronized (list1) {
                        list1.notify();
                    }
                    try {
                        if (list2.size() > 0) {
                            list2.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }

}
// 输出：
// pop list1:[1]
// pop list2:[1, 2]
// pop list1:[1, 2, 3]
// pop list2:[1, 2, 3, 4]
// pop list1:[1, 2, 3, 4, 5]
// pop list2:[1, 2, 3, 4, 5, 6]
// pop list1:[1, 2, 3, 4, 5, 6, 7]
// pop list2:[1, 2, 3, 4, 5, 6, 7, 8]
// pop list1:[1, 2, 3, 4, 5, 6, 7, 8, 9]
// pop list2:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
// pop list1:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
// pop list2:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
// pop list1:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]
// pop list2:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]
// pop list1:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
// pop list2:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
// pop list1:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17]
// pop list2:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18]
// pop list1:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
// pop list2:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
