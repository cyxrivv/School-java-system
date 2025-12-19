import java.sql.*;

public class Queries {

   
    public static String checkLogin(String email, String password) {
        Connection conn = DBConnection.getConnection();
        if (conn == null) return null;

        try {
            String sql = "SELECT username FROM acc_info WHERE email = ? AND password_uni = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            String foundUsername = null;
            if (rs.next()) {
                foundUsername = rs.getString("username");
            }

            rs.close();
            ps.close();
            conn.close();

            return foundUsername;

        } catch (SQLException e) {
            System.out.println("Login Query Error: " + e.getMessage());
            return null;
        }
    }

    
    public static boolean emailExist(String email, String username) {
        Connection conn = DBConnection.getConnection();
        if (conn == null) return true;

        try {
            String sql = "SELECT * FROM acc_info WHERE email = ? OR username = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, username);

            ResultSet rs = ps.executeQuery();

            boolean exists = rs.next();

            rs.close();
            ps.close();
            conn.close();

            return exists;

        } catch (SQLException e) {
            System.out.println("emailExist Error: " + e.getMessage());
            return true;
        }
    }

    
    public static boolean createAccount(String username, String email, String password) {
        Connection conn = DBConnection.getConnection();
        if (conn == null) return false;

        try {
            String sql = "INSERT INTO acc_info (username, email, password_uni) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);

            int rows = ps.executeUpdate();

            ps.close();
            conn.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("createAccount Error: " + e.getMessage());
            return false;
        }
    }
}