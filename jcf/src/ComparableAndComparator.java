import java.util.Arrays;
import java.util.Comparator;

public class ComparableAndComparator {
    public static void main(String[] args) {
        String[] names = {"Clooney", "Brad", "Steve", "Angelina", "Penelope", "Charlie"};

        Arrays.sort(names);

        System.out.println("Default sorting using Comparable ");
        for(String name : names) {
            System.out.println(name);
        }

        System.out.println("Sorting based on length");

//        Arrays.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        });

        Arrays.sort(names, (o1, o2) -> o1.length() - o2.length());

        for(String name : names) {
            System.out.println(name);
        }

    }
}
