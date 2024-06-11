import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// Our Class
public class addProduct {

    // Declaration of each variable
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel controlPanel;
    private JLabel id, name, quantity, price;
    private static int count = 0;
    GridLayout experimentalLayout = new GridLayout(0, 2);
    ResultSet rs;

    // The constructor of the Home class.
    addProduct() {

        // Call the prepareGUI() method to initialize the graphical interface.
        prepareGui();
    }

    // Main method of the program that aims to create a p object and call the showButtonDemo() method.
    public static void main(String[] args) {
        addProduct p = new addProduct();
        p.showButtonDemo2();
    }

    // Method that initializes the graphical interface.
    public void prepareGui() {

        // Definition of our frame on which all its elements will be located
        mainFrame = new JFrame("Add Product Details");
        mainFrame.setSize(700, 500);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.getContentPane().setBackground(Color.blue);

        // Code that makes the app close when the user closes the window
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                mainFrame.setVisible(false);
            }
        });

        // Create a new JLabel object with the text empty and aligned to the center.
        headerLabel = new JLabel("", JLabel.CENTER);

        // Set the panel layout
        controlPanel = new JLabel("", JLabel.CENTER);
        controlPanel.setLayout(new FlowLayout());

        // The code to add each element on our Frame and make it visible
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.setVisible(true);
    }

    // Method that adds buttons to the graphical interface.
    public void showButtonDemo2() {

        // Defining header
        headerLabel = new JLabel("Supply Chain Management System");
        headerLabel.setFont(new Font(null, Font.BOLD,27));

        // Defining the structures of our new ID object
        id = new JLabel("Enter Product Id");
        JTextField tf1 = new JTextField();
        tf1.setSize(100,40);

        // Defining the structures of our new name object
        name = new JLabel("Enter Product Name");
        JTextField tf2 = new JTextField();
        tf2.setSize(100, 40);

        // Defining the structures of our new quantity object
        quantity = new JLabel("Enter Quantity");
        JTextField tf3 = new JTextField();
        tf3.setSize(100,40);

        // Defining the structures of our new price object
        price = new JLabel("Enter The Price");
        JTextField tf4 = new JTextField();
        tf4.setSize(100,40);

        // Create a new JButton object with the text "Add".
        JButton okButton = new JButton("Add");

        // Adds an ActionListener to the okButton button.
        okButton.addActionListener(new ActionListener() {

            // Method showing the connectivity between database and program
            @Override
            public void actionPerformed(ActionEvent e) {

                PreparedStatement pst;
                DBConnection con = new DBConnection();

                try {

                    // Prepare a SQL query to insert a product into the database.
                    pst = con.mkDataBase().prepareStatement("INSERT INTO product" +
                            "(product_id, product_name, quantity, price) VALUES (?, ?, ?, ?)");

                    // Process of linking the established program data to be integrated into the database
                    pst.setString(1, tf1.getText());
                    pst.setString(2, tf2.getText());
                    pst.setInt(3, Integer.parseInt(tf3.getText()));
                    pst.setDouble(4, Double.parseDouble(tf4.getText()));

                    // Execute SQL queries.
                    pst.execute();

                    // Displays a dialog message that informs the user that the product has been added.
                    JOptionPane.showMessageDialog(null,
                            "Product Added! " + tf2.getText());

                    // Close the mainFrame window.
                    mainFrame.dispose();

                } catch (Exception ex) {

                    // Displays a dialog message that informs the user that an error has occurred.
                    JOptionPane.showMessageDialog(null, "Error");

                }
            }
        });

        // Code needed to connect each element as well as functionality to our program
        JPanel jp2 = new JPanel(null);
        jp2.add(id);
        jp2.add(tf1);
        jp2.add(name);
        jp2.add(tf2);
        jp2.add(quantity);
        jp2.add(tf3);
        jp2.add(price);
        jp2.add(tf4);

        jp2.setSize(450,500);
        jp2.setLayout(experimentalLayout);
        controlPanel.add(jp2);
        jp2.add(okButton);

        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
}
