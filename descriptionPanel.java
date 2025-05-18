import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//This class holds the descriptions for each layer, the method used to set the desciption, and using a JPanel to draw rectangles and arrows on the JFrame
class descriptionPanel extends JPanel {
    private final JLabel descriptionLabel;
    private final JTextArea descriptionText;
    private final String[] descriptions = {
        "Physical Layer:  This layer is responsible for transmitting raw binary data over a physical medium, such as cables, radio waves, \nor fiber optics. It defines hardware components like cables, switches, and signal modulation.",
        "Data Link Layer:  Ensures reliable data transfer between directly connected nodes by handling MAC (Media Access Control) addressing, \nerror detection, and frame synchronization. It consists of two sublayers: LLC (Logical Link Control) and MAC.",
        "Network Layer: Determines the best path for data to travel between different networks using logical addressing (such as IP addresses).\nIt handles packet forwarding, routing, and congestion control.",
        "Transport Layer: Manages end-to-end communication between devices, ensuring reliable or fast data delivery through protocols like TCP \n(which guarantees delivery) and UDP (which is faster but less reliable).",
        "Session Layer: Establishes, manages, and terminates communication sessions between applications. It ensures data exchange continuity,\nincluding authentication and session recovery in case of interruptions.",
        "Presentation Layer: Translates data between application formats, ensuring compatibility between different systems. It handles \nencryption, compression, and character encoding (e.g., converting text into ASCII or Unicode).",
        "Application Layer: The closest layer to the end-user, it provides network services like email, web browsing, and file transfers. \nProtocols like HTTP, FTP, and SMTP operate at this layer to facilitate communication."
    };

    //Constructor sets background, layout and initializes the colours and bounds of the descriptions and the name (descriptionText) of the layer (descriptionLabel)
    public descriptionPanel() {
        setBackground(new Color(34, 32, 52));
        setLayout(null); 

        descriptionLabel = new JLabel("Select a level to see its description.");
        descriptionLabel.setForeground(Color.WHITE);
        descriptionLabel.setBackground(Color.BLACK);
        descriptionLabel.setBounds(130, 0, 680, 60);
        add(descriptionLabel);

        descriptionText = new JTextArea();            //JTextArea used so the desciptions could be printed on multiple lines and not just one big line 
        descriptionText.setForeground(Color.WHITE);
        descriptionText.setBackground(new Color(88, 84, 119));
        descriptionText.setEditable(false);
        descriptionText.setLineWrap(true);
        descriptionText.setWrapStyleWord(true);
        descriptionText.setVisible(false);      //Hide initially
        add(descriptionText);
    }

    //Method that sets the text of descriptionText to the right layer description (called in the buttonPanel)
    public void setDescription(int level) {
        if (level >= 0 && level < 7) {
            descriptionText.setText(descriptions[level]);
            descriptionText.setVisible(true);

            //Updates the position of the descipriton to make sure it appears in the right corresponding rectangle 
            int y = 40 +(80 * (6 - level)); //changing just y position
            descriptionText.setBounds(120, y + 5, 680, 60); //Adjustment 
        } else {
            descriptionText.setVisible(false);
        }
        repaint();
    }

    //JPanel used to draw the 7 rectangles with 7 more behind each one for a pop up effect
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 110;
        int y = 40;

        Graphics2D g2D = (Graphics2D) g;

        //Creating 3 coordinates (xPoints and yPoints) for the triangle part of the arrow and indicating it has 3 points (nPoints)
        int[] xPoints = {x - 25, x - 25, x - 10};           
        int[] yPoints = {y - 10, y + 30, y + 10};
        int nPoints = 3;             

        for (int i = 7; i >= 1; i--) {                      //Loop to draw 7
            g2D.setColor(Color.YELLOW);                     //Rectangles that go behind 
            g2D.fillRect(x + 1, y + 1, 700, 70);

            g2D.setColor(new Color(88, 84, 119));
            g2D.fill3DRect(x, y, 700, 70, true);       //Rectangles that go in front 

            //Drawing arrows to indicate there will be text displayed in the rectangles
            g2D.drawRect(x - 50, y + 5, 25, 13);
            g2D.drawPolygon(new Polygon(xPoints, yPoints, nPoints));      

            //Incrementing y's to make sure rectangles are drawn under each other 80 units lower each time
            y += 80;
            yPoints[0] += 80;
            yPoints[1] += 80;
            yPoints[2] += 80;
        }
    }
}

    
