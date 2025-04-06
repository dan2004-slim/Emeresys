package loginandsignup;

import javax.swing.SwingUtilities;

public class LoginAndSignUp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HOMEPAGE homepageFrame = new HOMEPAGE();
            homepageFrame.setVisible(true);
            homepageFrame.pack();
            homepageFrame.setLocationRelativeTo(null); // Center window
        });
    }
}
