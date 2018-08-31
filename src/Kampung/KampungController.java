/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kampung;

import Koneksi.Koneksi;
import Model.kampung;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author pacevil
 */
public class KampungController implements Initializable {

    private ObservableList<kampung> data;
    private Koneksi konek;
    private Connection conn;
    private static String query = "";
    private PreparedStatement pst;
    int panjanginput = 5;

    @FXML
    private JFXButton btnsimpan, btnupdate, btnhapus;
    @FXML
    private JFXTextField txtid, txtnama;
    @FXML
    private TableView<kampung> tabel;

    @FXML
    private TableColumn<String, kampung> kolid;

    @FXML
    private TableColumn<String, kampung> kolnama;

    @FXML
    private void mosenter1(MouseEvent event) {
        btnsimpan.setStyle("-fx-background-color: #21CA38");

    }

    @FXML
    private void mosenter2(MouseEvent event) {
        btnupdate.setStyle("-fx-background-color: #F96F05");

    }

    @FXML
    private void mosenter3(MouseEvent event) {
        btnhapus.setStyle("-fx-background-color: #DC0108");

    }

    @FXML
    private void mosexit1(MouseEvent event) {

        btnsimpan.setStyle("-fx-background-color: #000000");

    }

    @FXML
    private void mosexit2(MouseEvent event) {
        btnupdate.setStyle("-fx-background-color: #000000");

    }

    @FXML
    private void mosexit3(MouseEvent event) {
        btnhapus.setStyle("-fx-background-color: #000000");

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        konek = new Koneksi();
        konek();
        refresh();
    }

    @FXML
    private void simpan(ActionEvent event) {
        simpan();
    }

    private void simpan() {
        if (txtid.getText().isEmpty() | txtnama.getText().isEmpty()) {
            TrayNotification tnn = new TrayNotification("WARNING", "ID Kampung atau Nama Kampung \n Tidak Boleh Kosong", NotificationType.WARNING);
            tnn.setAnimationType(AnimationType.POPUP);
            tnn.showAndDismiss(Duration.seconds(2));

        } else if (panjang(txtid.getText(), panjanginput)) {
            TrayNotification tnn = new TrayNotification("WARNING", "ID Tidak Boleh \n Lebih Dari Lima (5) Karakter", NotificationType.WARNING);
            tnn.setAnimationType(AnimationType.POPUP);
            tnn.showAndDismiss(Duration.seconds(2));
        }  else {
            try {
                Statement stt = conn.createStatement();
                String sql = "select * from kampung where id_kampung = '" + txtid.getText() + "'";
                ResultSet rs = stt.executeQuery(sql);
                if (rs.next() == true) {
                    TrayNotification tn = new TrayNotification("WARNING", "ID Kampung Sudah Terdaftar", NotificationType.NOTICE);
                    tn.setAnimationType(AnimationType.POPUP);
                    tn.showAndDismiss(Duration.seconds(1));
                    refresh();
                } else {
                    conn = konek.konekDB();
                    String insert = "insert into kampung(id_kampung,nm_kampung) values (?,?)";

                    try {
                        pst = conn.prepareStatement(insert);
                        pst.setString(1, txtid.getText());
                        pst.setString(2, txtnama.getText());
                        int berhasil = pst.executeUpdate();
                        if (berhasil == 1) {
                            hapus();
                            refresh();
                            TrayNotification tn = new TrayNotification("SUCCESS", "Data Berhasil Berhasil", NotificationType.SUCCESS);
                            tn.setAnimationType(AnimationType.POPUP);
                            tn.showAndDismiss(Duration.seconds(2));
                        } else {
                            TrayNotification tn = new TrayNotification("ERROR", "Data Berhasil GAGAL", NotificationType.ERROR);
                            tn.setAnimationType(AnimationType.POPUP);
                            tn.showAndDismiss(Duration.seconds(2));
                        }

                    } catch (SQLException ex) {
                        System.err.println("Error inserting" + ex);
                        TrayNotification tn = new TrayNotification("WARNING", "Periksa Kembali Inputan Anda", NotificationType.WARNING);
                        tn.setAnimationType(AnimationType.POPUP);
                        tn.showAndDismiss(Duration.seconds(2));
                    }
                }

            } catch (SQLException ex) {
                System.err.println("Error inserting" + ex);
                TrayNotification tn = new TrayNotification("WARNING", "Periksa Kembali Inputan Anda", NotificationType.WARNING);
                tn.setAnimationType(AnimationType.POPUP);
                tn.showAndDismiss(Duration.seconds(2));
            }
        }

    }

    private void hapus() {
        txtid.setText("");
        txtnama.setText("");
    }

    private void refresh() {
        konek();
        tabel.getItems().clear();
        query = "select * from kampung";
        tabelanga();
    }

    public boolean panjang(String in, int len) {
        return in.length() > len;
    }

    public boolean valid() {
        Pattern p = Pattern.compile("[0-9]");
        Pattern pp = Pattern.compile("[a-z]");
        Pattern ppp = Pattern.compile("[A-Z]");
        Matcher m = p.matcher(txtid.getText());
        Matcher mm = pp.matcher(txtid.getText());
        Matcher mmm = ppp.matcher(txtid.getText());
        if (m.find() && m.group().equals(txtid.getText())) {
            return true;
        }
        if (mm.find() && mm.group().equals(txtid.getText())) {

             return true;
        }
        if (mmm.find() && mmm.group().equals(txtid.getText())) {
             return true;
        } else {

            return false;
        }
       

    }
    public boolean textonly(){
        txtid.textProperty().addListener((observable, oldValue, newValue)->{
            if(!newValue.matches(("\\sa-zA-Z*"))){
                txtid.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
            }
        });
        return true;
    }
    public boolean numonly(){
        txtid.textProperty().addListener((observable, oldValue, newValue)->{
            if(!newValue.matches(("\\d*"))){
                txtid.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        return true;
    }


    private void tabelanga() {
        konek();
        try {
            data = FXCollections.observableArrayList();

            ResultSet set = conn.createStatement().executeQuery(query);
            while (set.next()) {
                String idka = set.getString(1);
                String nama = set.getString(2);
                data.add(new kampung(idka, nama));
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        kolid.setCellValueFactory(new PropertyValueFactory<>("idka"));
        kolnama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        tabel.setItems(null);
        tabel.setItems(data);
    }

    public void konek() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sim", "root", "");
            pst = conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            pst.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Exception" + e.getMessage());
        }
    }

}
