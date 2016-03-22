package singleton;

//PROS: lazy initialization, no multi-threading problems, constructor exception handling possible
//CONS: synchronization is useful for the first time invocation only, after that it creates deadweight overhead only 
public class SingletonV4 {
    private static SingletonV4 instance;
    
    private SingletonV4() {        
    }
    
    public static synchronized SingletonV4 getInstance() {
        if (instance == null) {
            instance = new SingletonV4();
        }
        return instance;
    }
}
