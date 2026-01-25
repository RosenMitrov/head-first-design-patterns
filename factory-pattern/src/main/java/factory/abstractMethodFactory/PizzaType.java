package factory.abstractMethodFactory;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum PizzaType {
    CHEESE,
    PEPPERONI,
    CLAM,
    VEGGIE;

    public static PizzaType getPizzaType(String selectedPizzaType) {
        return Arrays.stream(PizzaType.values())
                .filter(pizzaType -> pizzaType.name().equals(selectedPizzaType))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No such pizza type."));
    }
}
