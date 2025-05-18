import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

//Class that holds the labels for title and the layer names. Also consists of the method that is called by the mouselistener to make sure session names appear at the right time.
public class labelPanel extends JPanel {
    private JLabel hoverLabel; 

    public labelPanel() {

        setBackground(new Color(19, 18, 46)); //Same colour as Jframe
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        //Title label
        JLabel title = new JLabel("Understanding the 7 Levels of the OSI Model");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Broadway", Font.PLAIN, 50));
        title.setAlignmentX(CENTER_ALIGNMENT);  //Centering it
        add(title);
        
        //HoverLabel is the label that displays the layer name under the title
        hoverLabel = new JLabel(" ");  //currently empty so nothing appears when mouseEntered isnt called
        hoverLabel.setForeground(Color.YELLOW);
        hoverLabel.setAlignmentX(CENTER_ALIGNMENT);
        add(hoverLabel);
    }
    
    //Method that updates the text based on the layerNames in the buttonPanel
    public void updateHoverLabel(String text) {
        hoverLabel.setText(text); 
    }
}

