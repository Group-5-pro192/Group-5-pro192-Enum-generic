package pkgenum.generic;

public class EnumGeneric {

    // Generic Method: Type parameter <T> placed BEFORE the return type void
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Generic Method with two type parameters K, V returning a boolean
    public static <K, V> boolean compareKeys(K key1, K key2) {
        return key1.equals(key2);
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"Java", "NetBeans", "PRO192"};

        // Calling generic method with different array types
        EnumGeneric.printArray(intArray);
        EnumGeneric.printArray(strArray);
    }

}
