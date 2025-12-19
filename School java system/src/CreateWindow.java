import javax.swing.*;
import java.awt.*;

public class CreateWindow extends JFrame {

    private JTextField txtUsername;
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JTextField txtOTP;

    private JButton btnSendOTP;
    private JButton btnVerifyOTP;

    private LoginWindow loginWindow;

    public CreateWindow(LoginWindow loginWindow) {
        this.loginWindow = loginWindow;
        initialize();
    }

    private void initialize() {
        setTitle("BN University | Sign Up");
        setSize(400, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        setResizable(false);

        JLabel lblTitle = new JLabel("Create New Account");
        lblTitle.setBounds(100, 20, 200, 30);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
        getContentPane().add(lblTitle);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(36, 70, 100, 25);
        getContentPane().add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(110, 70, 160, 25);
        getContentPane().add(txtUsername);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(36, 110, 100, 25);
        getContentPane().add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(110, 110, 160, 25);
        getContentPane().add(txtEmail);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(36, 146, 100, 25);
        getContentPane().add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(110, 146, 160, 25);
        getContentPane().add(txtPassword);

        JLabel lblOTP = new JLabel("Enter OTP:");
        lblOTP.setBounds(36, 182, 100, 25);
        lblOTP.setVisible(false);
        getContentPane().add(lblOTP);

        txtOTP = new JTextField();
        txtOTP.setBounds(110, 182, 79, 25);
        txtOTP.setVisible(false);
        getContentPane().add(txtOTP);

        btnSendOTP = new JButton("OTP");
        btnSendOTP.setBounds(191, 182, 79, 25);
        getContentPane().add(btnSendOTP);

        btnVerifyOTP = new JButton("Verify OTP");
        btnVerifyOTP.setBounds(110, 215, 120, 25);
        btnVerifyOTP.setVisible(false);
        getContentPane().add(btnVerifyOTP);

        btnSendOTP.addActionListener(e -> sendOTP(lblOTP));
        btnVerifyOTP.addActionListener(e -> verifyAndCreateAccount());
    }

    private void sendOTP(JLabel lblOTP) {
        String email = txtEmail.getText().trim();

        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an email first!");
            return;
        }

        if (SendOTP.sendOTP(email)) {
            JOptionPane.showMessageDialog(this, "OTP sent to email!");
            lblOTP.setVisible(true);
            txtOTP.setVisible(true);
            btnVerifyOTP.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Failed to send OTP!");
        }
    }

    // 🔥 VERIFY → CREATE → RETURN TO LOGIN
    private void verifyAndCreateAccount() {
        String enteredOTP = txtOTP.getText().trim();

        if (!SendOTP.verifyOTP(enteredOTP)) {
            JOptionPane.showMessageDialog(this, "Incorrect OTP!");
            return;
        }

        String username = txtUsername.getText().trim();
        String email = txtEmail.getText().trim();
        String password = new String(txtPassword.getPassword());

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!");
            return;
        }

        if (Queries.emailExist(email, username)) {
            JOptionPane.showMessageDialog(this, "Email or Username already registered!");
            return;
        }

        if (Queries.createAccount(username, email, password)) {
            JOptionPane.showMessageDialog(this, "Account created successfully!");
            loginWindow.showAgain();   // RETURN TO LOGIN
            dispose();                // CLOSE SIGNUP
        } else {
            JOptionPane.showMessageDialog(this, "Failed to create account!");
        }
    }

    public void showWindow() {
        setVisible(true);
    }
}
