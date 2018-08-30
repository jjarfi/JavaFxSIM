/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

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
public class AdminController implements Initializable {

    @FXML
    private AnchorPane jendela;
    @FXML
    private Pane pan1, pan2, pan3, pan4, pan5, pan6;
    AnchorPane wilayah, kategori;

    @FXML
    private JFXButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

    @FXML
    private void mosenter1(MouseEvent event) {
        btn1.setStyle("-fx-background-color: #142430");
        pan1.setStyle("-fx-background-color: #08DDFF");
    }

    @FXML
    private void mosenter2(MouseEvent event) {
        btn2.setStyle("-fx-background-color: #142430");
        pan2.setStyle("-fx-background-color: #08DDFF");
    }

    @FXML
    private void mosenter3(MouseEvent event) {
        btn3.setStyle("-fx-background-color: #142430");
        pan3.setStyle("-fx-background-color: #08DDFF");
    }

    @FXML
    private void mosenter4(MouseEvent event) {
        btn4.setStyle("-fx-background-color: #142430");
        pan4.setStyle("-fx-background-color: #08DDFF");
    }

    @FXML
    private void mosenter5(MouseEvent event) {
        btn5.setStyle("-fx-background-color: #142430");
        pan5.setStyle("-fx-background-color: #08DDFF");
    }

    @FXML
    private void mosenter6(MouseEvent event) {
        btn6.setStyle("-fx-background-color: #142430");
        pan6.setStyle("-fx-background-color: #08DDFF");
    }

    @FXML
    private void mosenter7(MouseEvent event) {
        btn7.setStyle("-fx-border-color: #08DDFF");
    }

    @FXML
    private void mosenter8(MouseEvent event) {
        btn8.setStyle("-fx-border-color: #08DDFF");
    }

    @FXML
    private void mosenter9(MouseEvent event) {
        btn9.setStyle("-fx-border-color: #08DDFF");
    }

    @FXML
    private void mosexit1(MouseEvent event) {

        btn1.setStyle("-fx-border-color:  #142430");
        pan1.setStyle("-fx-background-color: #142430");
    }

    @FXML
    private void mosexit2(MouseEvent event) {
        btn2.setStyle("-fx-border-color:  #142430");
        pan2.setStyle("-fx-background-color: #142430");
    }

    @FXML
    private void mosexit3(MouseEvent event) {
        btn3.setStyle("-fx-border-color:  #142430");
        pan3.setStyle("-fx-background-color: #142430");
    }

    @FXML
    private void mosexit4(MouseEvent event) {
        btn4.setStyle("-fx-border-color:  #142430");
        pan4.setStyle("-fx-background-color: #142430");
    }

    @FXML
    private void mosexit5(MouseEvent event) {
        btn5.setStyle("-fx-border-color:  #142430");
        pan5.setStyle("-fx-background-color: #142430");
    }

    @FXML
    private void mosexit6(MouseEvent event) {
        btn6.setStyle("-fx-border-color:  #142430");
        pan6.setStyle("-fx-background-color: #142430");
    }

    @FXML
    private void mosexit7(MouseEvent event) {
        btn7.setStyle("-fx-border-color:  #142430");
    }

    @FXML
    private void mosexit8(MouseEvent event) {
        btn8.setStyle("-fx-border-color:  #142430");
    }

    @FXML
    private void mosexit9(MouseEvent event) {
        btn9.setStyle("-fx-border-color:  #142430");
    }

    @FXML
    private void pindahwilayah(ActionEvent event) {
        setNode(wilayah);
    }

    @FXML
    private void pindahketegori(ActionEvent event) {
        setNode(kategori);
    }

    private void setNode(Node node) {
        jendela.getChildren().clear();
        jendela.getChildren().add(node);

//        FadeTransition ft = new FadeTransition(Duration.millis(1500));
//        ft.setNode(node);
//        ft.setFromValue(0.1);
//        ft.setToValue(1);
//        ft.setCycleCount(1);
//        ft.setAutoReverse(false);
//        ft.play();
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
            wilayah = FXMLLoader.load(getClass().getResource("/wilayah/Wilayah.fxml"));
            kategori = FXMLLoader.load(getClass().getResource("/Kategori/Kategori.fxml"));
        } catch (IOException e) {

        }
    }

}
