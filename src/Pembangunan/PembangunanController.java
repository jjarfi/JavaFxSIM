/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pembangunan;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author pacevil
 */
public class PembangunanController implements Initializable {

    @FXML
    private JFXButton btnsimpan;
    @FXML
    private JFXButton btnupdate;
    @FXML
    private JFXButton btnhapus;
    
    
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
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    
}
