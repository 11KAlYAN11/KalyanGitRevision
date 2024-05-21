import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaMethodExpresson2 {
    // Method that filters a list of items based on a given predicate
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Edward");

        // Predicate to filter names that start with 'A'
        Predicate<String> startsWithA = str -> str.startsWith("A");
        List<String> namesStartingWithA = filter(names, startsWithA);
        System.out.println("Names starting with 'A': " + namesStartingWithA);

        // Predicate to filter names that have more than 3 characters
        Predicate<String> lengthGreaterThan3 = str -> str.length() > 3;
        List<String> longNames = filter(names, lengthGreaterThan3);
        System.out.println("Names with more than 3 characters: " + longNames);

        // Combining predicates using 'and'
        Predicate<String> startsWithAAndLong = startsWithA.and(lengthGreaterThan3);
        List<String> longNamesStartingWithA = filter(names, startsWithAAndLong);
        System.out.println("Names starting with 'A' and with more than 3 characters: " + longNamesStartingWithA);

        // Combining predicates using 'or'
        Predicate<String> startsWithAOrLong = startsWithA.or(lengthGreaterThan3);
        List<String> namesStartingWithAOrLong = filter(names, startsWithAOrLong);
        System.out.println("Names starting with 'A' or with more than 3 characters: " + namesStartingWithAOrLong);

        // Negating a predicate
        Predicate<String> notStartsWithA = startsWithA.negate();
        List<String> namesNotStartingWithA = filter(names, notStartsWithA);
        System.out.println("Names not starting with 'A': " + namesNotStartingWithA);
    }
}
