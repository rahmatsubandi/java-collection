/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pertemuan.pkg3;

import javax.swing.JOptionPane;

/**
 *
 * @author Rahmat Subandi
 */
public class Pertemuan3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String nama, jurusan, nilaiNA; //tipe data string
        int nilai; //tipe data integer
        nama = JOptionPane.showInputDialog(null, "Masukan nama anda: ","Selamatkan di Pratikum PBO Pert.3",JOptionPane.QUESTION_MESSAGE);
        jurusan = JOptionPane.showInputDialog(null, "Masukan jurusan anda: ","Selamatkan di Pratikum PBO Pert.3",JOptionPane.QUESTION_MESSAGE);
        nilaiNA = JOptionPane.showInputDialog(null, "Masukan nilai anda: ","Selamatkan di Pratikum PBO Pert.3",JOptionPane.QUESTION_MESSAGE);
        nilai = Integer.parseInt(nilaiNA);
        
        String grade, status;
        
        if(nilai>=90)
        {
            grade ="A";
        }
        else if(nilai>=80)
        {
            grade = "B";
        }
        else if(nilai>=70)
        {
            grade = "C";
        }
        else if(nilai>=60)
        {
            grade = "D";
        }
        else
        {
            grade ="E";
        }
        if (nilai>=65)
        {
            status ="LULUS";
        }
        else
        {
            status ="TIDAK LULUS";
        }
        String output = "Nama:"+nama+"\n"+"Jurusan : "+"\n"+"Nilai: "+nilai+"\n"+"Grade: "+grade+"\n"+"Status: "+status;
        JOptionPane.showMessageDialog(null,"Berikut hasil anda: "+output,"Selamatkan di Pratikum PBO Pert.3",JOptionPane.INFORMATION_MESSAGE);
    }
}
