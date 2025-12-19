import java.awt.*;
import javax.swing.*;

public class enrollmentDashboard extends JFrame {

    public enrollmentDashboard() {
        setTitle("Enrollment Dashboard");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JLabel lbl = new JLabel("Enrollment Dashboard", SwingConstants.CENTER);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 20));
        add(lbl);
    }
}
