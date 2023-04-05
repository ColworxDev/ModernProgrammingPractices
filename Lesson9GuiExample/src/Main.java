import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        JFrame frame = new JFrame("My window");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 350);

        frame.setLayout(new FlowLayout());


        //create a list of labels for jbutton
        List<String> labels = Arrays.asList("Yes", "No", "May be");
        labels.stream().map(JButton::new)
                //.forEach(btn->frame.add(btn));
                        .forEach(frame::add);
                //.map(btn -> frame.add(btn));
        frame.setVisible(true);


    }
}