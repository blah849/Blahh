package adventure.things;

public abstract class Thing {
    protected String shortName;
    protected String fullName;
    protected String description;

    public String getName() {
        return shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDescription() {
        return description;
    }
}
