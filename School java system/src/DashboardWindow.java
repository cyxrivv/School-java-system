import java.awt.*;
import javax.swing.*;

public class DashboardWindow extends JFrame {

    private JPanel contentPane;
    private JLabel lblWelcome;
    private String userEmail;

    public DashboardWindow() {
        this(null);
    }

    public DashboardWindow(String email) {
        this.userEmail = email;
        initialize();
    }

    private void initialize() {
        setTitle("BN University | Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(245, 245, 245));
        setContentPane(contentPane);

        lblWelcome = new JLabel(
            "Welcome to Biringan National University, "
            + (userEmail != null ? userEmail : "Student") + "!"
        );
        lblWelcome.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblWelcome.setBounds(50, 60, 520, 40);
        contentPane.add(lblWelcome);

        JButton btnEnroll = new JButton("Enrollment");
        btnEnroll.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnEnroll.setBounds(225, 130, 150, 40);
        contentPane.add(btnEnroll);

        btnEnroll.addActionListener(e -> openEnrollment());

        JButton btnLogout = new JButton("Logout");
        btnLogout.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnLogout.setBounds(225, 190, 150, 40);
        contentPane.add(btnLogout);

        btnLogout.addActionListener(e -> logout());
    }

    private void openEnrollment() {
        SwingUtilities.invokeLater(() -> {
            try {
                enrollmentDashboard enrollment = new enrollmentDashboard();
                enrollment.setVisible(true);
                dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(
                    this,
                    "Enrollment window failed to open.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        });
    }

    private void logout() {
        SwingUtilities.invokeLater(() -> {
            dispose();
            LoginWindow login = new LoginWindow();
            login.showWindow();
        });
    }

    public void showWindow() {
        setVisible(true);
    }
}
