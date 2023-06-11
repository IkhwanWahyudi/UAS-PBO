package AplikasiAmplang;

import java.awt.HeadlessException;
import java.sql.*;

public class Database {
    public Connection conn;
    public Statement st;
    public ResultSet rs;
    
    public void Koneksi() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbamplang", "root", "");
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println("Koneksi Gagal! " + e.getMessage());
        }
    }
}
