package singleton;

//Enum singleton by Joshua Bloch
//PROS: no multi-threading problems
//CONS: eager initialization
public enum SingletonV6 {
    INSTANCE;
	
    public static SingletonV6 getInstance() {
        return INSTANCE;
    }
}
