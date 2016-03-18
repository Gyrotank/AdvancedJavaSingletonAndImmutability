package singleton;

//PROS: no multi-threading problems
//CONS: eager initialization, constructor exception handling impossible
public class SingletonV2 {
    private static SingletonV2 instance = new SingletonV2();
    
    private SingletonV2() {        
    }
    
    public static SingletonV2 getInstance() {
        return instance;
    }
}
