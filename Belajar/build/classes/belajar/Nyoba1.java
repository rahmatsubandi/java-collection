/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belajar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author labgdbaru
 */
public class Nyoba1 {
    public static void main(String[] args)throws IOException {
 
        String nama, alamat;
        
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Biodata");
        System.out.print("Nama Mahasiswa: ");
        nama = keyboard.nextLine();
        System.out.print("Inputkan Alamat: ");
        alamat = br.readLine();
        System.out.println("Nama Kamu "+nama);
        System.out.println("Dan alamat kamu "+alamat);
        
}
}