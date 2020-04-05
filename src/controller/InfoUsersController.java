/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.User;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.effects.JFXDepthManager;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import modelBd.UserBd;
import util.AlertTypeShow;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class InfoUsersController implements Initializable {

    @FXML
    private Pane princiInfo;
    @FXML
    private JFXComboBox<String> listNomUser;
    @FXML
    private JFXTextField userName;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField id;
    private TextField file_coisi;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField password;
    @FXML
    private JFXTextField email2;
    @FXML
    private Label Btnclicker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        JFXDepthManager.setDepth(princiInfo, 5);
        remplitList();
    }

    public void remplitList() {
        UserBd userBd = new UserBd();
        List<User> users = userBd.getAll();
        for (User user : users) {
            listNomUser.getItems().add(user.getUsername());
        }
    }

    @FXML
    private void afficheInfo(ActionEvent event) {
        UserBd userBd = new UserBd();
        String name = listNomUser.getValue();
        User u = userBd.findByUserName(name);
        userName.setText(u.getUsername());
        email.setText(u.getEmail());
        id.setText(Integer.toString(u.getId()));
    }

    private void choisirImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File selected = fileChooser.showOpenDialog(null);
        if (selected != null) {
            // file_coisi.setText(selected.getAbsolutePath());
            selected.getAbsoluteFile();
        } else {
            AlertTypeShow.showAlertError("erreur");

        }

    }

    @FXML
    private void SaveUser(ActionEvent event) {
        int rep;
        User user = new User();
        if (name.getText().isEmpty() || password.getText().isEmpty() || email2.getText().isEmpty()) {
            AlertTypeShow.showAlertError("Please remplit tout les champs");
        } else {
            user.setUsername(name.getText());
            user.setPassword(password.getText());
            user.setEmail(email2.getText());
            rep = UserBd.saveUser(user);
            if (rep != 0) {
                AlertTypeShow.showAlertInfor("New user insered succssefly");
            } else {
                AlertTypeShow.showAlertError("ERREUR");
            }

        }

    }

    @FXML
    private void delteUser(ActionEvent event) {
        if(id.getText().isEmpty()){
            AlertTypeShow.showAlertError("Choisi Une user");
        }else{
        User user = UserBd.getById(Long.parseLong(id.getText()));
        if (user.getUsername().equalsIgnoreCase("admin")) {
            AlertTypeShow.showAlertError("Impossible de supprimer l'admin");
        } else {
            int rep = UserBd.deleteUser(user);
            if (rep != 0) {
                AlertTypeShow.showAlertInfor("the user " + user.getUsername() + " " + "has been deleted");
            } else {
                System.out.println("same probleme");
            }
        }
    }
    }

    @FXML
    private void updateUser(ActionEvent event) {
        int rep = 0;
        User user = new User();
        user.setEmail(email.getText());
        user.setPassword(password.getText());
        user.setUsername(userName.getText());
        rep = UserBd.update(user);
        if (rep != 0) {
            AlertTypeShow.showAlertInfor("user updated");
        } else {
            System.out.println("some probleme");
        }

    }
}
