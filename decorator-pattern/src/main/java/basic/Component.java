package basic;

public abstract class Component {
    private String type = "ABSTRACT_COMPONENT";

    abstract int calculateCount();

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
