/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Livre;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import modelBd.LivreBd;
import util.AlertTypeShow;

/**
 *
 * @author yassine
 */
public class TestController implements Initializable {

    private ObservableList<Livre> livres1 = FXCollections.observableArrayList();
//
    @FXML
    private JFXComboBox<String> comboBoxCh;
    @FXML
    private JFXButton btnChercher;
    @FXML
    private JFXComboBox<String> ComboVal;
    @FXML
    private TableView<Livre> viewLivre;
    @FXML
    private TableColumn<Livre, Integer> idColone;
    @FXML
    private TableColumn<Livre, String> isbnColon;
    @FXML
    private TableColumn<Livre, String> titreColon;
    @FXML
    private TableColumn<Livre, Integer> id_aut_Colon;
    @FXML
    private TableColumn<Livre, Integer> nbExemColone;
    @FXML
    private TableColumn<Livre, String> coloneEtat;
    @FXML
    private TableColumn<Livre, String> colLong;
    @FXML
    private Label Btnclicker;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        comboBoxCh.getItems().addAll("id_Livre", "id_Auteur", "titre");
        remplirTableView();
    }

    //contextMenu.getItems().addAll(menuItem1,menuItem2,menuItem3);
    MenuItem menuItem1 = new MenuItem("update");
    MenuItem menuItem2 = new MenuItem("Supprimer");
    MenuItem menuItem3 = new MenuItem("Details");

    @FXML
    private void find(ActionEvent event) {
        LivreBd livreBd = new LivreBd();
        ObservableList<Livre> livres = livreBd.getallListOb();
        if (ComboVal.getItems().isEmpty()) {
            AlertTypeShow.showAlertError("Choisit un critere");
        } else {

            if (comboBoxCh.getValue().equalsIgnoreCase("id_Livre")) {
                int id = Integer.parseInt(ComboVal.getValue());
                findbyIdLivre(id);
            } else if (comboBoxCh.getValue().equalsIgnoreCase("id_Auteur")) {
                int id_auteur = Integer.parseInt(ComboVal.getValue());
                findbyIdAuteur(id_auteur);
            } else if (comboBoxCh.getValue().equalsIgnoreCase("titre")) {
                String titre = ComboVal.getValue();
                findbyITitre(titre);
            } else {
                AlertTypeShow.showAlertError("Choisit un critere");
            }

        }
    }
    ContextMenu contextMenu = new ContextMenu(menuItem1, menuItem2, menuItem3);

    public void findbyIdLivre(int id) {
        LivreBd livreBd = new LivreBd();
        ObservableList<Livre> livres = livreBd.getallListOb();
        ObservableList<Livre> livres2 = FXCollections.observableArrayList();;
        for (Livre livre : livres) {
            if (livre.getId() == id) {
                livres2.add(livre);
            }
        }
        viewLivre.setItems(null);
        viewLivre.setItems(livres2);
    }

    public void findbyIdAuteur(int id) {
        LivreBd livreBd = new LivreBd();
        ObservableList<Livre> livres = livreBd.getallListOb();
        ObservableList<Livre> livres2 = FXCollections.observableArrayList();;
        for (Livre livre : livres) {
            if (livre.getId_auteur() == id) {
                livres2.add(livre);
            }
        }
        viewLivre.setItems(null);
        viewLivre.setItems(livres2);
    }

    public void findbyITitre(String titre) {
        LivreBd livreBd = new LivreBd();
        ObservableList<Livre> livres = livreBd.getallListOb();
        ObservableList<Livre> livres2 = FXCollections.observableArrayList();;
        for (Livre livre : livres) {
            if (livre.getTitre().equalsIgnoreCase(titre)) {
                livres2.add(livre);
            }
        }
        viewLivre.setItems(null);
        viewLivre.setItems(livres2);
    }

    public void remplir() {

    }

    public void IdentifierBtnConnecter(String str) {
        Btnclicker.setText(str);

    }

    @FXML
    private void remplir2(ActionEvent event) {
        LivreBd livreBd = new LivreBd();
        List<Livre> livres = livreBd.getAll();

        if (comboBoxCh.getValue().equalsIgnoreCase("id_Livre")) {
            aide1Livre();
        } else if (comboBoxCh.getValue().equalsIgnoreCase("id_Auteur")) {

            aide2Livre();
        } else if (comboBoxCh.getValue().equalsIgnoreCase("titre")) {
            aide3Livre();
        }
    }

    public void aide1Livre() {
        LivreBd livreBd = new LivreBd();
        List<Livre> livres = livreBd.getAll();
        ComboVal.getItems().clear();
        for (Livre livre : livres) {

            ComboVal.getItems().add((Integer.toString(livre.getId())));
        }
    }

    public void aide2Livre() {
        LivreBd livreBd = new LivreBd();
        List<Livre> livres = livreBd.getAll();
        ComboVal.getItems().clear();
        for (Livre livre : livres) {
            // ComboVal.getItems().add((Integer.toString(livre.getId_auteur())));
            if (!ComboVal.getItems().contains(Integer.toString(livre.getId_auteur()))) {
                ComboVal.getItems().add((Integer.toString(livre.getId_auteur())));
            }
        }
    }

    public void aide3Livre() {
        LivreBd livreBd = new LivreBd();
        List<Livre> livres = livreBd.getAll();
        ComboVal.getItems().clear();
        for (Livre livre : livres) {
            ComboVal.getItems().add(livre.getTitre());
        }
    }

    public boolean remplirTableView() {
        LivreBd livreBd = new LivreBd();
        livres1 = livreBd.getallListOb();
        idColone.setCellValueFactory(new PropertyValueFactory<Livre, Integer>("id"));
        isbnColon.setCellValueFactory(new PropertyValueFactory<Livre, String>("Isbn"));
        titreColon.setCellValueFactory(new PropertyValueFactory<Livre, String>("titre"));
        id_aut_Colon.setCellValueFactory(new PropertyValueFactory<Livre, Integer>("id_auteur"));
        nbExemColone.setCellValueFactory(new PropertyValueFactory<Livre, Integer>("Nbexemp"));
        coloneEtat.setCellValueFactory(new PropertyValueFactory<Livre, String>("etat"));
        colLong.setCellValueFactory(new PropertyValueFactory<Livre, String>("longue"));

        viewLivre.setItems(livres1);
        return true;
    }

    @FXML
    private void ajouterLivre(ActionEvent event) throws IOException {
        Stage window1 = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AjouterLivree.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 725, 589);
        // AjouterLivreeController ajouterLivreeController=loader.getController();
        // Button button= new Button("click here");
        //  scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
        window1.setScene(scene);
        window1.setOnCloseRequest(e -> remplirTableView());
        window1.setTitle("Ajoute une Nouvelle Livre");
        Image img = new Image("image/iconBib.png");
        window1.getIcons().add(img);
        window1.show();

    }

    @FXML
    private void DeleteLivre(ActionEvent event) {
        Livre livre = viewLivre.getSelectionModel().getSelectedItem();
        if (livre == null) {
            AlertTypeShow.showAlertError("Aucun livre selectione");
        } else {
            System.out.println("delete");
        }
    }

    @FXML
    private void updateLivre(ActionEvent event) {
    }

    @FXML
    private void DetailsLivre(ActionEvent event) {
    }
}
