package singleton;

//"Initialization on Demand Holder" by Bill Pugh
//PROS: lazy initialization, no multi-threading problems
//CONS: constructor exception handling impossible
public class SingletonV3 {
	private SingletonV3() {
    }
    
	private static class SingletonHolder {
    	private final static SingletonV3 instance = new SingletonV3();
    }
    
    public static SingletonV3 getInstance() {
        return SingletonHolder.instance;
    }
}
