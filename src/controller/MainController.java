/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class MainController implements Initializable {

    @FXML
    private Pane paneMenu;
    @FXML
    private BorderPane solut;
    @FXML
    private JFXButton userConnecter;
    @FXML
    private JFXButton homeBtn;
    @FXML
    private JFXButton btnDocument;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            home();
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void test(MouseEvent event) throws IOException, InstantiationException, IllegalAccessException {
        AnchorPane root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/test.fxml"));
        root = loader.load();
        solut.setCenter(root);
        TestController testController = loader.getController();
        testController.IdentifierBtnConnecter("Document");
    }

    public void myfunction(String user, boolean var) {
        if (var == false) {
            userConnecter.setDisable(true);
        }
        userConnecter.setText(user);
    }

    @FXML
    private void affecheInfo(ActionEvent event) throws IOException {
        Stage window1 = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/infoUsers.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1030, 700);
        // Button button= new Button("click here");
        //  scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
        window1.setScene(scene);
        window1.setTitle("information sur user");
        Image img = new Image("image/iconBib.png");
        window1.getIcons().add(img);
        window1.show();
    }

    @FXML
    private void home() throws IOException {
        // solut.setCenter(solut.getCenter());
        AnchorPane root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/home.fxml"));
        root = loader.load();
        solut.setCenter(root);
        HomeController homeController = loader.getController();
        homeController.IdentifierBtnConnecter("Home");
    }

    @FXML
    private void about(MouseEvent event) {
        System.out.println("about Aplication");
    }

    @FXML
    private void aderentfunc(ActionEvent event) throws IOException {
        AnchorPane root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/adherent.fxml"));
        root = loader.load();
        solut.setCenter(root);
        AdherentController adherentController = loader.getController();
        adherentController.IdentifierBtnConnecter("Adherent");
    }

}
