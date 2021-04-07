package demo.java;

/**
 * @author ZhouYi
 * 2021/4/2 8:21 下午
 */
public class Demo {

    public static void main(String[] args) {

        int initCapacity = 64;

        int capacity = 1;

        while(capacity < initCapacity){
            capacity <<= 1;
            System.out.println(capacity);
        }

        String test = "sdf";
        System.out.println(test.hashCode() );
        System.out.println(test.hashCode() >>> 16 );

    }
}
