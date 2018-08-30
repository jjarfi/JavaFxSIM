/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pacevil
 */
public class LoginController implements Initializable {


    @FXML
    private AnchorPane root;

 

    @FXML
    private void kliklogin(ActionEvent event) {

        try {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent rocot = FXMLLoader.load(getClass().getResource("/Admin/Admin.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(rocot);
            stage.setTitle("Sistem Informasi Pariwisata");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {

        }

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
    }

}
