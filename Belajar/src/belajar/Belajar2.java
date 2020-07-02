/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belajar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author labgdbaru
 */
public class Belajar2 { //ini namanya sesuai dengan nama file
    public static void main(String[]args) throws IOException {
        String nama, alamat;
        
        //Membuat objek inputscreen
        InputStreamReader isr = new InputStreamReader(System.in);
        
        //membuat objek bufferedReader
        BufferedReader br = new BufferedReader(isr);
        
        //mengisi variabel nama depan buffereadreader
        System.out.print("Inputkan Nama: ");
        nama = br.readLine();
        System.out.print("Inputkan Alamat: ");
        alamat = br.readLine();
        
        //tampilkan output isi variabel nama
        System.out.println("Nama Kamu Adalah "+nama);
        System.out.println("Dan alamat kamu di "+alamat);
        
        
    }
    
}
