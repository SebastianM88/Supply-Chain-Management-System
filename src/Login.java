import java.awt.*;
import javax.swing.*;

// Defines a public class called Login that expands the JFrame class.
public class Login extends JFrame {

    // Variable statements for the components of the graphical interface.
    JLabel idLabel;
    JLabel passLabel;
    JLabel background;
    JLabel headerLabel;
    JTextField id;
    JPasswordField pass;
    JButton submit;

    // Class builder
    public Login() {

        setTitle("Supply Chain Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Create a new JLabel to initialize an image
        this.background = new JLabel(new ImageIcon("D:\\Downloads\\Natura.png"));

        // Call the init() method to initialize the components of the graphical interface.
        this.init();
        add(background);

        // Set the background to be visible
        background.setVisible(true);

        // Set our frame sizes
        this.pack();
        this.setSize(700, 400);
        this.setLocationRelativeTo(null);

    }

    // Method that initializes the components of the graphical interface.
    public void init() {

        // Defining the title of the label
        headerLabel = new JLabel();
        this.headerLabel.setText("Supply Chain Management System");
        this.headerLabel.setBounds(190, 1, 370, 150);
        this.headerLabel.setFont(new Font("Geomanist", Font.BOLD, 20));
        headerLabel.setForeground(Color.black);
        add(headerLabel);

        // Defining the label that will signal the box where the name will be entered
        idLabel = new JLabel();
        this.idLabel.setText("Username");
        this.idLabel.setBounds(190, 110, 100, 50);
        this.idLabel.setFont(new Font(null, Font.BOLD, 20));
        idLabel.setForeground(Color.black);
        add(idLabel);

        // Defining the tag that will signal the box where the password will be entered
        passLabel = new JLabel("Password");
        this.passLabel.setBounds(190, 165, 100, 50);
        this.passLabel.setFont(new Font(null, Font.BOLD, 20));
        passLabel.setForeground(Color.black);
        add(passLabel);

        // Defining the area that will host the introduction site of ID
        id = new JTextField();
        this.id.setBounds(300, 125, 200, 30);
        this.id.setVisible(true);
        add(id);

        // Defining the area that will host the site by entering the password
        pass = new JPasswordField();
        this.pass.setBounds(300,175,200,30);
        this.add(pass);

        // Defining our Login button
        this.submit = new JButton("Login");
        this.submit.setBounds(400,230,100,25);
        add(submit);

        // Offering the functionality of our button to be clicked
        submit.addActionListener(this::submitActionPerformed);
    }

    /* Code that aims to take the information provided, to verify them,
    and if they are true to complete the act and move on to the next result */
    public void submitActionPerformed(java.awt.event.ActionEvent evt) {

        // Code to compare data entered by pre-established ones in order to be able to run
        if(id.getText().equals("a") && pass.getText().equals("a")) {

            /* Code used as if the login process is completed to automatically
            switch to the next interface and close the previous one */
           this.setVisible(false);
           Home hm = new Home();
           hm.showButtonDemo();

        // Code that in case of misinformation to run a message warning that they are wrong
        } else {

            JOptionPane.showMessageDialog(null, "Invalid Password");
        }
    }
}