package basic;

public class DecoratorTwo extends ComponentDecorator {

    public static final String COMPONENT_DECORATOR_TWO = "COMPONENT_DECORATOR_TWO";
    private final Component component;

    public DecoratorTwo(Component component) {
        this.component = component;
        setType(COMPONENT_DECORATOR_TWO);
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
        return this.component.getType() + ", " + COMPONENT_DECORATOR_TWO;
    }
}
