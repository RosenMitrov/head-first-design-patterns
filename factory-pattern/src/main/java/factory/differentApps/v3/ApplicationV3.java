package factory.differentApps.v3;

// ========= INGREDIENT INTERFACES =========
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

// ========= NY INGREDIENTS =========
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

// ========= PIZZA =========
abstract class Pizza {

    protected Dough dough;
    protected Sauce sauce;
    protected Cheese cheese;
    protected Veggie veggie;
    protected Pepperoni pepperoni;
    protected Clams clams;

    protected final PizzaIngredientFactory factory;

    protected Pizza(PizzaIngredientFactory factory) {
        this.factory = factory;
    }

    public abstract void prepare();

    public void bake() {
        System.out.println("Baking pizza...");
    }

    // Explicit, safe runtime override
    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void printIngredients() {
        System.out.println("Ingredients:");
        if (dough != null) System.out.println(" - Dough: " + dough.getClass().getSimpleName());
        if (sauce != null) System.out.println(" - Sauce: " + sauce.getClass().getSimpleName());
        if (cheese != null) System.out.println(" - Cheese: " + cheese.getClass().getSimpleName());
        if (veggie != null) System.out.println(" - Veggie: " + veggie.getClass().getSimpleName());
        if (pepperoni != null) System.out.println(" - Pepperoni: " + pepperoni.getClass().getSimpleName());
        if (clams != null) System.out.println(" - Clams: " + clams.getClass().getSimpleName());
        System.out.println();
    }
}

// ========= CONCRETE PIZZA =========
class CheesePizza extends Pizza {

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
}

// ========= APPLICATION =========
class ApplicationV3 {

    public static void main(String[] args) {

        // NY pizza
        PizzaIngredientFactory nyFactory = new NYPizzaIngredientFactory();
        CheesePizza nyPizza = new CheesePizza(nyFactory);

        nyPizza.prepare();
        nyPizza.bake();
        nyPizza.printIngredients();

        // Override dough dynamically
        nyPizza.setDough(new NYBlackDough());
        System.out.println("After dough override:");
        nyPizza.printIngredients();

        // Chicago pizza
        PizzaIngredientFactory chicagoFactory = new ChicagoPizzaIngredientFactory();
        CheesePizza chicagoPizza = new CheesePizza(chicagoFactory);

        chicagoPizza.prepare();
        chicagoPizza.bake();
        chicagoPizza.printIngredients();
    }
}
