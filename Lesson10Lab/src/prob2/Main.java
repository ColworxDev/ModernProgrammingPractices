package prob2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-2, -1, 0, 1, 2);
        Group<Integer> group = new Group<>(0, list);
        System.out.println(group);
        System.out.println(copy(group));
    }

    public static Group<?> copy(Group<?> group) {
        return copyHelper(group);
    }

    private static <T> Group<T> copyHelper(Group<T> group) {
        List<T> elements = group.getElements();
        Group<T> grp = new Group<T>(group.getSpecialElement(), elements);
        return grp;
    }

//    public static Group<?> copy(Group<?> group) {
//		List<?> elements = group.getElements();
//		Group<?> grp = new Group<?>(group.getSpecialElement(), elements);
//		return grp;
//	}

    public static class Group<T> {
        private T specialElement;
        private List<T> elements = new ArrayList<>();

        public Group(T special, List<T> elements) {
            this.specialElement = special;
            this.elements = elements;
        }

        public T getSpecialElement() {
            return specialElement;
        }

        public List<T> getElements() {
            return elements;
        }

        public String toString() {
            return "[specialElement : " + specialElement.toString() +
                    ", elements :\n   " + elements.toString() + "]";
        }
    }
}
