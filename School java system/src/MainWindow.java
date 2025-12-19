import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;

public class MainWindow extends JFrame {
    private JPanel contentPane;

    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MainWindow frame = new MainWindow();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    
    public MainWindow() {
        setTitle("BN University | Welcome");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        
        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(33, 135, 100, 30);
        contentPane.add(btnLogin);

        
        JButton btnCreateAccount = new JButton("Sign Up");
        btnCreateAccount.setBounds(255, 135, 100, 30);
        contentPane.add(btnCreateAccount);

        
        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(155, 201, 70, 30);
        contentPane.add(btnExit);
        
        JLabel lblNewLabel = new JLabel("Biringan National University");
        lblNewLabel.setBounds(87, 52, 245, 42);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\PersonalPC\\Downloads\\Biringan1LOGO.png"));
        lblNewLabel_1.setBounds(-60, 0, 468, 296);
        contentPane.add(lblNewLabel_1);
       
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginWindow().showWindow();
            }
        });

        btnCreateAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CreateWindow(null).showWindow();
            }
        });

        btnExit.addActionListener(e -> System.exit(0));
        
        setResizable(false);

    }
}
