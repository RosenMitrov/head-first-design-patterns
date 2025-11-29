package coffee;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {
    public static void main(String[] args) {
        Coffee coffee = new Espresso();
        printCoffee(coffee);

        coffee = new WithMilk(coffee);
        printCoffee(coffee);

        coffee = new WithSugar(coffee);
        coffee = new WithSugar(coffee);
        coffee = new WithSugar(coffee);
        coffee = new WithSugar(coffee);
        printCoffee(coffee);
    }

    private static void printCoffee(Coffee coffee) {
        log.info("Cost: {}, Description: {}", coffee.cost(), coffee.getDescription());
    }
}
