package belajar;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//mengimpor Scanner ke program

/**
 *
 * @author labgdbaru
 */
public class latihan1 { //ini namanya sesuai dengan nama file
    public static void main(String[] args){
        //deklarasi variabel
        String nama, alamat, hobi;
        int usia, nilai;
        
        //membuat scanner baru
        Scanner keyboard = new Scanner(System.in);
        
        //tampilkan output ke user
        System.out.println("## Pendaftaran Mahasiswa Baru Universitas Mercu Buana Bekasi");
        System.out.print("Nama Mahasiswa: ");
        //menggunakan Scanner dan menyimpan apa yang diketik divariabel nama
        nama = keyboard.nextLine();
        //Tampilkan output lagi
        System.out.print("Alamat: ");
        //menggunakan scanner lagi
        alamat = keyboard.nextLine();
        
        System.out.print("Hobi: ");
        hobi = keyboard.nextLine();
        
        System.out.print("Usia: ");
        usia = keyboard.nextInt();
        
        System.out.print("Nilai: ");
        nilai = keyboard.nextInt();
        
        //menampilkan apa yang sudah disimpan di variabel
        System.out.println("-----------------------------");
        System.out.println("Nama Mahasiswa: " + nama);
        System.out.println("Alamat: " + alamat);
        System.out.println("Usia: " + usia);
        System.out.println("Nilai: " + nilai);
    }
    
}
