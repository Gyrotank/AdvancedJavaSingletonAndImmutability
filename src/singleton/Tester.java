package singleton;

import java.lang.reflect.InvocationTargetException;

public class Tester {
    class SingletonUser implements Runnable
    {
        Thread mythread;
        private Class<?> mySingletonClass;
        public Object mySingletonInstance;
       
        SingletonUser(Class<?> clazz)
        {
            mySingletonClass = clazz;
            mythread = new Thread(this, "my runnable thread");
            mythread.start();
        }
       
        //Had to use reflection instead of inheritance since you can't extend enums 
        //due to them implicitly extending java.lang.Enum
        public void run()
        {
            try {
                mySingletonInstance = mySingletonClass
                        .getDeclaredMethod("getInstance").invoke(this);
            } catch (IllegalAccessException | IllegalArgumentException | 
                    InvocationTargetException | NoSuchMethodException | SecurityException e) {
                e.printStackTrace();
            }
        }
    }    
    
    public static void testSingletonClass(Class<?> singletonClass) {
        int step = 0;
        int stepQuantity = 10000;
        Tester tester = new Tester();
        
        for (int i = 0; i < stepQuantity; i++) {
            step++;
            SingletonUser user1 = tester.new SingletonUser(singletonClass);
            SingletonUser user2 = tester.new SingletonUser(singletonClass); 
            
            try {
                user1.mythread.join();
                user2.mythread.join();
            } catch (InterruptedException e) {
                System.out.println("Main thread Interrupted");
            }
            
            if (user1.mySingletonInstance != user2.mySingletonInstance) {
                System.out.println("U1: " + user1.mySingletonInstance + "; U2: " + user2.mySingletonInstance);
                System.out.println("Step " + step + ": Singleton instances don't match!\n");
                break;
            }
            
            if (i == stepQuantity - 1) {
                System.out.println("No singleton instances mismatch detected after " + stepQuantity + " steps\n");
            }
        }
    }
    
    public static void main(String[] args) {
        
        Class<?> singletonClasses[] = {SingletonV1.class, SingletonV2.class, SingletonV3.class,
                SingletonV4.class, SingletonV5.class, SingletonV6.class};
        
        for (Class<?> c : singletonClasses) {
            System.out.println("====Testing " + c.getSimpleName() + "...===");
            testSingletonClass(c);
        }
    }
}
