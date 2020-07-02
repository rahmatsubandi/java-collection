/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugasbesar.TableModel;

import com.tugasbesar.Model.Getraw;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rahmat Subandi
 */
public class TblModGetraw extends AbstractTableModel{

    private ArrayList<Getraw> list = new ArrayList<>(); //untuk menyimpan data atau menampung yang diinputkan
    private final String[] header={"Id", "Pelanggan", "Makanan", "Metode", "Harga","Aksi"};
    @Override
    public int getRowCount() { //fungsinya mengembalikan jumlah row yang ada
        return list.size(); //mengembalikan garis sesuai dengan jumlah
    }

    @Override
    public String getColumnName(int column) {
        return header[column]; //untuk mencetak data headernya
    }
    
    
    @Override
    public int getColumnCount() { //fungsinya mengembalikan jumlah kolom yang ada
        return header.length; //mendefinisikan variabel header
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) { //fungsinya untuk mengembalikan atau manampilkan data yang ada di table
        Getraw g = list.get(rowIndex); //mereferensikan object yaitu g dengan list sesuai dengan variabel get(rowIndex)
        switch(columnIndex){
            case 0: return g.getId();
            case 1: return g.getPelanggan();
            case 2: return g.getMakanan();
            case 3: return g.getMetode();
            case 4: return g.getHarga();
            case 5: return "";
            default: return null;
        }
    }
    public void simpan(Getraw gtw){
        list.add(gtw); //menambahkan data kedalam list
        fireTableRowsInserted(list.size()-1, list.size()-1); //memberi tau table bahwa ada data yang masuk agar di render sesuai dengan data yang ada
    }
    
    public Getraw getOne(int index){
        return list.get(index);
    }
    
    public void ubah(int index,Getraw w){
        list.set(index, w);
        fireTableRowsUpdated(index, index);
    }
}
