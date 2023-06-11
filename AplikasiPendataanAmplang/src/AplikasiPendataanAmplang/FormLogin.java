package AplikasiPendataanAmplang;

/**
 *
 * @author USERD
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class FormLogin extends javax.swing.JFrame {

    Database db = new Database();

    /**
     * Creates new form FormLogin
     */
    public FormLogin() {
        initComponents();
        db.Koneksi();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldUser = new javax.swing.JTextField();
        jButtonLogin = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jTextFieldPass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Pendataan Amplang");
        setAutoRequestFocus(false);

        jLabel1.setFont(new java.awt.Font("Poor Richard", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Login");

        jLabel2.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Password");

        jButtonLogin.setBackground(new java.awt.Color(0, 102, 102));
        jButtonLogin.setForeground(new java.awt.Color(0, 0, 0));
        jButtonLogin.setText("Login");
        jButtonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonLoginMouseClicked(evt);
            }
        });

        jButtonExit.setBackground(new java.awt.Color(0, 102, 102));
        jButtonExit.setForeground(new java.awt.Color(0, 0, 0));
        jButtonExit.setText("Exit");
        jButtonExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonLogin)
                            .addComponent(jTextFieldUser, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(jButtonExit)
                            .addComponent(jTextFieldPass))))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jButtonLogin)
                .addGap(18, 18, 18)
                .addComponent(jButtonExit)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean verifyLogin(String usernameInput, String passwordInput) {
        try {
            String query = "SELECT * FROM tbAkun WHERE username = ? AND password = ?";
            PreparedStatement ps = db.conn.prepareStatement(query);
            ps.setString(1, usernameInput);
            ps.setString(2, passwordInput);
            db.rs = ps.executeQuery();

            return db.rs.next();
        } catch (SQLException e) {
            System.out.println("Error saat menjalankan query: " + e.getMessage());
            return false;
        }
    }

    private void jButtonLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoginMouseClicked
        String username = jTextFieldUser.getText();
        String password = jTextFieldPass.getText();

        boolean loginSuccess = verifyLogin(username, password);

        if (loginSuccess) {
            JOptionPane.showMessageDialog(this, "Login berhasil!", "Sukses", JOptionPane.INFORMATION_MESSAGE);

            // Menutup jendela login
            dispose();

            MainMenu main = new MainMenu();
            main.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Login gagal. Silakan cek kembali username dan password Anda.", "Gagal", JOptionPane.ERROR_MESSAGE);

            // Menampilkan kembali jendela login
            jTextFieldUser.setText(""); // Mengosongkan field username
            jTextFieldPass.setText(""); // Mengosongkan field password
            setVisible(true);
        }
    }//GEN-LAST:event_jButtonLoginMouseClicked

    private void jButtonExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonExitMouseClicked
        JOptionPane.showMessageDialog(this, "Anda akan keluar dari program!", "Exit", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }//GEN-LAST:event_jButtonExitMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FormLogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jTextFieldPass;
    private javax.swing.JTextField jTextFieldUser;
    // End of variables declaration//GEN-END:variables
}
