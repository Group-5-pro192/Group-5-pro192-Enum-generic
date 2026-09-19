package pkgenum.generic;

class Coffee {

    private String name;

    public Coffee(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hot " + this.name;
    }
}

class MilkTea {

    private String topping;

    public MilkTea(String topping) {
        this.topping = topping;
    }

    @Override
    public String toString() {
        return "Milk Tea with " + this.topping;
    }
}

// 2. HOW TO CREATE A GENERIC CLASS
class Cup<T> {

    private T content;

    public void pour(T drink) {
        this.content = drink;
        System.out.println("Poured something into the cup.");
    }

    public T drinkIt() {
        return content;
    }
}

public class DemoGeneric {

    // 3. HOW TO CREATE A GENERIC METHOD
    public static <T> void serveCustomer(T orderItem) {
        System.out.println("--- Waiter is serving ---");
        System.out.println("Here is your: " + orderItem);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {

        System.out.println("=== SCENARIO 1: MORNING COFFEE ===");
        // STEP 1: USE GENERIC CLASS WITH COFFEE TYPE

        Cup<Coffee> morningCup = new Cup<>();
        Coffee blackCoffee = new Coffee("Black Coffee");

        morningCup.pour(blackCoffee);

        Coffee myDrink = morningCup.drinkIt();
        System.out.println(myDrink.toString());

        System.out.println("\n=== SCENARIO 2: AFTERNOON MILK TEA ===");
        // STEP 2: REUSE THE CUP BLUEPRINT WITH MILKTEA TYPE
        Cup<MilkTea> afternoonCup = new Cup<>();
        MilkTea bobaTea = new MilkTea("Boba");

        afternoonCup.pour(bobaTea);

        MilkTea mySweetDrink = afternoonCup.drinkIt();
        System.out.println(mySweetDrink.toString());

        System.out.println("\n=== SCENARIO 3: USING GENERIC METHOD ===");
        // STEP 3: USE GENERIC METHOD TO SERVE

        serveCustomer(myDrink);
        serveCustomer(mySweetDrink);
    }
}
