package pkgenum.generic;

        enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY 
}

public class Enum { 
    Day d;
    
    public Enum(Day d) { 
        this.d = d; 
    }

    public void tellItLikeItIs() {
        switch (d) { 
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

    public static void main(String[] args) {
        Enum firstDay = new Enum(Day.MONDAY);
        firstDay.tellItLikeItIs(); 
        
        Enum weekend = new Enum(Day.SATURDAY);
        weekend.tellItLikeItIs(); 
    }
}