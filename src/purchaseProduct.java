import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class purchaseProduct {

    // Declaration of each variable
    private JFrame mainFrame;
    private JLabel statusLabel;
    private JLabel headerLabel;
    private JPanel controlPanel;
    private JLabel id, quantity;
    GridLayout experimentalLayout = new GridLayout(0, 2);
    ResultSet set;

    // The constructor of the Home class.
    purchaseProduct() {

        // Call the prepareGUI() method to initialize the graphical interface.
        prepareGUI();
    }

    // Main method of the program that aims to create a pp object and call the showButtonDemo() method.
    public static void main(String[] args) {

        purchaseProduct pp = new purchaseProduct();
        pp.shoButtonDemo5();
    }

    // Method that initializes the graphical interface.
    private void prepareGUI() {

        // Definition of our frame on which all its elements will be located
       mainFrame = new JFrame("Purchase Product");
       mainFrame.setSize(700, 400);
       mainFrame.setLayout(new GridLayout(3, 1));
       mainFrame.getContentPane().setBackground(Color.BLUE);

       //Code that makes the app close when the user closes the window
       mainFrame.addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent windowEvent) {
               mainFrame.setVisible(false);
           }
       });

       // Create a new JLabel object with the text empty and aligned to the center.
       headerLabel = new JLabel("", JLabel.CENTER);
       statusLabel = new JLabel("", JLabel.CENTER);
       statusLabel.setSize(350, 400);

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
    public void shoButtonDemo5() {

        // Defining the structures of our new ID object
        id = new JLabel("Enter Product Id");
        JTextField tf1 = new JTextField();
        tf1.setSize(100,30);

        // Defining the structures of our new quantity object
        quantity = new JLabel("Enter Quantity");
        JTextField tf2 = new JTextField();
        tf2.setSize(100,30);

        // Create a new JButton object with the text "Place Order".
        JButton okButton = new JButton("Place Order");

        // Adds an ActionListener to the okButton button.
        okButton.addActionListener(new ActionListener() {

            // Method showing the connectivity between database and program
            @Override
            public void actionPerformed(ActionEvent e) {

                PreparedStatement pst;
                DBConnection con = new DBConnection();

                try {

                    // Converting our variables into Integer, so they can be integrated into the database
                    int id = Integer.parseInt(tf1.getText());
                    int quantity = Integer.parseInt(tf2.getText());

                    // Code that aims to take the current quantity and price of the product
                    pst = con.mkDataBase().prepareStatement("SELECT quantity, price FROM product WHERE product_id = ?");
                    pst.setInt(1, id);
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {

                        int currentQuantity = rs.getInt("quantity");
                        int price = rs.getInt("price");

                        // Check if there is enough quantity in stock
                        if (currentQuantity >= quantity) {

                            // Update the quantity of the product
                            pst = con.mkDataBase().prepareStatement("UPDATE product SET quantity = quantity - ? WHERE product_id = ?");
                            pst.setInt(1, quantity);
                            pst.setInt(2, id);
                            pst.execute();

                            // Calculate the total amount
                            int totalAmount = quantity * price;

                            JOptionPane.showMessageDialog(null, "Product Ordered!! Amount: " + totalAmount);

                        } else {

                            JOptionPane.showMessageDialog(null, "Not enough quantity in stock");
                        }
                    } else {

                        JOptionPane.showMessageDialog(null, "Product not found");
                    }

                    mainFrame.dispose();

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });

        // Code needed to connect each element as well as functionality to our program
        JPanel jp = new JPanel();
                jp.add(id);
                jp.add(tf1);
                jp.add(quantity);
                jp.add(tf2);

                jp.setSize(200, 200);
                jp.setLayout(experimentalLayout);
                controlPanel.add(jp);
                jp.add(okButton);

                mainFrame.setVisible(true);
                mainFrame.setLocationRelativeTo(null);
    }
}