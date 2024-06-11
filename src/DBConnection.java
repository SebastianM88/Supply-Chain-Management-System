import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

// Defines a public class called DBConnection.
public class DBConnection {

    // Declares a Connection instance variable called a cone.
    Connection con;

    // Defines a public method called mkDataBase that returns a Connection object and can throw a SQLException exception.
    public Connection mkDataBase() throws SQLException {

        // Start a try block.
        try {

            // Upload and record JDBC driver for MySQL.
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Define the database URL.
            String url = "jdbc:mysql://localhost:3306/supply_chain_management";

            // Define the username for the database.
            String username = "root";

            // Define the password for the database.
            String password = "Management";

            // // Try to establish a connection to the database using the specified URL, username and password.
            con = DriverManager.getConnection(url, username,password);

        // Start a catch block that will run if the try block throws a ClassNotFoundException exception.
        } catch (ClassNotFoundException ex) {

            // Get a logger for the DBConnection class and log the exception to the SEVERE level
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE,null,ex);
        }

        // Returns the connection to the database.
        return con;
    }
}
