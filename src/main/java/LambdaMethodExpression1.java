import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaMethodExpression1 {
     public static List<String> filterStrings(List<String> strings, Predicate<String> condition) {
        List<String> result = new ArrayList<>();
        for (String str : strings) {
            if (condition.test(str)) {
                result.add(str);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Edward");

        // Using a lambda expression to filter names that start with the letter 'A'
        List<String> filteredNames = filterStrings(names, str -> str.startsWith("A"));

        System.out.println("Names starting with 'A': " + filteredNames);

        // Using another lambda expression to filter names that have more than 3 characters
        List<String> longNames = filterStrings(names, str -> str.length() > 3);

        System.out.println("Names with more than 3 characters: " + longNames);
    }
    
}
