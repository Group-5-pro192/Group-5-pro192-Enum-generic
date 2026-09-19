package democoffe;

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

// 2. CÁCH TẠO GENERIC CLASS
class Cup<T> {

    private T content;

    // Phương thức nhận vào tham số kiểu T 
    public void pour(T drink) {
        this.content = drink;
        System.out.println("Poured something into the cup.");
    }

    // Phương thức trả về dữ liệu kiểu T 
    public T drinkIt() {
        System.out.print("Drinking: ");
        return this.content;
    }
}

public class DEMOCOFFE {

    // 4. CÁCH TẠO GENERIC METHOD
    public static <E> void serveToCustomer(E orderItem) {
        System.out.println("--- Waiter is serving ---");
        System.out.println("Here is your: " + orderItem.toString());
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {

        System.out.println("=== SCENARIO 1: MORNING COFFEE ===");
        // BƯỚC 1: SỬ DỤNG GENERIC CLASS VỚI KIỂU COFFEE

        Cup<Coffee> morningCup = new Cup<>();
        Coffee blackCoffee = new Coffee("Black Coffee");

        morningCup.pour(blackCoffee);

        Coffee myDrink = morningCup.drinkIt();
        System.out.println(myDrink.toString());

        System.out.println("\n=== SCENARIO 2: AFTERNOON MILK TEA ===");
        // BƯỚC 2: TÁI SỬ DỤNG BẢN THIẾT KẾ CUP NHƯNG VỚI KIỂU MILKTEA
        Cup<MilkTea> afternoonCup = new Cup<>();
        MilkTea bobaTea = new MilkTea("Boba");

        afternoonCup.pour(bobaTea);

        MilkTea mySweetDrink = afternoonCup.drinkIt();
        System.out.println(mySweetDrink.toString());

        System.out.println("\n=== SCENARIO 3: USING GENERIC METHOD ===");
        // BƯỚC 3: SỬ DỤNG GENERIC METHOD ĐỂ PHỤC VỤ

        serveToCustomer(myDrink);
        serveToCustomer(mySweetDrink);
    }
}
