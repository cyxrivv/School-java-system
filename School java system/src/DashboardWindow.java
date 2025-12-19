import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DashboardWindow extends JFrame {

    private JPanel contentPane;
    private JLabel lblWelcome;

    public DashboardWindow() {
        initialize(null);
    }

    public DashboardWindow(String email) {
        initialize(email);
    }

    private void initialize(String email) {
        setTitle("BN University | Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(245, 245, 245));
        setContentPane(contentPane);

        lblWelcome = new JLabel(
            "Welcome to Biringan National University, " 
            + (email != null ? email : "Student") + "!"
        );
        lblWelcome.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblWelcome.setBounds(76, 69, 520, 40);
        contentPane.add(lblWelcome);

        // Enrollment Button
        JButton btnEnroll = new JButton("Enrollment");
        btnEnroll.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnEnroll.setFocusPainted(false);
        btnEnroll.setBounds(209, 128, 150, 40);
        btnEnroll.setBackground(new Color(220, 220, 220));
        btnEnroll.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        contentPane.add(btnEnroll);

        btnEnroll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SavingsWindow save = new SavingsWindow();
                save.setVisible(true);
            }
        });

        // Logout Button
        JButton btnLogout = new JButton("Logout");
        btnLogout.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnLogout.setFocusPainted(false);
        btnLogout.setBounds(209, 189, 150, 40);
        btnLogout.setBackground(new Color(220, 220, 220));
        btnLogout.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        contentPane.add(btnLogout);

        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginWindow().showWindow();
            }
        });
        
        setResizable(false);

    }

    public void showWindow() {
        setVisible(true);
    }
}