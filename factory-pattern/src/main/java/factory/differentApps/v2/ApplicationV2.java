package factory.differentApps.v2;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface Sauce {
}

interface Dough {
}

interface Cheese {
}

interface Veggie {
}

interface Pepperoni {
}

interface Clams {
}

// NY ingredients
class NYThinCrustDough implements Dough {
}

class NYBlackDough implements Dough {
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

// Chicago ingredients
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

interface PizzaIngredientFactory {
    <T> T create(Class<T> ingredientType);
}


class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    @SuppressWarnings("unchecked")
    @Override
    public <T> T create(Class<T> type) {
        if (type == Dough.class) return (T) new NYThinCrustDough();
        if (type == Sauce.class) return (T) new NYMarinaraSauce();
        if (type == Cheese.class) return (T) new NYReggianoCheese();
        if (type == Veggie.class) return (T) new NYVeggie();
        if (type == Pepperoni.class) return (T) new NYPepperoni();
        if (type == Clams.class) return (T) new NYClams();
        throw new IllegalArgumentException("Unknown ingredient type: " + type);
    }
}

class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

    @SuppressWarnings("unchecked")
    @Override
    public <T> T create(Class<T> type) {
        if (type == Dough.class) return (T) new ChicagoThickCrustDough();
        if (type == Sauce.class) return (T) new ChicagoPlumTomatoSauce();
        if (type == Cheese.class) return (T) new ChicagoMozzarellaCheese();
        if (type == Veggie.class) return (T) new ChicagoVeggie();
        if (type == Pepperoni.class) return (T) new ChicagoPepperoni();
        if (type == Clams.class) return (T) new ChicagoClams();
        throw new IllegalArgumentException("Unknown ingredient type: " + type);
    }
}


abstract class Pizza {

    protected final Map<Class<?>, Object> ingredients = new HashMap<>();
    protected PizzaIngredientFactory factory;

    public Pizza(PizzaIngredientFactory factory) {
        this.factory = factory;
    }

    public final void preparePizza() {
        prepareIngredient(Dough.class);
        prepareIngredient(Sauce.class);
        prepareIngredient(Cheese.class);
        prepareIngredient(Veggie.class);
        prepareIngredient(Pepperoni.class);
        prepareIngredient(Clams.class);

        System.out.println("Prepared Pizza: " + getClass().getSimpleName());
        ingredients.forEach((type, list) -> {
            System.out.println(" - " + type.getSimpleName() + ": " + list + " items");
        });
    }

    protected <T> void prepareIngredient(Class<T> type) {
        Object list = ingredients.get(type);
        if (list == null) {
            T ingredient = factory.create(type);
            ingredients.put(type, ingredient);
        }
    }

    // dynamic ingredient override
    public <T> void setIngredient(Class<T> type,
                                  T ingredient) {
        ingredients.put(type, ingredient);
    }

    // access ingredients
    public <T> List<T> getIngredients(Class<T> type) {
        return (List<T>) ingredients.getOrDefault(type, Collections.emptyList());
    }
}


class CheesePizza extends Pizza {
    public CheesePizza(PizzaIngredientFactory factory) {
        super(factory);
    }
}

class ApplicationV2 {
    public static void main(String[] args) {

        PizzaIngredientFactory nyFactory = new NYPizzaIngredientFactory();
        CheesePizza nyPizza = new CheesePizza(nyFactory);

        // default NY dough
        nyPizza.preparePizza();

        // override dough dynamically
        nyPizza.setIngredient(Dough.class, new NYBlackDough());
        nyPizza.preparePizza();


        // Chicago pizza
        PizzaIngredientFactory chicagoFactory = new ChicagoPizzaIngredientFactory();
        CheesePizza chicagoPizza = new CheesePizza(chicagoFactory);
        chicagoPizza.preparePizza();
    }
}
