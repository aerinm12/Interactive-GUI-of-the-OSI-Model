public class Project2Runner {
/*
    * Name: <Aerin Maredia>
    * Student ID: <501302027>
    * 
    ******** Project Description ********
    * 
    * Describe in plain English the overall program/program in a paragraph or 2.
    * 
    *My program is called "Understand The 7 Levels of The OSI (Open Systems Interconnection) Model". It aims to help
    students who are interested in learning about each layer using a colurful, appealing, interactive GUI. My program
    also provides a brief desctipion of each level and what specifically happens to the data travelling across a netwrok 
    at each stage. I find the communication between networks very fascinating and wanted to apply my knowledge of the
    model towards this project. When you hover over a level button, a bright yellow label will pop up under the title
    indicating the name of that stage. When you click on any of the level buttons, the desciption will show up in the 
    corresponding box in the description area. I designed my program so that clicking another level hides the desciptions
    of all other levels excluding the one clicked. I chose to do this as a way of helping students test themselves of how
    well they can remember each level without having the desciption continuously displayed to them. 
    * 
    ******** Swing Requirement ********
    * 
    * Describe in 1 paragraph how your program satisfies the requirement that
    * there is at least 3 unique components. Be clear to identify in what
    * files and the lines number (just the starting line is fine) that the
    * components are defined on.
    * 
    The 3 unique swing components I used to fufill this requirement are JLabels, JButtons, and JTextAreas. 
    I used the JLabels to make the title and the name of the level (under the title when hovering over a button) appear. 
    This was done in the labelPanel.java file through lines 17-27 and on the descriptionPanel line 29.
    I used the Jbuttons to make the clickable level buttons in the buttonPanel.java in line 63. Since I had to create 
    multiple buttons, i created a helper method that was called in a loop to ensure 7 buttons got created.
    Lastly, I used a JTextArea to create the text for the desctiptions. I had to use JTextArea as opposed to JLabels 
    since JTextLabels allow you to format the text onto multiple lines instead of one big long label. I needed this
    formatting for visual aesthetic and making sure text appeared in the description area boxes. I used JTextArea's 
    in the descriptionPanel.java file in line 35.
    *
    * 
    ******** 2D Graphics Requirement ********
    *
    * Describe in 1 paragraph how your program satisfies the requirement that
    * there is at least 1 JPanel used for drawing something. Be clear to
    * identify in what files and the line numbers that this panel is defined on.
    * 
    * I satisfied this requirement by drawing rectangles in my desciption area. These rectangles are empty to begin with,
    and get filled with text when a button is pressed. I drew rectangles for the area where the text would go, along with
    another rectangle of a different colour right behind it (but positioned with a slighlty different x and y coordinate)
    to give a 3d effect. I also created arrows to the left of the rectangles to indicate that something (text) is to 
    appear in the rectangle following an action (pressing the button). I created triangles using Polygons and rectangles
    simply using regular rectangles. This is done in my descriptionPanel.java file through lines 62-89 by overriding the 
    PaintComponent method that belongs to the Jpanel.
    * 
    ******** Event Listener Requirement ********
    *`
    * Describe in 1 paragraph how your program satisfies the requirement that
    * there is at least one ActionListener, and there is additionally at least
    * one MouseListener or ActionListener. Be clear to identify in what file
    * and the line numbers that these listeners are defined in.

    To satisfy the requirement for one actionlistener adn additionally, one Mouselistener, I have made it possible for my 
    buttons to be pressed to display a description (Actionlistener) and I've created a mouselistener to display the name 
    of the level when the mouse hovers over a level button. The mouselistener is defined on line 73 of the buttonPanel.java 
    file and the actionlistener is defined on line 97 of the same file. I used the mouseEntered method of the mouselistner
    to make sure the level name appeared when the mouse entered the button. I then used my actionlistener to call a method
    that made the desctiption visible in the right box when a particular button was pressed. This method is defined in the
    descriptionPanel and is further explained as comment there. 
    */



    //Main method that creates a myFrame obj
    public static void main(String[] args) {
        new myFrame();

    }
}
