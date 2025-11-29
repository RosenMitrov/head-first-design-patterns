package coffee;

public abstract class Coffee {

    private String description = "Unknown Coffee";

    public abstract double cost();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
