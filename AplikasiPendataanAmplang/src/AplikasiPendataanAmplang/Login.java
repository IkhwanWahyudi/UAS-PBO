package AplikasiPendataanAmplang;

public class Login {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            FormLogin loginForm = new FormLogin();
            loginForm.setVisible(true);
        });
    }
}