package compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 1. Using Comparable: Class Student implements Comparable for Natural Ordering
class Student implements Comparable<Student> {

    String id;
    String name;
    double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    // Override compareTo method for "Natural Ordering"
    // Sorting by ID in ascending order
    @Override
    public int compareTo(Student other) {
        return this.id.compareTo(other.id);
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | GPA: " + gpa;
    }
}

// 2. Creating a separate class implementing Comparator for "Custom Ordering"
// Sorting by GPA descending (If GPA is equal, sort by Name alphabetically)
class GpaComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        if (s1.gpa < s2.gpa) {
            return 1;
        } else if (s1.gpa > s2.gpa) {
            return -1;
        } else {

            return s1.name.compareTo(s2.name);
        }
    }
}

public class COMPARE {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("CE210031", "Nga", 8.5));
        studentList.add(new Student("SE000001", "An", 9.0));
        studentList.add(new Student("SE000002", "Binh", 8.5));

        System.out.println("--- BEFORE SORTING ---");
        for (Student s : studentList) {
            System.out.println(s);
        }

        // Using Comparable (Default sort by ID)
        Collections.sort(studentList);
        System.out.println("\n--- AFTER SORTING WITH COMPARABLE (By ID Ascending) ---");
        for (Student s : studentList) {
            System.out.println(s);
        }

        // Using Comparator (Custom sort by GPA descending)
        Collections.sort(studentList, new GpaComparator());
        System.out.println("\n--- AFTER SORTING WITH COMPARATOR (By GPA Descending, then Name) ---");
        for (Student s : studentList) {
            System.out.println(s);
        }
    }
}
