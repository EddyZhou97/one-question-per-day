package string_demo;

public class StringDemo {

    public static void main(String[] args) {
        internTest1();
        System.out.println("================================================");
        internTest2();
        System.out.println("================================================");
        internTest3();
    }

    public static void internTest1() {

        final String intern1 = "sdfsdddewetgddd";
        System.out.println(intern1);

        String tmpS;

        String s = new String(tmpS = "1");

        System.out.println("tmpS的内存地址：" + System.identityHashCode(tmpS));

        System.out.println("intern前s的内存地址：" + System.identityHashCode(s));
        final String intern = s.intern();
        System.out.println("intern的内存地址：" + System.identityHashCode(intern));
        System.out.println(intern);
        System.out.println("intern后s的内存地址：" + System.identityHashCode(s));
        String s2 = "1";
        System.out.println("s2的内存地址：" + System.identityHashCode(s2));
        System.out.println(s == s2);
        System.out.println(intern == s2);

        String ss = new String("1");
        System.out.println("intern前ss的内存地址：" + System.identityHashCode(ss));
        final String internSS = ss.intern();
        System.out.println(internSS);
        System.out.println("intern后ss的内存地址：" + System.identityHashCode(ss));

        String s3 = new String("1") + new String("1");
        System.out.println("intern前s3的内存地址：" + System.identityHashCode(s3));
        s3.intern();
        System.out.println("intern后s3的内存地址：" + System.identityHashCode(s3));
        String s4 = "11";
        System.out.println("s4的内存地址：" + System.identityHashCode(s4));
        System.out.println(s3 == s4);
    }

    public static void internTest2() {
        String s = new String("1");
        System.out.println("intern前s的内存地址：" + System.identityHashCode(s));
        String s2 = "1";
        System.out.println("s2的内存地址：" + System.identityHashCode(s2));
        s.intern();
        System.out.println("intern后s的内存地址：" + System.identityHashCode(s));
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        System.out.println("intern前s3的内存地址：" + System.identityHashCode(s3));
        String s4 = "11";
        System.out.println("s4的内存地址：" + System.identityHashCode(s4));
        s3.intern();
        System.out.println("intern后s3的内存地址：" + System.identityHashCode(s3));
        System.out.println(s3 == s4);
    }

    public static void internTest3() {
        String s1 = new StringBuilder().append("think").append("123").toString();

        System.out.println(s1.intern() == s1);

        String s2 = new StringBuilder().append("ja").append("va").toString();

        System.out.println(s2.intern() == s2);
    }

}
