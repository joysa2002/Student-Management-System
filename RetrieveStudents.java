import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class RetrieveStudents {
    public static void main(String[] args) {
        try {
            Connection conn = DatabaseConnection.connect();
            if (conn != null) {
                String sql = "SELECT * FROM students";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                System.out.println("📌 Student Records:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
                }
                rs.close();
                stmt.close();
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
