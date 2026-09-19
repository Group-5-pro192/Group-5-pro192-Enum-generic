enum Level {
    LOW, 
    MEDIUM, 
    HIGH, 
    URGENT
}

public class EnumTest { 
    public static void main(String[] args) {
        
        Level[] allLevels = Level.values();
        
        for (Level lvl : allLevels) {
            System.out.println("Cấp độ: " + lvl);
        }
    }
}