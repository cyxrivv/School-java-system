import java.util.Properties;
import java.util.Random;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class SendOTP {

    private static String lastOTP = null;

    // 👇 Generate a 6-digit OTP
    public static String generateOTP() {
        Random rand = new Random();
        int otp = 100000 + rand.nextInt(900000);
        return String.valueOf(otp);
    }

    // 👇 Send the OTP email using your original Gmail SMTP code
    public static boolean sendOTP(String recepientEmail) {
        String otp = generateOTP();
        lastOTP = otp;

        System.out.println("Generated OTP: " + otp);

        String subject = "Your Verification Code";
        String message = "Your OTP code is: " + otp
                + "\n\nEnter this code in the application to verify your email.";

        return sendMail(recepientEmail, subject, message);
    }

    
    public static boolean sendMail(String recepient, String subject, String messageText) {
        System.out.println("Preparing to send email...");

        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        
        final String myAccountEmail = "biringannationaluniversity@gmail.com";
        final String password = "xfmf amth vdni azma";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(subject);
            message.setText(messageText);

            Transport.send(message);
            System.out.println("Message sent successfully!");
            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 👇 CreateWindow will use this to check if OTP is correct
    public static boolean verifyOTP(String input) {
        return input != null && input.equals(lastOTP);
    }

    public static String getLastOTP() {
        return lastOTP;
    }
}
