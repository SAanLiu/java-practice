package basics.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.BiFunction;

public class WordFrequencyDemo {
    private static final String TEXT =
            "Java collections organize data. Java maps store words. " +
            "Java lists store values. Collections make Java programs clearer. " +
            "A map counts words, and words reveal patterns. " +
            "Practice with Java maps helps us understand collections. " +
            "More practice with words makes Java easier to learn.";

    public static void main(String[] args) {
        String[] words = TEXT.toLowerCase(Locale.ROOT).split("[^a-z]+");

        Map<String, Integer> getOrDefaultCounts = countWithGetOrDefault(words);
        Map<String, Integer> mergeCounts = countWithMerge(words);

        System.out.println("Text: " + TEXT);
        System.out.println("The two methods agree: " + getOrDefaultCounts.equals(mergeCounts));
        System.out.println("Word frequencies:");
        printAllCounts(getOrDefaultCounts);
        printTopThree("getOrDefault", getOrDefaultCounts);
        printTopThree("merge", mergeCounts);
    }

    private static Map<String, Integer> countWithGetOrDefault(String[] words) {
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                counts.put(word, counts.getOrDefault(word, 0) + 1);
            }
        }
        return counts;
    }

    private static Map<String, Integer> countWithMerge(String[] words) {
        Map<String, Integer> counts = new HashMap<>();
        BiFunction<Integer, Integer, Integer> addCounts =
                new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer oldCount, Integer increase) {
                        return oldCount + increase;
                    }
                };

        for (String word : words) {
            if (!word.isEmpty()) {
                counts.merge(word, 1, addCounts);
            }
        }
        return counts;
    }

    private static void printAllCounts(Map<String, Integer> counts) {
        List<String> sortedWords = new ArrayList<>(counts.keySet());
        Collections.sort(sortedWords);
        for (String word : sortedWords) {
            System.out.println(word + ": " + counts.get(word));
        }
    }

    private static void printTopThree(String method, Map<String, Integer> counts) {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(counts.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> first,
                               Map.Entry<String, Integer> second) {
                int countOrder = Integer.compare(second.getValue(), first.getValue());
                if (countOrder != 0) {
                    return countOrder;
                }
                return first.getKey().compareTo(second.getKey());
            }
        });

        System.out.println("Top 3 with " + method + ":");
        for (int i = 0; i < Math.min(3, entries.size()); i++) {
            Map.Entry<String, Integer> entry = entries.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
