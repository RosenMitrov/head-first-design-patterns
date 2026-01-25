package factory.differentApps.v1;// UltimateOOIngredientsPizza.java

import java.util.ArrayList;
import java.util.List;

// === Ingredient Interfaces ===
interface Dough {
    String getName();
}

interface Sauce {
    String getName();
}

interface Cheese {
    String getName();
}

interface ToppingIngredient {
    String getName();
}

// === Concrete Dough ===
class ThinCrust implements Dough {
    public String getName() {
        return "Thin Crust";
    }
}

class ThickCrust implements Dough {
    public String getName() {
        return "Thick Crust";
    }
}

class GlutenFree implements Dough {
    public String getName() {
        return "Gluten-Free Crust";
    }
}

// === Concrete Sauce ===
class TomatoBasilSauce implements Sauce {
    public String getName() {
        return "Tomato Basil Sauce";
    }
}

class BBQSauce implements Sauce {
    public String getName() {
        return "BBQ Sauce";
    }
}

class PestoSauce implements Sauce {
    public String getName() {
        return "Pesto Sauce";
    }
}

// === Concrete Cheese ===
class Mozzarella implements Cheese {
    public String getName() {
        return "Mozzarella";
    }
}

class Cheddar implements Cheese {
    public String getName() {
        return "Cheddar";
    }
}

class VeganCheese implements Cheese {
    public String getName() {
        return "Vegan Cheese";
    }
}

// === Concrete Toppings ===
class Basil implements ToppingIngredient {
    public String getName() {
        return "Basil";
    }
}

class Olives implements ToppingIngredient {
    public String getName() {
        return "Olives";
    }
}

class BellPeppers implements ToppingIngredient {
    public String getName() {
        return "Bell Peppers";
    }
}

class Onion implements ToppingIngredient {
    public String getName() {
        return "Onion";
    }
}

class Pepperoni implements ToppingIngredient {
    public String getName() {
        return "Pepperoni";
    }
}

class Bacon implements ToppingIngredient {
    public String getName() {
        return "Bacon";
    }
}

class Spinach implements ToppingIngredient {
    public String getName() {
        return "Spinach";
    }
}

// === Pizza Interface ===
interface Pizza {
    void prepare();

    void bake();

    String getDescription();
}

// === Base Pizza ===
class BasePizza implements Pizza {
    private final Dough dough;
    private final Sauce sauce;
    private final Cheese cheese;

    public BasePizza(Dough dough,
                     Sauce sauce,
                     Cheese cheese) {
        this.dough = dough;
        this.sauce = sauce;
        this.cheese = cheese;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing pizza: " + getDescription());
    }

    @Override
    public void bake() {
        System.out.println("Baking pizza...");
        System.out.println("Pizza is ready!\n");
    }

    @Override
    public String getDescription() {
        return dough.getName() + ", " + sauce.getName() + ", " + cheese.getName();
    }
}

// === Decorator for toppings ===
abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public void prepare() {
        pizza.prepare();
    }

    @Override
    public void bake() {
        pizza.bake();
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }
}

class Topping extends PizzaDecorator {
    private final ToppingIngredient topping;

    public Topping(Pizza pizza,
                   ToppingIngredient topping) {
        super(pizza);
        this.topping = topping;
    }

    @Override
    public void prepare() {
        super.prepare();
        System.out.println("Adding topping: " + topping.getName());
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", " + topping.getName();
    }
}

// === Builder ===
class PizzaBuilder {
    private Dough dough;
    private Sauce sauce;
    private Cheese cheese;
    private final List<ToppingIngredient> toppings = new ArrayList<>();

    public PizzaBuilder setDough(Dough dough) {
        this.dough = dough;
        return this;
    }

    public PizzaBuilder setSauce(Sauce sauce) {
        this.sauce = sauce;
        return this;
    }

    public PizzaBuilder setCheese(Cheese cheese) {
        this.cheese = cheese;
        return this;
    }

    public PizzaBuilder addTopping(ToppingIngredient topping) {
        toppings.add(topping);
        return this;
    }

    public Pizza build() {
        Pizza pizza = new BasePizza(dough, sauce, cheese);
        for (ToppingIngredient t : toppings) {
            pizza = new Topping(pizza, t);
        }
        return pizza;
    }
}

// === Abstract Factory ===
interface PizzaFactory {
    Pizza createPizza(String type);
}

// === Concrete Factories ===
class ItalianPizzaFactory implements PizzaFactory {
    @Override
    public Pizza createPizza(String type) {
        return switch (type.toLowerCase()) {
            case "margherita" -> new PizzaBuilder()
                    .setDough(new ThinCrust())
                    .setSauce(new TomatoBasilSauce())
                    .setCheese(new Mozzarella())
                    .addTopping(new Basil())
                    .build();
            case "veggie" -> new PizzaBuilder()
                    .setDough(new ThinCrust())
                    .setSauce(new TomatoBasilSauce())
                    .setCheese(new Mozzarella())
                    .addTopping(new BellPeppers())
                    .addTopping(new Olives())
                    .addTopping(new Onion())
                    .build();
            default -> throw new IllegalArgumentException("Unknown pizza type: " + type);
        };
    }
}

class AmericanPizzaFactory implements PizzaFactory {
    @Override
    public Pizza createPizza(String type) {
        return switch (type.toLowerCase()) {
            case "cheese" -> new PizzaBuilder()
                    .setDough(new ThickCrust())
                    .setSauce(new BBQSauce())
                    .setCheese(new Cheddar())
                    .build();
            case "meatlover" -> new PizzaBuilder()
                    .setDough(new ThickCrust())
                    .setSauce(new BBQSauce())
                    .setCheese(new Cheddar())
                    .addTopping(new Pepperoni())
                    .addTopping(new Bacon())
                    .build();
            default -> throw new IllegalArgumentException("Unknown pizza type: " + type);
        };
    }
}

// === Store with DI ===
class PizzaStore {
    private final PizzaFactory factory;

    public PizzaStore(PizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type,
                            List<ToppingIngredient> extraToppings) {
        Pizza pizza = factory.createPizza(type);
        for (ToppingIngredient t : extraToppings) {
            pizza = new Topping(pizza, t);
        }
        pizza.prepare();
        pizza.bake();
        pizza.getDescription();
        return pizza;
    }
}

// === Factory Provider ===
class FactoryProvider {
    public static PizzaFactory getFactory(String region) {
        return switch (region.toLowerCase()) {
            case "italy" -> new ItalianPizzaFactory();
            case "usa" -> new AmericanPizzaFactory();
            default -> throw new IllegalArgumentException("Unknown region: " + region);
        };
    }
}

// === Demo ===
class ApplicationV1 {
    public static void main(String[] args) {
        PizzaStore italianStore = new PizzaStore(FactoryProvider.getFactory("Italy"));
        PizzaStore americanStore = new PizzaStore(FactoryProvider.getFactory("USA"));

        // Preset pizzas with extra toppings
        Pizza margherita = italianStore.orderPizza("margherita", List.of(new Olives(), new Olives(), new Spinach()));
        System.out.println(margherita.getDescription());
        italianStore.orderPizza("veggie", List.of(new Basil()));

        americanStore.orderPizza("cheese", List.of(new BellPeppers()));
        americanStore.orderPizza("meatlover", List.of(new Onion()));

        // Fully custom pizza using builder and ingredient objects
        Pizza customPizza = new PizzaBuilder()
                .setDough(new GlutenFree())
                .setSauce(new PestoSauce())
                .setCheese(new VeganCheese())
                .addTopping(new Spinach())
                .addTopping(new Olives())
                .addTopping(new Basil())
                .build();
        customPizza.prepare();
        customPizza.bake();
    }
}

