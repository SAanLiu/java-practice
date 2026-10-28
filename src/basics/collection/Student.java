package basics.collection;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Student {
    private final int id;
    private final String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Student)) {
            return false;
        }
        Student student = (Student) other;
        return id == student.id && Objects.equals(name, student.name);
    }

    public static void main(String[] args) {
        Student first = new Student(1, "Tom");
        Student second = new Student(1, "Tom");
        Set<Student> students = new HashSet<>();
        students.add(first);
        students.add(second);

        System.out.println("First hashCode: " + first.hashCode());
        System.out.println("Second hashCode: " + second.hashCode());
        System.out.println("First equals second: " + first.equals(second));
        System.out.println("Set size: " + students.size());
        System.out.println("Contains new Student: " + students.contains(new Student(1, "Tom")));
    }
}
