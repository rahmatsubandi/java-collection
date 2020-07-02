/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Rahmat Subandi
 */
public class Tugas1 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String nama, kampus, buah, pohon, alamat, telpon;
        
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Biodata Singkat");
        System.out.print("Nama saya ");
        nama = keyboard.nextLine();
        System.out.print("Saya tinggal di ");
        alamat = keyboard.nextLine();
        System.out.print("Berkuliah di ");
        kampus = keyboard.nextLine();
        System.out.print("Dirumah saya ada pohon ");
        pohon = br.readLine();
        System.out.print("Saya suka dengan buah ");
        buah = br.readLine();
        System.out.print("Nomer Telpon saya ");
        telpon = keyboard.nextLine();
        System.out.println("Hallo "+nama);
        System.out.println("Alamat kamu di "+alamat+" "+"Kamu kuliah di "+kampus+" "+"Rumah kamu ada pohon "+pohon+" "+"yah..");
        System.out.println("Kamu juga suka buah "+buah+" "+"kan?");
        System.out.println("Dan nomer telpon kamu ini "+telpon);
    }
    
}
