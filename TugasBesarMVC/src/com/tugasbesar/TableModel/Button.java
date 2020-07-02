/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugasbesar.TableModel;

import java.awt.Color;
import java.awt.Component;
import javax.swing.CellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Rahmat Subandi
 */
public class Button extends JButton implements TableCellRenderer{

    public Button(){
        super("ubah"); //nama button
        setBackground(Color.GREEN); //waarna button
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
    
}
