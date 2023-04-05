public class Main7 {

    public static void main(String[] args) {

        System.out.println();

        "Bright_Gee_Varghese"
                .chars()
                .parallel()
                .forEach(data -> System.out.print((char)data));

        System.out.println();

        "Bright_Gee_Varghese"
                .chars()
                .parallel()
                .forEachOrdered(
                        data -> System.out.print((char)data)
                );
    }
}
