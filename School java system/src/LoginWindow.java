import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginWindow {

    private JFrame frame;
    private JTextField txtEmail;
    private JPasswordField txtPassword;

    public LoginWindow() {
        initialize();
    }

    public void showWindow() {
        frame.setVisible(true);
    }

    private void initialize() {
        frame = new JFrame("BN University | Login");
        frame.setBounds(100, 100, 420, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JLabel lblTitle = new JLabel("Account Login");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitle.setBounds(130, 20, 200, 30);
        frame.getContentPane().add(lblTitle);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(60, 80, 100, 25);
        frame.getContentPane().add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(160, 80, 180, 25);
        frame.getContentPane().add(txtEmail);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(60, 120, 100, 25);
        frame.getContentPane().add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(160, 120, 180, 25);
        frame.getContentPane().add(txtPassword);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(160, 160, 180, 30);
        frame.getContentPane().add(btnLogin);

        JLabel lblCreate = new JLabel("<HTML><U>Create Account</U></HTML>");
        lblCreate.setForeground(Color.BLUE.darker());
        lblCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblCreate.setBounds(180, 210, 150, 25);
        frame.getContentPane().add(lblCreate);

        btnLogin.addActionListener(e -> login());
        lblCreate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openCreateAccount();
            }
        });
    }

    private void login() {
        String email = txtEmail.getText().trim();
        String password = new String(txtPassword.getPassword());

        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill in email and password.");
            return;
        }

        String foundEmail = Queries.checkLogin(email, password);

        if (foundEmail != null) {
            JOptionPane.showMessageDialog(frame, "Welcome, " + foundEmail + "!");
            frame.dispose();
            new DashboardWindow(foundEmail).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid email or password!");
        }
    }

    private void openCreateAccount() {
        frame.setVisible(false);                 // hide login
        CreateWindow createAcc = new CreateWindow(this);
        createAcc.showWindow();                  // show signup
    }

    public void showAgain() {
        frame.setVisible(true);                  // restore login
    }
}
