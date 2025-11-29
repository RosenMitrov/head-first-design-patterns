package basic;

public class Main {
    public static void main(String[] args) {
        Component component = new ConcreteComponentA();
        System.out.println(component.getType());

        component = new DecoratorOne(component);
        component = new DecoratorTwo(component);
        component = new DecoratorOne(component);
        component = new DecoratorTwo(component);

        System.out.println(component.getType());
        System.out.println(component.calculateCount());

    }
}
