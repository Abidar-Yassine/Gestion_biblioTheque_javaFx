/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Adherent;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelBd.AdherentBd;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class AdherentController implements Initializable {

    private ObservableList<Adherent> adherents = FXCollections.observableArrayList();
    @FXML
    private JFXComboBox<String> comboBoxCh;
    @FXML
    private JFXButton btnChercher;
    @FXML
    private JFXComboBox<String> ComboVal;
    @FXML
    private TableView<Adherent> viewAdherent;
    @FXML
    private TableColumn<Adherent, Integer> idColone;
    @FXML
    private Label Btnclicker;
    @FXML
    private TableColumn<Adherent, String> codeColone;
    @FXML
    private TableColumn<Adherent, String> nomColon;
    @FXML
    private TableColumn<Adherent, String> emailColon;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODOcomboBoxCh
        remplirTableView();
        comboBoxCh.getItems().addAll("Code Adherent", "Nom Adherent");
    }

    public void IdentifierBtnConnecter(String str) {
        Btnclicker.setText(str);
    }

    @FXML
    private void remplir2(ActionEvent event) {
        if (comboBoxCh.getValue().equalsIgnoreCase("Code Adherent")) {
            remplitCodeAdher();
        } else if (comboBoxCh.getValue().equalsIgnoreCase("Nom Adherent")) {
            remplitNomAdherent();
        }
    }

    public void remplitCodeAdher() {
        List<Adherent> adherents = AdherentBd.getAll();
        ComboVal.getItems().clear();
        for (Adherent adherent : adherents) {
            ComboVal.getItems().add(adherent.getCode());
        }
    }

    public void remplitNomAdherent() {
        List<Adherent> adherents = AdherentBd.getAll();
        ComboVal.getItems().clear();
        for (Adherent adherent : adherents) {
            ComboVal.getItems().add(adherent.getNom());
        }
    }

    @FXML
    private void find(ActionEvent event) {
        

    }

    @FXML
    private void ajouterAdherent(ActionEvent event) {

    }

    public void remplirTableView() {
        adherents = AdherentBd.getallListOb();
        idColone.setCellValueFactory(new PropertyValueFactory<Adherent, Integer>("id"));
        codeColone.setCellValueFactory(new PropertyValueFactory<Adherent, String>("code"));
        emailColon.setCellValueFactory(new PropertyValueFactory< Adherent, String>("nom"));
        nomColon.setCellValueFactory(new PropertyValueFactory< Adherent, String>("email"));
        viewAdherent.setItems(adherents);
    }

}
