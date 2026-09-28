package demo2generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 1: GENERIC CLASS  //
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

    public void placeOrder(K orderId, V itemDetails) {
        orders.put(orderId, itemDetails);
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

    private T drink;
    private S snack;
    private U isDiscounted;

    public SpecialCombo(T drink, S snack, U isDiscounted) {
        this.drink = drink;
        this.snack = snack;
        this.isDiscounted = isDiscounted;
    }

    public void showComboDetails() {
        System.out.println("--- Combo Details ---");
        System.out.println("Drink: " + drink + " | Snack: " + snack + " | Discount applied: " + isDiscounted);
    }
}
// 2: MAIN & GENERIC METHOD

public class Demo2generic {

    public static <M> void serveCustomer(M orderItem) {
        System.out.println("🧑‍🍳 Serving: " + orderItem);
    }

    public static <G> G giveSurpriseGift(G gift) {
        System.out.println("🎁 Giving customer a gift: " + gift);
        return gift;
    }

    public static void main(String[] args) {
        System.out.println("=== ☕ COMPREHENSIVE BEVERAGE SYSTEM ===\n");

        Drink<String> myCoffee = new Drink<>("Black Iced Coffee");

        ToppingMenu<String> menu = new ToppingMenu<>();
        menu.addTopping("White Pearl");
        menu.addTopping("Cheese Jelly");
        menu.printMenu();
        System.out.println();

        OrderManager<Integer, String> system = new OrderManager<>();
        system.placeOrder(1001, myCoffee.getName());
        system.placeOrder(1002, "Oolong Milk Tea - Extra pearls");
        system.printAllOrders();
        System.out.println();

        BillCalculator<Integer> intBill = new BillCalculator<>(50000);
        System.out.println("--- Payment ---");
        System.out.println("Bill (including VAT): " + intBill.getTotalWithVAT() + " VND\n");

        SpecialCombo<String, String, Boolean> combo = new SpecialCombo<>("Peach Tea", "Flan Cake", true);
        combo.showComboDetails();
        System.out.println();

        System.out.println("=== CALLING INDEPENDENT GENERIC METHODS ===");

        serveCustomer(myCoffee.getName());
        serveCustomer(1001);
        serveCustomer(combo);

        System.out.println();

        String textGift = giveSurpriseGift("20% Discount Voucher");
        Integer cashGift = giveSurpriseGift(50000);
    }
}
