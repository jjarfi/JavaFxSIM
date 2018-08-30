/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wilayah;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author pacevil
 */
public class WilayahController implements Initializable {

    @FXML
    private AnchorPane jendela,jendela1;
    @FXML
    private Pane pan1, pan2, pan3;
    AnchorPane wilayah, kampung, distrik;
    @FXML
    private JFXButton btn1, btn2, btn3;

    @FXML
    private void mosenter1(MouseEvent event) {
        btn1.setStyle("-fx-background-color: #000000");
        pan1.setStyle("-fx-background-color: #08DDFF");
    }

    @FXML
    private void mosenter2(MouseEvent event) {
        btn2.setStyle("-fx-background-color: #000000");
        pan2.setStyle("-fx-background-color: #08DDFF");
    }

    @FXML
    private void mosenter3(MouseEvent event) {
        btn3.setStyle("-fx-background-color: #000000");
        pan3.setStyle("-fx-background-color: #08DDFF");
    }

    @FXML
    private void mosexit1(MouseEvent event) {

        btn1.setStyle("-fx-background-color: #000000");
        pan1.setStyle("-fx-background-color: #000000");
    }

    @FXML
    private void mosexit2(MouseEvent event) {
        btn2.setStyle("-fx-background-color: #000000");
        pan2.setStyle("-fx-background-color: #000000");
    }

    @FXML
    private void mosexit3(MouseEvent event) {
        btn3.setStyle("-fx-background-color: #000000");
        pan3.setStyle("-fx-background-color: #000000");
    }

    @FXML
    private void pindahkampung(ActionEvent event) {
        setNode(kampung);
    }
  @FXML
    private void pindahdistrik(ActionEvent event) {
        setNode(distrik);
    }
     @FXML
    private void pindahwilayah(ActionEvent event) {
        setNode(wilayah);
    }
    private void setNode(Node node) {
        jendela1.getChildren().clear();
        jendela1.getChildren().add(node);
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
         try {
            wilayah = FXMLLoader.load(getClass().getResource("/Pembangunan/Pembangunan.fxml"));
            kampung = FXMLLoader.load(getClass().getResource("/Kampung/Kampung.fxml"));
            distrik = FXMLLoader.load(getClass().getResource("/Distrik/Distrik.fxml"));
        } catch (IOException e) {

        }
    }

}
