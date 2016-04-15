package immutability;

public final class ImmutableClass {
    final private int id;
    final private String name;
    final private SomeInfo additionalInfo;
    
    public ImmutableClass(int id, String name, SomeInfo additionalInfo) {
        this.id = id;
        this.name = name;
        this.additionalInfo = additionalInfo.copy();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SomeInfo getAdditionalInfo() {
        return additionalInfo.copy();
    }
}
