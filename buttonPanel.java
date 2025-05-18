import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;


//Class that holds the 7 buttons for each layer of the model. Also contains the mouseListener and actionListener which update the frame when mouse has entered, exited (Mouselistener) and clicked (actionLiisterner)
public class buttonPanel extends JPanel {
    descriptionPanel descriptions;   
    labelPanel titlePanel;   

    public buttonPanel(descriptionPanel descriptions, labelPanel titlePanel) {
        this.descriptions = descriptions;
        this.titlePanel = titlePanel; //Stores reference to labelPanel


        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); //Setting layout as BoxLayout to allow for stacking buttons on top of each other (Levels)
        setBackground(new Color(19, 18, 46));
        setBorder(new EmptyBorder(10, 60, 10, 10));   //Making the buttons not be against the right edge
        createAll7Buttons();   //Calls method that creates 7 of the level buttons
    }

    //Method that loops through 1-7, the layer names, and 7 different colours to display 7 buttons
    public void createAll7Buttons() {
        Color[] colors = new Color[7];
        colors[0] = new Color(185, 119, 255);
        colors[1] = new Color(255, 158, 119);
        colors[2] = new Color(255, 228, 119);
        colors[3] = new Color(119, 208, 255);
        colors[4] = new Color(119, 129, 255);
        colors[5] = new Color(119, 255, 137);
        colors[6] = new Color(255, 119, 150);

        // [UPDATED] OSI layer names mapping:
        // Level 7 -> Application, Level 6 -> Presentation, etc.
        String[] layerNames = {
            "Physical Layer",
            "Data Link Layer",
            "Network Layer",
            "Transport Layer",
            "Session Layer",
            "Presentation Layer",
            "Application Layer"
        };

        //Basically just maps each layer (i) with a different colour and its cooresponding name and passes it to the createlevelbutton method
        for (int i = 7; i >= 1; i--) {
            createLevelButton("Level " + i, colors[i - 1], i - 1, layerNames[i - 1]);
        }
    }

    //Sets the size, colour, alignment, and other featuers of the buttons
    private void createLevelButton(String text, Color col, int levelIndex, String layerName) {
        JButton level = new JButton(text);

        level.setPreferredSize(new Dimension(250, 70));
        level.setMaximumSize(new Dimension(250, 70));
        level.setAlignmentX(CENTER_ALIGNMENT);
        level.setVisible(true);
        level.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.PINK, Color.YELLOW));
        level.setBackground(col);
        
        //Mouselistener checks if mouse has entered and exited the button
        level.addMouseListener(new MouseListener() {

            @Override       //If mouse exits the button, make sure to update text to empty string
            public void mouseExited(MouseEvent e) {
                titlePanel.updateHoverLabel(" ");
            }
    
            //If mouse enters button make it equal to the layerName passed by the createall7buttons method
            @Override
            public void mouseEntered(MouseEvent e) {
                titlePanel.updateHoverLabel(layerName);
            }
    
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}

        });
        
        //Actionlistener to present the desciption of each layer when button is pressed.
        level.setActionCommand(text);
        level.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Call a method in the descriptionPanel that sets the description according to which button was pressed. (check descriptionPanel for more info)
                descriptions.setDescription(levelIndex);
            }
        });
    
        add(level);
        add(Box.createVerticalStrut(59));    //Creates space between each button so they are not touching
    }
}
