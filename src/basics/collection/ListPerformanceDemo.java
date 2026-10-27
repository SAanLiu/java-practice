package basics.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceDemo {
    private static final int COUNT = 100_000;

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        long start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            arrayList.add(0, i);
        }
        long arrayInsertTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            linkedList.add(0, i);
        }
        long linkedInsertTime = System.nanoTime() - start;

        long arrayChecksum = 0;
        start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            arrayChecksum += arrayList.get(i);
        }
        long arrayReadTime = System.nanoTime() - start;

        long linkedChecksum = 0;
        start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            linkedChecksum += linkedList.get(i);
        }
        long linkedReadTime = System.nanoTime() - start;

        System.out.printf("ArrayList head insertion: %.3f ms%n", arrayInsertTime / 1_000_000.0);
        System.out.printf("LinkedList head insertion: %.3f ms%n", linkedInsertTime / 1_000_000.0);
        System.out.printf("ArrayList indexed reads: %.3f ms%n", arrayReadTime / 1_000_000.0);
        System.out.printf("LinkedList indexed reads: %.3f ms%n", linkedReadTime / 1_000_000.0);
        System.out.println("ArrayList checksum: " + arrayChecksum);
        System.out.println("LinkedList checksum: " + linkedChecksum);
    }
}
