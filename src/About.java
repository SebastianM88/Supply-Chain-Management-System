import javax.swing.*;
import java.awt.*;

// Our class
public class About {

    // Declaring variables
    private JFrame frame;
    private JTextArea textArea;

    // Our builder who will initialize the functionality of the method
    public About() {
        prepareGUI();
    }

    // Method that makes it possible to run the interface
    public static void main(String[] args) {

        About ab = new About();
    }

    //  Method that initializes the graphical interface.
    public void prepareGUI() {

        // Definition of our frame on which all its elements will be located
        frame = new JFrame("About");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        // Defining the area of text that the interface will contain and on which the text will be displayed
        textArea = new JTextArea();
        textArea.setFont(new Font( "Roboto Medium", Font.PLAIN, 17));
        textArea.setMargin(new Insets(40,25,10,10));
        textArea.setText("Order of realization of the project classes: \n" +
                "\n" +
                "- Main Class\n" +
                "- DBConnection class\n" +
                "- Login Page\n" +
                "- Home class\n" +
                "- Supplier \n" +
                "- addProduct class\n" +
                "- About class\n" +
                "- searchProduct class\n" +
                "- purchaseProduct class"
                + "\n");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        frame.add(textArea);
        frame.setVisible(true);
    }
}