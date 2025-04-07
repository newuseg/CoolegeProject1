
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class database {
    Connection connection;
    Statement statement;
    public database() {
        // MySQL database connection details
        String hostname = "localhost";
        String port = "3306";
        String database = "collegeproject";
        String username = "root";
        String password = "Adity@123";
        try {
            // Include username and password in the connection URL
            connection = DriverManager.getConnection("jdbc:mysql://" + hostname + ":" + port + "/" + database, username, password);
            statement = connection.createStatement();
            System.out.println("Data Inserted successfully.");
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
            e.printStackTrace();
        }
    }
    // Optional: Method to close resources
    public void close() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
            System.out.println("Database resources closed.");
        } catch (SQLException e) {
            System.err.println("Error closing database resources: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        database db = new database();
        // Perform your database operations here
        db.close(); // Close the resources when done
    }
}
