import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Supplier {

    // Declaration of each variable
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JLabel id, name, email, password;
    private static int count = 0;

    GridLayout experimentalLayout = new GridLayout(0, 2);
    ResultSet rs;

    // The constructor of the Home class.
    public Supplier() {

        // Call the prepareGUI() method to initialize the graphical interface.
        prepareGUI();
    }

    // Main method of the program that aims to create a sa object and call the showButtonDemo() method.
    public static void main(String[] args) {

        Supplier sa = new Supplier();
        sa.showButtonDemo1();
    }

    // Method that initializes the graphical interface.
    private void prepareGUI() {

        // Definition of our frame on which all its elements will be located
        mainFrame = new JFrame("Create Supplier Account");
        mainFrame.setSize(400,450);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.getContentPane().setBackground(Color.blue);

        // Code that makes the app close when the user closes the window
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                mainFrame.setVisible(true);
            }
        });

        // Create a new JLabel object with the text empty and aligned to the center.
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350,400);

        // Set the panel layout
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        // The code to add each element on our Frame and make it visible
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(false);
    }

    // Method that adds buttons to the graphical interface.
    public void showButtonDemo1() {

        // Defining header
        headerLabel.setText("Supply Chain Management System");
        headerLabel.setFont(new Font(null, Font.BOLD, 27));
        headerLabel.setForeground(Color.black);

        // Defining the structures of our new ID object
        id = new JLabel("Enter your Id");
        JTextField tf1 = new JTextField();
        tf1.setSize(100,30);

        // Defining the structures of our new name object
        name = new JLabel("Enter Supplier Name");
        JTextField tf2 = new JTextField();
        tf2.setSize(100,30);

        // Defining the structures of our new email object
        email = new JLabel("Enter Email Id");
        JTextField tf3 = new JTextField();
        tf3.setSize(100,30);

        // Defining the structures of our new password object
        password = new JLabel("Enter Your Password");
        JTextField tf4 = new JTextField();
        tf4.setSize(100, 30);

        // Create a new JButton object with the text "Create".
        JButton startButton = new JButton("Create");

        // Adds an ActionListener to the okButton button.
        startButton.addActionListener(new ActionListener() {

            // Method showing the connectivity between database and program
            @Override
            public void actionPerformed(ActionEvent e) {

                PreparedStatement pst;
                DBConnection con = new DBConnection();

                try {

                    // Code to enter new data inside the database
                    pst = con.mkDataBase().prepareStatement("INSERT INTO supplier " +
                            "(id, supplier_name, email, password) VALUES (?, ?, ?, ?)");
                    pst.setInt(1, Integer.parseInt(tf1.getText()));
                    pst.setString(2, tf2.getText());
                    pst.setString(3, tf3.getText());
                    pst.setDouble(4, Double.parseDouble(tf4.getText()));
                    pst.execute();

                    // Message to complete the process
                    JOptionPane.showMessageDialog(null, "Supplier Account Created! " + " Welcome " + tf2.getText());

                    mainFrame.dispose();

                } catch (Exception ex) {

                    System.out.println(ex);
                    JOptionPane.showMessageDialog(null, "Error");

                } finally {

                }
            }
        });

        // Code needed to connect each element as well as functionality to our program
        JPanel jp = new JPanel();
        jp.add(id);
        jp.add(tf1);
        jp.add(name);
        jp.add(tf2);
        jp.add(email);
        jp.add(tf3);
        jp.add(password);
        jp.add(tf4);

        jp.setSize(200,200);
        jp.setLayout(experimentalLayout);

        controlPanel.add(jp);
        jp.add(startButton);

        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);
    }
}