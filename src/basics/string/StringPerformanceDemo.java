package basics.string;

public class StringPerformanceDemo {
    public static void main(String[] args) {
        int count = 100_000;

        long start = System.nanoTime();

        String text = "";
        for (int i = 0; i < count; i++) {
            text = text + "a";
        }

        long plusTime = System.nanoTime() - start;

        start = System.nanoTime();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append("a");
        }
        String result = builder.toString();

        long builderTime = System.nanoTime() - start;

        System.out.println("Concatenation result length: " + text.length());
        System.out.println("StringBuilder result length: " + result.length());
        System.out.println("Results are equal: " + text.equals(result));

        System.out.printf("Concatenation time: %.3f ms%n",
                plusTime / 1_000_000.0);
        System.out.printf("StringBuilder time: %.3f ms%n",
                builderTime / 1_000_000.0);

        double ratio = (double) plusTime / builderTime;
        System.out.printf("Concatenation/StringBuilder time ratio: %.2f%n",
                ratio);
    }
}