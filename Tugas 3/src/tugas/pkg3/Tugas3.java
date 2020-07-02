/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.pkg3;

import javax.swing.JOptionPane;

/**
 *
 * @author Rahmat Subandi
 */
public class Tugas3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String peminjam, buku, pegawai;
        int pengembalian;
        
        peminjam = JOptionPane.showInputDialog("Nama Peminjam: ");
        buku = JOptionPane.showInputDialog("Judul Buku: ");
        pegawai = JOptionPane.showInputDialog("Nama Pegawai: ");
        
        String tanggal_pinjam = JOptionPane.showInputDialog("Tanggal Minjam: "); //variabel untuk tgl_pinjam
        
        JOptionPane.showMessageDialog(null, "Nama Peminjam: "+peminjam+"\n"+"Judul buku: "+buku+"\n"+"Nama Pegawai: "+pegawai+"\n"+"Buku dikembalikan 3 hari sesudah peminjaman");
        
        pengembalian = Integer.valueOf(tanggal_pinjam).intValue();
        //fungsi valueOf adalah mengembalikan sebuah objek Integer memegang nilai yang direpresentasikan sebagai string yang telah ditentukan.
        //fungsi intValue adalah yang akan mengembalikan(return) nilai dari object Number yang digunakan(Integer, Double dll) menjadi tipe data primitive(int).
        pengembalian = pengembalian +3; //fungsinya untuk menghitung nilai dari tanggal minjam dan di tambahkan nilai +3 yaitu tanggal pinjam ditambah 3
        JOptionPane.showMessageDialog(null, "Pengembalian buku diharuskan tanggal: "+pengembalian);
        
        String tanggal_pengembalian;
        tanggal_pengembalian = JOptionPane.showInputDialog("Masukan tanggal pengembalian: ");
        int operasi; // membuat variabel untuk kondisi if else
        int operasi2; // membuat variabel untuk kondisi if else
        operasi = Integer.valueOf(tanggal_pengembalian).intValue();
        
        operasi2 = (operasi-pengembalian) *10000; //menghitung tanggal pengembalian kalikan denda
        if (operasi >= pengembalian)
        JOptionPane.showMessageDialog(null, "Anda dikenakan denda"+"\n"+"Denda: Rp. "+operasi2);
        else if (operasi >= pengembalian)
            JOptionPane.showMessageDialog(null, "Anda tidak dikenakan denda");
        else
            JOptionPane.showMessageDialog(null, "tidak denda.");
    }
    
}
