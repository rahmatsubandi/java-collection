/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rahmatsubandi.uas;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Rahmat Subandi
 */
public class MainController implements Initializable {
    
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfNama;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfNohp;
    @FXML
    private TextField tfAlamat;
    @FXML
    private TableView<Penduduk> tvPenduduk;
    @FXML
    private TableColumn<Penduduk, Integer> colId;
    @FXML
    private TableColumn<Penduduk, String> colNama;
    @FXML
    private TableColumn<Penduduk, String> colEmail;
    @FXML
    private TableColumn<Penduduk, Integer> colNohp;
    @FXML
    private TableColumn<Penduduk, String> colAlamat;
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnExit;
    @FXML
    private TextField search;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource() == btnInsert){
            insertRecord();
        }else if (event.getSource() == btnUpdate){
            updateRecord();
        }else if (event.getSource() == btnDelete){
            deleteButton();
        }else if (event.getSource() == btnExit){
            exitButton();
        }
    }
    
    FilteredList filter = new FilteredList(getPendudukList(),e->true);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showPenduduk();
    }
    
    // Membuat Koneksi ke database
    public Connection getConnection(){
        Connection conn;
        try{
            conn= DriverManager.getConnection("jdbc:mysql://localhost/penduduk", "root","");
            return conn;
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
    
    public ObservableList<Penduduk> getPendudukList(){
        ObservableList<Penduduk> pendudukList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM users";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Penduduk penduduk;
            while(rs.next()){
                penduduk = new Penduduk(rs.getInt("id"), rs.getString("nama"), rs.getString("email"), rs.getInt("nohp"), rs.getString("alamat"));
                pendudukList.add(penduduk);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return pendudukList;
    }
    
    public void showPenduduk(){
        ObservableList<Penduduk> list = getPendudukList();
        
        colId.setCellValueFactory(new PropertyValueFactory<Penduduk, Integer>("id"));
        colNama.setCellValueFactory(new PropertyValueFactory<Penduduk, String>("nama"));
        colEmail.setCellValueFactory(new PropertyValueFactory<Penduduk, String>("email"));
        colNohp.setCellValueFactory(new PropertyValueFactory<Penduduk, Integer>("nohp"));
        colAlamat.setCellValueFactory(new PropertyValueFactory<Penduduk, String>("alamat"));
        
        tvPenduduk.setItems(list);
    }
    // Setiap string selalu dibungkus dengann ('') untuk type string didalam (",") sebagai pemisah
    // Membuat fungsi insert pada button
    private void insertRecord(){
        String query = "INSERT INTO users VALUES (" + tfId.getText()  + ",'" + tfNama.getText() + "','" + tfEmail.getText() + "',"
                + tfNohp.getText() + ",'" + tfAlamat.getText() + "')";
        executeQuery(query);
        showPenduduk();
    }
    // Fungsi untuk update
    private void updateRecord(){
        String query = "UPDATE users SET nama = '" + tfNama.getText() + "', Email = '" + tfEmail.getText() + "', nohp = " +
                tfNohp.getText() + ", alamat = '" + tfAlamat.getText() + "'WHERE id = " + tfId.getText() + "";
        executeQuery(query);
        showPenduduk();
    }
    // Fungsi Hapus
    private void deleteButton(){
        String query = "DELETE FROM users WHERE id =" + tfId.getText() + "";
        executeQuery(query);
        showPenduduk();
    }
    private void exitButton(){
        System.exit(0);
    }
    

    private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML
    private void handleMouseAction(MouseEvent event) {
       Penduduk penduduk = tvPenduduk.getSelectionModel().getSelectedItem();
       tfId.setText("" +penduduk.getId());
       tfNama.setText(penduduk.getNama());
       tfEmail.setText(penduduk.getEmail());
       tfNohp.setText("" +penduduk.getNohp());
       tfAlamat.setText(penduduk.getAlamat());
    }

    @FXML
    private void search(KeyEvent event) {
        search.textProperty().addListener((observable, oldValue, newValue) -> {
        filter.setPredicate((Predicate<? super Penduduk>) (Penduduk penduduk)->{
	// If filter text is empty, display all persons.
	if (newValue == null || newValue.isEmpty()) {
		return true;
	}
				
	// Compare first name and last name of every person with filter text.
	String lowerCaseFilter = newValue.toLowerCase();
	String stringFilter = newValue.toString();
				
	if (penduduk.getId().toString().contains(stringFilter)) {
		return true; // Filter matches id.
	} else if (penduduk.getNama().toLowerCase().contains(lowerCaseFilter)) {
		return true; // Filter matches name.
	} else if (penduduk.getEmail().toLowerCase().contains(lowerCaseFilter)) {
		return true; // Filter matches email.
	}
	return false; // Does not match.
			});
		});
        
        SortedList sort = new SortedList(filter);
        sort.comparatorProperty().bind(tvPenduduk.comparatorProperty());
        tvPenduduk.setItems(sort);
    }
    
}
