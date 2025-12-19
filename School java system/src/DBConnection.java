
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    
    private static final String URL = "jdbc:mysql://localhost:3306/biringan_data";
    private static final String USER = "root";
    private static final String PASSWORD = "DOWNTOWN08@ced";

    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(" Database connected successfully!");
        } catch (Exception e) {
            System.out.println(" Connection failed: " + e.getMessage());
        }
        return conn;
    }
}
