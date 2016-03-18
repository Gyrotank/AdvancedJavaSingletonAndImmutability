package singleton;

//"Double-Checked Locking"
//PROS: lazy initialization, no multi-threading problems, constructor exception handling possible
//CONS: volatile modifier can cause productivity problems in multi-processor systems
public class SingletonV5 {
	//doesn't work without volatile (except for 32-bit primitives or using thread local storage) due to compiler reordering mechanism
	//more on this here: http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html
    private static volatile SingletonV5 instance;
    
    private SingletonV5() {    	
    }
    
    public static SingletonV5 getInstance() {
        if (instance == null) {
            synchronized (SingletonV5.class) {
                if (instance == null) {
                    instance = new SingletonV5();
                }
            }
        }
    	return instance;
    }
}
