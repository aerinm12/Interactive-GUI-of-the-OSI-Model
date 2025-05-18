import javax.swing.*;
import java.awt.*;

//Class that creates a JFrame and sets size, colour, layout, etc.
public class myFrame extends JFrame {
    descriptionPanel descriptions;
    labelPanel names;

    //Constructor
    public myFrame() {
        super("Understanding the 7 Levels of the OSI Model");
        setSize(1300, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Setting colour and Layout to border layout
        getContentPane().setBackground(new Color(19, 18, 46));
        setLayout(new BorderLayout());     //Border Layout makes positioning easier (north, east, west, south)

        //Creates and adds the labelPanel (with title and hover label)
        names = new labelPanel();
        add(names, BorderLayout.NORTH);

        //Creates and adds the descriptionPanel
        descriptions = new descriptionPanel();
        add(descriptions, BorderLayout.CENTER);

        //Creates and adds the buttonPanel, passing the same labelPanel (names)
        buttonPanel buttons = new buttonPanel(descriptions, names);
        add(buttons, BorderLayout.WEST);

        setVisible(true);
    }
}
