package factory.abstractMethodFactory;

import java.util.*;
import java.util.stream.Collectors;

public class AbstractMethodMain {
    static Scanner SCANNER = new Scanner(System.in);
    static Map<String, PizzaStore> PIZZA_STORES = new HashMap<>();

    static {
        fillPizzaStores();
    }

    public static void main(String[] args) {
        System.out.println("** Choose Pizza Store **");
        printPizzaStores();
        String selectedPizzaStore = SCANNER.nextLine().toUpperCase();

        printPizzaTypes();
        String selectedPizzaType = SCANNER.nextLine().toUpperCase();

        while (!selectedPizzaType.equals("ORDER")) {
            PizzaStore pizzaStore = PIZZA_STORES.get(selectedPizzaStore);
            pizzaStore.orderPizza(PizzaType.getPizzaType(selectedPizzaType));
            printPizzaTypes();
            selectedPizzaType = SCANNER.nextLine().toUpperCase();
        }

        System.out.println("Goodbye...");

    }

    private static void printPizzaTypes() {
        System.out.println("** Choose Pizza Type **");
        String types = Arrays.stream(PizzaType.values()).map(PizzaType::name).collect(Collectors.joining("\n"));
        System.out.println(types);
        System.out.println("Or press ORDER");
    }

    private static void printPizzaStores() {
        System.out.println("CHICAGO");
        System.out.println("NY");
    }

    private static void fillPizzaStores() {
        PIZZA_STORES.put("CHICAGO", new ChicagoStylePizzaStore());
        PIZZA_STORES.put("NY", new NYStylePizzaStore());
    }
}
