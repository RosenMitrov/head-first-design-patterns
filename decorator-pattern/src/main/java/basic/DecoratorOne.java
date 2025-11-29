package basic;

public class DecoratorOne extends ComponentDecorator {

    public static final String COMPONENT_DECORATOR_ONE = "COMPONENT_DECORATOR_ONE";
    private final Component component;

    public DecoratorOne(Component component) {
        this.component = component;
        setType(COMPONENT_DECORATOR_ONE);
    }

    @Override
    int calculateCount() {
        return this.component.calculateCount() + 1;
    }


    @Override
    public String getType() {
        return getDecoratorType();
    }

    private String getDecoratorType() {
        return this.component.getType() + ", " + COMPONENT_DECORATOR_ONE;
    }
}
