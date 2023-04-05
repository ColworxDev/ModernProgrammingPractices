package generics;

import java.util.Arrays;

public class FindOccurences {

    public static void main(String[] args) {
        Student a = new Student("Tom");
        Student[] arr = new Student[] {
                a,
                null,
                new Student("Tom"),
                new Student("Jerry"),
                new Student("Spike")
        };

        System.out.println(countOccurrences(arr, null));
    }

    static class Student {
        String name;


        public Student(String name) {
            this.name = name;
        }
    }

    class Employee {
        String name;

        public Employee(String name) {
            this.name = name;
        }
    }

    public static <T> int countOccurrences(T[] arr, T target) {
        return (int) Arrays.stream(arr)
                .filter(e -> target == null ? e == null : target.equals(e))
                .count();
//        int count = 0;
//        if (target == null) {
//            for (T item : arr) {
//                if (item == null) {
//                    count++;
//                }
//            }
//        } else {
//            for (T item : arr) {
//                if (target.equals(item)) {
//                    count++;
//                }
//            }
//        }
//        return count;
    }

    public static int countOccurrences(String[] arr, String target) {
        int count = 0;
        if (target == null) {
            for (String item : arr) {
                if (item == null) {
                    count++;
                }
            }
        } else {
            for (String item : arr) {
                if (target.equals(item)) {
                    count++;
                }
            }
        }
        return count;
    }
}
