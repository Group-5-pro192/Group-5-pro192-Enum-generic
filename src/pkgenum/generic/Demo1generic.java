package demo1generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Drink<T> {

    private T name;

    public Drink(T name) {
        this.name = name;
    }

    public T getName() {
        return name;
    }
}

class ToppingMenu<E> {

    private List<E> toppings = new ArrayList<>();

    public void addTopping(E topping) {
        toppings.add(topping);
    }

    public void printMenu() {
        System.out.println("--- Topping List ---");
        for (E t : toppings) {
            System.out.println("- " + t);
        }
    }
}

class OrderManager<K, V> {

    private Map<K, V> orders = new HashMap<>();

    public void placeOrder(K orderId, V drinkName) {
        orders.put(orderId, drinkName);
    }

    public void printAllOrders() {
        System.out.println("--- Order List ---");
        for (Map.Entry<K, V> entry : orders.entrySet()) {
            System.out.println("Order ID [" + entry.getKey() + "] : " + entry.getValue());
        }
    }
}

class BillCalculator<N extends Number> {

    private N price;

    public BillCalculator(N price) {
        this.price = price;
    }

    public double getTotalWithVAT() {
        return this.price.doubleValue() * 1.10;
    }
}

class SpecialCombo<T, S, U> {

    private T drink;    // Drink (Type T)
    private S snack;    // Snack (Type S)
    private U hasGift;  // Has a complimentary gift? (Type U)

    public SpecialCombo(T drink, S snack, U hasGift) {
        this.drink = drink;
        this.snack = snack;
        this.hasGift = hasGift;
    }

    public void showComboDetails() {
        System.out.println("--- Combo Details ---");
        System.out.println("Drink: " + drink);
        System.out.println("Snack: " + snack);
        System.out.println("Includes gift: " + hasGift);
    }
}

public class Demo1generic {

    public static void main(String[] args) {
        System.out.println("=== BEVERAGE SHOP MANAGEMENT SYSTEM (Student: Nguyen Van A) ===\n");

        // [T] - Initialize drinks
        Drink<String> myCoffee = new Drink<>("Black Iced Coffee");
        Drink<String> myMilkTea = new Drink<>("Oolong Milk Tea");

        // [E] - Add elements to the Topping list
        ToppingMenu<String> menu = new ToppingMenu<>();
        menu.addTopping("White Pearl");
        menu.addTopping("Cheese Jelly");
        menu.printMenu();
        System.out.println();

        // [K, V] - Manage orders (Order ID of type Integer, Drink name of type String)
        OrderManager<Integer, String> system = new OrderManager<>();
        system.placeOrder(1001, myCoffee.getName());
        system.placeOrder(1002, myMilkTea.getName());
        system.printAllOrders();
        System.out.println();

        // [N] - Calculate bill (Only accepts numbers: Integer, Double, Float...)
        BillCalculator<Integer> intBill = new BillCalculator<>(50000); // Pass integer
        BillCalculator<Double> doubleBill = new BillCalculator<>(65500.50); // Pass double

        System.out.println("--- Payment ---");
        System.out.println("Bill 1 (VAT): " + intBill.getTotalWithVAT() + " VND");
        System.out.println("Bill 2 (VAT): " + doubleBill.getTotalWithVAT() + " VND");
        System.out.println();

        // [S, U, T] - Create a combo with 3 different data types (String, String, Boolean)
        SpecialCombo<String, String, Boolean> studentCombo
                = new SpecialCombo<>(myMilkTea.getName(), "Sweet Cake", true);
        studentCombo.showComboDetails();
    }
}
