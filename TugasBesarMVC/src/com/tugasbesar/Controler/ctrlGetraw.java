/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugasbesar.Controler;

import com.tugasbesar.Model.Getraw;
import com.tugasbesar.TableModel.Button;
import com.tugasbesar.TableModel.TblModGetraw;
import com.tugasbesar.View.frmGetraw;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Rahmat Subandi
 */
public class ctrlGetraw {
    private frmGetraw frm; //variabel form mahasiswa atau variabel Design
    private Getraw gtw; //mendefiniskan class
    private TblModGetraw model; //mendefiniskan class tblModGetraw
    private boolean isUpdate=false;
    private int row=-1;
    
    public ctrlGetraw(frmGetraw frm){ //membuat parameter (Fungsinya itu untuk menghubungkan frmGetraw dengan ctrlGetraw) kerana frm ini berisikan refernsi dari form Getraw/frmGetraw
        this.frm = frm;
        model = new TblModGetraw();
        frm.getTbl().setModel(model);
        frm.getTbl().getColumnModel().getColumn(5).setCellRenderer(new Button()); //memanggil class pada Button.java
        frm.getTbl().getColumnModel().getColumn(5).setPreferredWidth(100);
        frm.getTbl().addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent e) {
                if(frm.getTbl().getSelectedColumn()==5){
                    row=frm.getTbl().getSelectedRow();
                    setdata();
                }
            }
            
        });
    }
    public void batal(){
        isUpdate=false;
        row=-1;
        refresh();
    }
    public void setdata(){ //untuk update
        Getraw w = model.getOne(row);
        frm.getId().setText(w.getId());
        frm.getPelanggan().setText(w.getPelanggan());
        frm.getMakanan().setText(w.getMakanan());
        frm.getHarga().setText(String.valueOf(w.getHarga()));
        if(w.getMetode().equalsIgnoreCase("Lunas")||w.getMetode().equalsIgnoreCase("Nyicil")){
            frm.getLunas().setSelected(true);
        }else{
            frm.getNyicil().setSelected(true);
        }
        isUpdate=true;
    }
    public void simpan(){ //jika button simpan diklik maka akan memunculkan data yang sudah di inputkan
        gtw= new Getraw(); //memakai class Getraw yang ada di package Model
        //mengisikan atribut gtw
        gtw.setId(frm.getId().getText()); //mengambil atau mengakses dari apa yang diinputkan di frmGetraw
        gtw.setPelanggan(frm.getPelanggan().getText());
        gtw.setMakanan(frm.getMakanan().getText());
        gtw.setHarga(Integer.parseInt(frm.getHarga().getText())); //mengembalikan tipe data string fungsi parse
        //membuat dession untuk mengetahui aa yang dipilih
        if(frm.getLunas().isSelected() && !frm.getNyicil().isSelected()){ //fungsi isSelected untuk mengembalikan true jika diklik. Kalo tidak maka false
            //jika Lunas dipilih dan Nyicil tidak dipilih maka yang dipilih Lunas
            gtw.setMetode("Lunas");
        }else if(!frm.getLunas().isSelected() && frm.getNyicil().isSelected()){
            //jika Nyicil dipilih dan Lunas tidak dipilih maka yang dipilih Nyicil
            gtw.setMetode("Nyicil");
        }
        if(isUpdate){
            model.ubah(row, gtw);
        }else{
            //menampilkan hasil
            model.simpan(gtw);
        }
        refresh();
    }
    public void refresh(){
        frm.getId().setText("");
        frm.getPelanggan().setText("");
        frm.getMakanan().setText("");
        frm.getHarga().setText("");
        frm.getbtnGroup().clearSelection();
    }
}
