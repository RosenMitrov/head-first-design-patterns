package factory.differentApps.v4;

import java.util.ArrayList;
import java.util.List;

// ========= INGREDIENT INTERFACES =========
interface Dough {
}

interface Sauce {
}

interface Cheese {
}

interface Veggie {
}

interface Pepperoni {
}

interface Clams {
}

// ========= NY INGREDIENTS =========
class NYThinCrustDough implements Dough {
}

class NYMarinaraSauce implements Sauce {
}

class NYReggianoCheese implements Cheese {
}

class NYVeggie implements Veggie {
}

class NYPepperoni implements Pepperoni {
}

class NYClams implements Clams {
}

// ========= CHICAGO INGREDIENTS =========
class ChicagoThickCrustDough implements Dough {
}

class ChicagoPlumTomatoSauce implements Sauce {
}

class ChicagoMozzarellaCheese implements Cheese {
}

class ChicagoVeggie implements Veggie {
}

class ChicagoPepperoni implements Pepperoni {
}

class ChicagoClams implements Clams {
}

// ========= ABSTRACT FACTORY =========
interface PizzaIngredientFactory {
    Dough createDough();

    Sauce createSauce();

    Cheese createCheese();

    Veggie createVeggie();

    Pepperoni createPepperoni();

    Clams createClams();
}

// ========= NY FACTORY =========
class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    public Dough createDough() {
        return new NYThinCrustDough();
    }

    public Sauce createSauce() {
        return new NYMarinaraSauce();
    }

    public Cheese createCheese() {
        return new NYReggianoCheese();
    }

    public Veggie createVeggie() {
        return new NYVeggie();
    }

    public Pepperoni createPepperoni() {
        return new NYPepperoni();
    }

    public Clams createClams() {
        return new NYClams();
    }
}

// ========= CHICAGO FACTORY =========
class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    public Dough createDough() {
        return new ChicagoThickCrustDough();
    }

    public Sauce createSauce() {
        return new ChicagoPlumTomatoSauce();
    }

    public Cheese createCheese() {
        return new ChicagoMozzarellaCheese();
    }

    public Veggie createVeggie() {
        return new ChicagoVeggie();
    }

    public Pepperoni createPepperoni() {
        return new ChicagoPepperoni();
    }

    public Clams createClams() {
        return new ChicagoClams();
    }
}

// ========= BASE PIZZA =========
abstract class Pizza {

    // Only dynamic toppings go here
    protected final List<Object> extraToppings = new ArrayList<>();
    protected final PizzaIngredientFactory factory;

    protected Pizza(PizzaIngredientFactory factory) {
        this.factory = factory;
    }

    // Each concrete pizza decides all its core ingredients
    public abstract void prepare();

    // Add extra ingredient dynamically
    public <T> void addTopping(T topping) {
        extraToppings.add(topping);
    }

    // Bake (same for all)
    public void bake() {
        System.out.println("Baking pizza...");
    }

    // Print core + extra toppings
    public abstract void printIngredients();
}

// ========= CONCRETE PIZZAS =========
class CheesePizza extends Pizza {

    private Dough dough;
    private Sauce sauce;
    private Cheese cheese;

    public CheesePizza(PizzaIngredientFactory factory) {
        super(factory);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing Cheese Pizza");
        dough = factory.createDough();
        sauce = factory.createSauce();
        cheese = factory.createCheese();
    }

    @Override
    public void printIngredients() {
        System.out.println("Ingredients for CheesePizza:");
        System.out.println(" - Dough: " + dough.getClass().getSimpleName());
        System.out.println(" - Sauce: " + sauce.getClass().getSimpleName());
        System.out.println(" - Cheese: " + cheese.getClass().getSimpleName());
        for (Object t : extraToppings) {
            System.out.println(" - Extra: " + t.getClass().getSimpleName());
        }
        System.out.println();
    }
}

class ClamPizza extends Pizza {

    private Dough dough;
    private Sauce sauce;
    private Cheese cheese;
    private Clams clams;

    public ClamPizza(PizzaIngredientFactory factory) {
        super(factory);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing Clam Pizza");
        dough = factory.createDough();
        sauce = factory.createSauce();
        cheese = factory.createCheese();
        clams = factory.createClams();
    }

    @Override
    public void printIngredients() {
        System.out.println("Ingredients for ClamPizza:");
        System.out.println(" - Dough: " + dough.getClass().getSimpleName());
        System.out.println(" - Sauce: " + sauce.getClass().getSimpleName());
        System.out.println(" - Cheese: " + cheese.getClass().getSimpleName());
        System.out.println(" - Clams: " + clams.getClass().getSimpleName());
        for (Object t : extraToppings) {
            System.out.println(" - Extra: " + t.getClass().getSimpleName());
        }
        System.out.println();
    }
}

// ========= APPLICATION =========
public class ApplicationV4 {

    public static void main(String[] args) {

        // NY Cheese Pizza
        PizzaIngredientFactory nyFactory = new NYPizzaIngredientFactory();
        CheesePizza nyCheesePizza = new CheesePizza(nyFactory);
        nyCheesePizza.prepare();
        // dynamically add pepperoni to a CheesePizza
        nyCheesePizza.addTopping(nyFactory.createPepperoni());
        nyCheesePizza.bake();
        nyCheesePizza.printIngredients();


        // Chicago Clam Pizza
        PizzaIngredientFactory chicagoFactory = new ChicagoPizzaIngredientFactory();
        ClamPizza chicagoClamPizza = new ClamPizza(chicagoFactory);
        chicagoClamPizza.prepare();
        chicagoClamPizza.bake();
        chicagoClamPizza.printIngredients();

    }
}
