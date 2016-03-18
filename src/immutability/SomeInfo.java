package immutability;

public class SomeInfo {
    public String info1;
    public String info2;
    
    SomeInfo() {
        this("default1", "default2");
    }
    
    SomeInfo(String info1, String info2) {
        this.info1 = info1;
        this.info2 = info2;
    }
    
    SomeInfo(SomeInfo that) {
        this.info1 = that.info1;
        this.info2 = that.info2;
    }
}
