package pkgenum.generic;

// PART 1: ENUM DEMONSTRATIONS (BASIC & ADVANCED)
/**
 * Basic Enum representing days of the week. Named AppDay to avoid duplicate name conflicts in the package.
 */
enum AppDay {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

/**
 * Advanced Enum representing planets with fields, constructor, and methods. Named AppPlanet to avoid conflicts with existing Planet classes.
 */
enum AppPlanet {
    MERCURY(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6),
    EARTH(5.976e+24, 6.37814e6);

    // Gravitational constant G - valid static constant
    public static final double G = 6.67300E-11;

    private final double mass;   // in kilograms
    private final double radius; // in meters

    AppPlanet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    public double getMass() {
        return this.mass;
    }

    public double getRadius() {
        return this.radius;
    }

    public double surfaceGravity() {
        return G * mass / (radius * radius);
    }

    public double surfaceWeight(double otherMass) {
        return otherMass * surfaceGravity();
    }
}

/**
 * Pure OOP class: Uses instance variables and this keyword. Demonstrates switch-case control structure with Enum.
 */
class DayInWeek {

    private AppDay day; // Instance field

    public DayInWeek(AppDay day) {
        this.day = day;
    }

    public AppDay getDay() {
        return this.day;
    }

    public void setDay(AppDay day) {
        this.day = day;
    }

    public void tellItLikeItIs() {
        switch (this.day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;
            case FRIDAY:
                System.out.println("Fridays are better.");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekends are best.");
                break;
            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }
}

// PART 2: MODELS & GENERIC CLASS (PURE OOP - NO STATIC ABUSE)
class MyCoffee {

    private String name;

    public MyCoffee(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hot " + this.name;
    }
}

class MyMilkTea {

    private String topping;

    public MyMilkTea(String topping) {
        this.topping = topping;
    }

    public String getTopping() {
        return this.topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    @Override
    public String toString() {
        return "Milk Tea with " + this.topping;
    }
}

/**
 * Generic Class: Cup container holding any drink type T.
 *
 * @param <T> the type of drink stored in the cup
 */
class MyCup<T> {

    private T content; // Instance field managed on Heap

    public void pour(T drink) {
        this.content = drink;
        System.out.println("Poured " + drink + " into the cup.");
    }

    public T drinkIt() {
        return this.content;
    }
}

// PART 3: MAIN CLASS & UTILITY GENERIC METHODS
public class EnumGeneric {

    /**
     * Generic Method: Prints an array of any type parameter T.
     */
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /**
     * Generic Method with multi-type parameters: Compares two keys.
     */
    public static <K, V> boolean compareKeys(K key1, K key2) {
        if (key1 == null) {
            return key2 == null;
        }
        return key1.equals(key2);
    }

    /**
     * Generic Method: Simulates serving an order item.
     */
    public static <T> void serveCustomer(T orderItem) {
        System.out.println("--- Waiter is serving ---");
        System.out.println("Here is your: " + orderItem);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {

        System.out.println("=== 1. BASIC ENUM & SWITCH-CASE ===");
        DayInWeek firstDay = new DayInWeek(AppDay.MONDAY);
        firstDay.tellItLikeItIs();

        DayInWeek weekend = new DayInWeek(AppDay.SATURDAY);
        weekend.tellItLikeItIs();

        System.out.println("\n=== 2. ADVANCED ENUM (PLANET CALCULATIONS) ===");
        double yourWeightOnEarth = 60.0;
        double massOnEarth = yourWeightOnEarth / AppPlanet.EARTH.surfaceGravity();

        System.out.println("Your weight (60 kg on Earth) across planets:");
        for (AppPlanet p : AppPlanet.values()) {
            System.out.printf("Weight on %s: %.2f kg%n", p.name(), p.surfaceWeight(massOnEarth));
        }

        System.out.println("\n=== 3. GENERIC METHODS ===");
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"Java", "NetBeans", "PRO192"};
        AppDay[] dayArray = AppDay.values(); // Array of Enum constants

        System.out.print("Integer Array: ");
        printArray(intArray);

        System.out.print("String Array: ");
        printArray(strArray);

        System.out.print("Enum Day Array: ");
        printArray(dayArray);

        boolean isEqual = compareKeys("PRO192", "PRO192");
        System.out.println("Key comparison result: " + isEqual);

        System.out.println("\n=== 4. GENERIC CLASS (CUP<T>) ===");
        // Reusing Cup blueprint with Coffee instance
        Cup<Coffee> morningCup = new Cup<>();
        Coffee blackCoffee = new Coffee("Black Coffee");
        morningCup.pour(blackCoffee);
        serveCustomer(morningCup.drinkIt());

        // Reusing Cup blueprint with MilkTea instance
        Cup<MilkTea> afternoonCup = new Cup<>();
        MilkTea bobaTea = new MilkTea("Boba");
        afternoonCup.pour(bobaTea);
        serveCustomer(afternoonCup.drinkIt());

        // Generic Class storing an Enum type
        Cup<AppPlanet> spaceCup = new Cup<>();
        spaceCup.pour(AppPlanet.EARTH);
        System.out.println("Item inside space cup: " + spaceCup.drinkIt());
    }
}
