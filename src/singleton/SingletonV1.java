package singleton;

//PROS: lazy initialization, constructor exception handling possible
//CONS: multi-threading problems
public class SingletonV1 {
    private static SingletonV1 instance;
    
    private SingletonV1() {
    }
    
    public static SingletonV1 getInstance() {
        if (instance == null) {
            instance = new SingletonV1();
        }
        return instance;
    }
}
