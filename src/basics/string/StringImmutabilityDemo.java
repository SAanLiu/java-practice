package basics.string;

public class StringImmutabilityDemo {
    public static void main(String[] args) {
        String s = "abc";

        s.toUpperCase();
        System.out.println(s); // abc

        String upper = s.toUpperCase();
        System.out.println(upper); // ABC
        System.out.println(s);     // abc

        String original = s;
        s = s + "d";

        System.out.println(s);          // abcd
        System.out.println(original);   // abc
        System.out.println(s == original); // false
    }
}