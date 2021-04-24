package lai_wei_lai;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface IA {
    String getHelloName();
}

public class ShowMeBug1 {
    public static void main(String[] arges) throws Exception {
        IA ia = (IA) createObject(IA.class.getName() + "$getHelloName=Abc");
        System.out.println(ia.getHelloName()); //方法名匹配的时候，输出“Abc”
        ia = (IA) createObject(IA.class.getName() + "$getTest=Bcd");
        System.out.println(ia.getHelloName()); //方法名不匹配的时候，输出null
    }

    //请实现方法createObject，接口中"getName()"方法名仅仅是个示例，不能写死判断

    public static Object createObject(String str) throws Exception {
        final String[] className = str.split("\\$");
        final String[] split = className[1].split("=");
        String methodName = split[0];
        String arg = split[1];
        final Class aClass = Class.forName(className[0]);
        ClassLoader classLoader = aClass.getClassLoader();
        return Proxy.newProxyInstance(classLoader, new Class[]{aClass}, (proxy, method, args) -> {
            if (!method.getName().equals(methodName)) {
                return null;
            }
            return arg;
        });
    }
}

