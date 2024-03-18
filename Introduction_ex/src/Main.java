import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.SortedMap;


public class Main {
    
    public static <T> T[] reverseArray(T[] arr) {
        T[] returnArr = (T[]) (new Object[arr.length]); // I hate java I hate java I hate java I hate java I hate java I hate java
        for (int i = 0; i < arr.length; i++) {
            returnArr[arr.length - 1 - i] = arr[i];
        }
        return returnArr;
    }

    private static String findLongestString(String s1, String s2) {
        if (s1.length() >= s2.length()) {
            return s1;
        }
        return s2;
    }

    private static String findShortestString(String s1, String s2) {
        if (s1.length() < s2.length()) {
            return s1;
        }
        return s2;
    }

    public static String interweave(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        String longer = findLongestString(s1, s2);
        String shorter = findShortestString(s1, s2);
        for (int i = 0; i < longer.length(); i++) {
            if (i < shorter.length()) {
                sb.append(longer.charAt(i));
                sb.append(shorter.charAt(i));
            } else {
                sb.append(longer.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyArrayList<Integer> ints = new MyArrayList<>();
        ints.add(2);
        ints.add(3);
        System.out.println(ints.size());
        System.out.println(ints.get(1));
        ints.remove(0);
        System.out.println(ints.size());
        ints.remove(0);
        System.out.println(ints.size());
        // ints.remove(10);

        System.out.println("Pick a number, any number! Remember it.");
        boolean win = false;
        Scanner sc = new Scanner(System.in);
        int max = Integer.MAX_VALUE; // essentially allows for arbitrarily large numbers
        int min = 0;
        int currentGuess = max / 2; // initial guess

        while (!win) {
            System.out.println("Is your number greater than, less than or equal to: " + currentGuess + "? (g/l/e) > ");
            String inpt = sc.next();
            if (inpt.equalsIgnoreCase("e")) {
                win = true;
                System.out.println("Yay! I got it!");
            } else if (inpt.equalsIgnoreCase("g")) {
                min = currentGuess;
                currentGuess = (max + min + 1) / 2; // +1 is needed so we dont get stuck on smth like (9999 + 10000) / 2
            } else if (inpt.equalsIgnoreCase("l")) {
                max = currentGuess;
                currentGuess = (max + min) / 2;
            }
        }
        Integer[] ints2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Example array: " + Arrays.toString(ints2));
        System.out.println("The same array bacwards: " + Arrays.toString(reverseArray(ints2)));

        String eva = "EvaMagdalena";
        String ola = "OlaOlsson";
        System.out.println(interweave(eva, ola));
    }
}