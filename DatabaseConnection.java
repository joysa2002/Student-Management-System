import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection connect() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root", "Joysa@2002");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ MySQL JDBC Driver Not Found!");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.out.println("❌ Connection Failed!");
            e.printStackTrace();
            return null;
        }
    }
}
