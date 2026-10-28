package basics.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class ListRemovalDemo {
    public static void main(String[] args) {
        testForEachRemoval("First", "A", true);
        testForEachRemoval("Middle", "C", false);
        testForEachRemoval("Second to last", "D", false);
        testForEachRemoval("Last", "E", false);
        testIteratorRemoval();
        testRemoveIf();
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

    private static void testIteratorRemoval() {
        List<String> values = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));
        Iterator<String> iterator = values.iterator();

        while (iterator.hasNext()) {
            String value = iterator.next();
            if (value.equals("B") || value.equals("D")) {
                iterator.remove();
            }
        }

        System.out.println("Iterator.remove example:");
        System.out.println("Remaining values: " + values);
    }

    private static void testRemoveIf() {
        List<String> values = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));
        boolean removed = values.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String value) {
                return value.equals("B") || value.equals("D");
            }
        });

        System.out.println("removeIf example:");
        System.out.println("Removed any values: " + removed);
        System.out.println("Remaining values: " + values);
    }
}
