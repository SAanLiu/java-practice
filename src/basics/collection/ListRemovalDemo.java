package basics.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;

public class ListRemovalDemo {
    public static void main(String[] args) {
        testForEachRemoval("First", "A", true);
        testForEachRemoval("Middle", "C", false);
        testForEachRemoval("Second to last", "D", false);
        testForEachRemoval("Last", "E", false);
    }

    private static void testForEachRemoval(String position, String target,
                                           boolean printStackTrace) {
        List<String> values = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));
        System.out.println(position + " element: " + target);

        try {
            for (String value : values) {
                if (value.equals(target)) {
                    values.remove(value);
                }
            }
            System.out.println("Exception: none");
        } catch (ConcurrentModificationException exception) {
            System.out.println("Exception: " + exception.getClass().getSimpleName());
            if (printStackTrace) {
                exception.printStackTrace(System.out);
            }
        }

        System.out.println("Remaining values: " + values);
        System.out.println();
    }
}
