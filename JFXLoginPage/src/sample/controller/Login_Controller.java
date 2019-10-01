package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login_Controller implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField loginUsername;

    @FXML
    private JFXPasswordField loginPassword;

    @FXML
    private JFXButton loginButton;

    public Login_Controller() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginUsername.setStyle("-fx-text-inner-color: #ffffff");
        loginPassword.setStyle("-fx-text-inner-color: #ffffff");
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loginUser();
            }
        });
    }
    private void loginUser(){

        if(!loginUsername.getText().toString().trim().equals("") && !loginPassword.getText().toString().trim().equals("")){
            //we are good to go
            loginButton.getScene().getWindow().hide();
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/details.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage= new Stage();
            stage.setScene(new Scene(root));

            Details_Controller details_controller= loader.getController();
            details_controller.setName(loginUsername.getText(), "Java And Web Programmer", 24);
            stage.show();
        }
    }
}
