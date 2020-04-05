/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelBd.UserBd;
import util.AlertTypeShow;

/**
 *
 * @author yassine
 */
public class EtheController implements Initializable, EventHandler<Event> {

    @FXML
    private AnchorPane principalPne;
    private Pane paneConnecter1;
    @FXML
    private Label lable111;
    @FXML
    private JFXButton Butninscrish11;
    @FXML
    private Pane paneInscrition;
    @FXML
    private Pane paneinscrir;
    @FXML

    private Label lable1;
    @FXML
    private JFXButton Butninscrish;
    @FXML
    private JFXButton btnse2;
    @FXML
    private Label lblse;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton Butninscrish1;
    @FXML
    private Label imageView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("heloo");
    }

    @FXML
    private void show(ActionEvent event) {
        paneInscrition.setVisible(true);
        paneinscrir.setVisible(false);
        principalPne.setVisible(false);
        lable111.setVisible(true);
        Butninscrish11.setVisible(true);

    }

    @FXML
    private void inverseShow(ActionEvent event) {
        paneInscrition.setVisible(false);
        paneinscrir.setVisible(true);
        principalPne.setVisible(true);
        lable111.setVisible(false);
        Butninscrish11.setVisible(false);
    }

    @FXML
    public void tentification() throws IOException {
        String help = null;
        List<User> users = new ArrayList<User>();

        users = UserBd.getAll();
        Map<String, String> map = new HashMap<String, String>();
        for (User a : users) {

            map.put(a.getUsername(), a.getPassword());

        }
        if (map.containsKey(name.getText())) {
            String val = map.get(name.getText());   /// return la valeur correspandante a la cle en parametre
            if (val.equalsIgnoreCase(password.getText())) {
                // infoLabel.setText("welcomme");
                UserBd.getconnection();
                Stage window1 = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main.fxml"));
                Parent root = loader.load();
                MainController mainController = loader.getController();
                if (name.getText().equalsIgnoreCase("admin")) {
                    mainController.myfunction(name.getText(), true);
                } else {
                    mainController.myfunction(name.getText(), false);
                }
                Scene scene = new Scene(root, 1261, 958);
                // Button button= new Button("click here");
                //  scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
                Image img = new Image("image/iconBib.png");
                window1.getIcons().add(img);
                window1.setScene(scene);
                window1.show();
            } else {
                AlertTypeShow.showAlertError("Password or user name is wrong");
                System.out.println("c'est pas le meme password");
            }

        } else {
            AlertTypeShow.showAlertError("Password or user name is wrong");
            System.out.println("n'a pas trouver name");

        }
    }

    @FXML
    private void direct(ActionEvent event) throws IOException {
        UserBd.getconnection();
        Stage window1 = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main.fxml"));
        Parent root = loader.load();
        MainController mainController = loader.getController();
        if (name.getText().equalsIgnoreCase("admin")) {
            mainController.myfunction(name.getText(), true);
        } else {
            mainController.myfunction(name.getText(), false);
        }

        Scene scene = new Scene(root, 1261, 958);
        // Button button= new Button("click here");
        //  scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
        Image img = new Image("image/iconBib.png");
        window1.getIcons().add(img);
        window1.setScene(scene);
        window1.show();
    }

    @FXML
    private void close(MouseEvent event
    ) {
        Stage stage;
        stage = (Stage) imageView.getScene().getWindow();
        stage.close();

    }

    @Override
    public void handle(Event event
    ) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
