import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Home {


    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    // The constructor of the Home class.
    public Home() {

        // Call the prepareGUI() method to initialize the graphical interface.
        prepareGUI();
    }

    // Main method of the program that aims to create a Home object and call the showButtonDemo() method.
    public static void main(String[] args) {
        Home hm = new Home();
        hm.showButtonDemo();
    }

    // Method that initializes the graphical interface.
    private void prepareGUI() {

        // Definition of our frame on which all its elements will be located
        mainFrame = new JFrame("Supply Chain Management System");
        mainFrame.setBounds(100, 100, 700,400);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.getContentPane().setBackground(Color.white);

        // Code that makes the app close when the user closes the window
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {

                System.exit(0);
            }
        });

        // Create a new JLabel object with the text empty and aligned to the center.
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 300);

        // Set the panel layout as a GridLayout with a row and 5 columns.
        controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1, 5));

        // The code to add each element on our Frame and make it visible
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    // Method that adds buttons to the graphical interface.
    public void showButtonDemo() {

        // Defining the title of our label
        headerLabel.setText("Supply Chain Management System");
        this.headerLabel.setFont(new Font(null, Font.BOLD, 27));
        headerLabel.setForeground(Color.black);

        // It will create a new button with the name of each one
        JButton saButton = new JButton("Supplier Account");
        JButton pButton = new JButton("Product");
        JButton abButton = new JButton("About");
        JButton pdButton = new JButton("Product Details ");
        JButton ppButton = new JButton("Purchase Product");

        /* We will add an actionListener event for each button as
         when it is accessed to run the code specific to each one. */

        saButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Supplier sa = new Supplier();
                sa.showButtonDemo1();
            }
        });

        pButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProduct p = new addProduct();
                p.showButtonDemo2();
            }
        });

        abButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                About ab = new About();
            }
        });

        pdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchProduct pb = new searchProduct();
                pb.showButtonDemo4();
            }
        });

        ppButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                purchaseProduct pp = new purchaseProduct();
                pp.shoButtonDemo5();
            }
        });

        // Code required to add each button within the structure of our panel
        controlPanel.add(saButton);
        controlPanel.add(pButton);
        controlPanel.add(abButton);
        controlPanel.add(pdButton);
        controlPanel.add(ppButton);
        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);
    }
}
