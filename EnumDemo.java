enum Planet {
    MERCURY(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6),
    EARTH(5.976e+24, 6.37814e6); 

    private final double mass;
    private final double radius;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    public static final double G = 6.67300E-11;

    double surfaceGravity() {
        return G * mass / (radius * radius);
    }

    double surfaceWeight(double otherMass) {
        return otherMass * surfaceGravity();
    }
}

public class EnumDemo {
    public static void main(String[] args) {
        double yourWeightOnEarth = 60.0; 
        
        double mass = yourWeightOnEarth / Planet.EARTH.surfaceGravity();

        System.out.println("Kết quả đo trọng lượng của bạn (60kg) trên các hành tinh:");
        System.out.println("---------------------------------------------------------");
        
        for (Planet p : Planet.values()) {
            System.out.printf("Trọng lượng trên %s là: %.2f kg%n", p, p.surfaceWeight(mass));
        }
    }
}