/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rahmat Subandi
 */
public class Koneksi {

    /**
     * @param args the command line arguments
     */
    private static Connection MySQLConfig;
    //membuat koneksi
    public static Connection configDB()throws SQLException{
        try{
            //variabel untuk koneksi
            //bukujava adalah nama database saya
            //sedangkan jdbc variabel untuk database mysql
            String url = "jdbc:mysql://localhost:3306/bukujava";
            String user = "root"; //integer database
            String pass = ""; //password dikosongkan karna saya tidak memakai password agarlebih simpel dalam tahap belajar
            //memanggil fungsi .jar yang ada di library
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //mengambil variabel yang ada diatas
            MySQLConfig = DriverManager.getConnection(url, user, pass);
        }catch(SQLException e){
            //pesan ketika koneksi gagal
            System.out.println("Connection to Database Failed" + e.getMessage());
        }
        //agar jalan atau bisa digunakan
        return MySQLConfig;
    }
    
}
