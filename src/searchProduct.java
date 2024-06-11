import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class searchProduct {

    // Declaration of each variable
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JLabel id;
    GridLayout experimentalLayout = new GridLayout(0,2);
    ResultSet rs;

    // The constructor of the Home class.
    searchProduct() {

        // Call the prepareGUI() method to initialize the graphical interface.
        prepareGUI();
    }

    // Main method of the program that aims to create a pb object and call the showButtonDemo() method.
    public static void main(String[] args) {
        searchProduct pb = new searchProduct();
        pb.showButtonDemo4();
    }

    // Method that initializes the graphical interface.
    private void prepareGUI(){

        // Definition of our frame on which all its elements will be located
        mainFrame = new JFrame("Search Product");
        mainFrame.setSize(700,400);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.getContentPane().setBackground(Color.green);

        // Code that makes the app close when the user closes the window
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                mainFrame.setVisible(false);
            }
        });

        // Create a new JLabel object with the text empty and aligned to the center.
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("",JLabel.CENTER);
        statusLabel.setSize(350,400);

        // Set the panel layout
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        // The code to add each element on our Frame and make it visible
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    // Method that adds buttons to the graphical interface.
    public void showButtonDemo4() {

        // Defining header
        headerLabel.setText("Supply Chain Management System");
        headerLabel.setFont(new Font(null, Font.BOLD, 27));
        headerLabel.setForeground(Color.black);

        // Defining the structures of our new ID object
        id = new JLabel("Enter Product Id");
        JTextField tf1 = new JTextField();
        tf1.setSize(100, 30);

        // Create a new JButton object with the text "Search Product".
        JButton okButton = new JButton("Search Product");

        // Adds an ActionListener to the okButton button.
        okButton.addActionListener(new ActionListener() {

            // Method showing the connectivity between database and program
            @Override
            public void actionPerformed(ActionEvent e) {

                PreparedStatement pst;
                DBConnection con = new DBConnection();

                try {

                    // Code block to read the existing data in the database
                    pst = con.mkDataBase().prepareStatement("SELECT quantity, price FROM product WHERE product_id = ?");
                    pst.setInt(1, Integer.parseInt(tf1.getText()));
                    pst.execute();

                    ResultSet rs = pst.executeQuery();

                    // Code for reading the results from the database
                    if (rs.next()) {

                        int quantity = rs.getInt("quantity");
                        double price = rs.getDouble("price");

                        JOptionPane.showMessageDialog(null,
                                "Product Details Available Quantity: " + quantity + " Price: " + price);

                    } else {

                        // Message in case of entering incorrect data
                        JOptionPane.showMessageDialog(null, "No product found with the given id: " + tf1.getText());
                    }

                    mainFrame.dispose();

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });

        // Code needed to connect each element as well as functionality to our program
        JPanel jp3 = new JPanel();
        jp3.add(id);
        jp3.add(tf1);

        jp3.setSize(200, 200);
        jp3.setLayout(experimentalLayout);
        controlPanel.add(jp3);
        jp3.add(okButton);

        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);
    }
}
