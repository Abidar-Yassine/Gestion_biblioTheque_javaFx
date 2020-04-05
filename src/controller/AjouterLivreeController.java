/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Auteur;
import Model.Livre;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import modelBd.AuteurBd;
import modelBd.LivreBd;
import util.AlertTypeShow;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class AjouterLivreeController implements Initializable {

    private int id_auteur;

    @FXML
    private JFXTextField IsbnLivre;
    @FXML
    private JFXTextField titrLivre;
    @FXML
    private JFXTextField longueLiv;
    @FXML
    private JFXTextField NbexemPLLIvre;
    @FXML
    private JFXTextField nomAut;
    @FXML
    private JFXTextField prenoAut;
    @FXML
    private JFXComboBox<String> ListPays;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ListPays.getItems().addAll("Maroc", "France", "USA", "Egypt", "Algerie", "Germanie", "Lobnan", "Irac", "Autre");
    }

    public int testChamp1() {
        if (IsbnLivre.getText().isEmpty() || longueLiv.getText().isEmpty() || NbexemPLLIvre.getText().isEmpty() || titrLivre.getText().isEmpty() || ListPays.getValue().isEmpty()) {
            AlertTypeShow.showAlertError("Please Remplit Tout Les Champs");
            return -1;
            
        }else if (!isInteger(NbexemPLLIvre.getText())) {
                AlertTypeShow.showAlertError("Nombre Exemplaire doit etre un numero");
                return -2;
            }else{
            return 1;
        }

    }
     public int testChamp() {
        if (IsbnLivre.getText().isEmpty() || longueLiv.getText().isEmpty() || NbexemPLLIvre.getText().isEmpty() || titrLivre.getText().isEmpty()) {
            AlertTypeShow.showAlertError("Please Remplit Tout Les Champs");
            return -1;
            
        }else if (!isInteger(NbexemPLLIvre.getText())) {
                AlertTypeShow.showAlertError("Nombre Exemplaire doit etre un numero");
                return -2;
            }else{
            return 1;
        }

    }

    public boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @FXML
    private void saveLivre_Auteur(ActionEvent event) throws IOException {
        int rep;
        if (!test()) {
            if(testChamp()>0){
            Livre livre = new Livre();
            livre.setIsbn(IsbnLivre.getText());
            livre.setLongue(longueLiv.getText());
            livre.setNbexemp(Integer.parseInt(NbexemPLLIvre.getText()));
            livre.setTitre(titrLivre.getText());
            livre.setId_auteur(id_auteur);
            rep = LivreBd.saveLivre(livre);
            if (rep != 0) {
                AlertTypeShow.showAlertInfor("new Livre saved successfully");
            } else {
                System.out.println("some probleme dans save livre");
            }
            }else{
                //AlertTypeShow.showAlertError("Les champs sont incorect");
            }
        } else {
           if(testChamp1()>0){
            Auteur auteur = new Auteur();
            auteur.setNom(nomAut.getText());
            auteur.setPays(ListPays.getValue());
            auteur.setPrenom(prenoAut.getText());
            AuteurBd.saveAuteur(auteur);
            Livre livre = new Livre();
            livre.setIsbn(IsbnLivre.getText());
            livre.setLongue(longueLiv.getText());
            livre.setNbexemp(Integer.parseInt(NbexemPLLIvre.getText()));
            livre.setTitre(titrLivre.getText());
            livre.setId_auteur(getId(nomAut.getText()));
            LivreBd.saveLivre(livre);
            AlertTypeShow.showAlertInfor("new Livre and new Auteur Created successfully");
        }else{
               //AlertTypeShow.showAlertError("Les champs sont incorect");
           }
        }
    }

    public boolean testAuturExist() {
        List<Auteur> auteurs = AuteurBd.getAll();
        for (Auteur auteur : auteurs) {
            if (auteur.getNom().equalsIgnoreCase(nomAut.getText())) {
                id_auteur = auteur.getId();
                return true;
            }
        }
        return false;
    }

    public int getId(String nom) {
        List<Auteur> auteurs = AuteurBd.getAll();
        for (Auteur auteur : auteurs) {
            if (auteur.getNom().equalsIgnoreCase(nomAut.getText())) {
                return auteur.getId();
            }
        }
        return -1;

    }

    @FXML
    private boolean test() {
        if (!testAuturExist()) {
            // AlertTypeShow.showAlertInfor("auteur makynx");
            prenoAut.setDisable(false);
            ListPays.setDisable(false);
            return true;
        } else {
            // AlertTypeShow.showAlertInfor("auteur existe ");
            prenoAut.setDisable(true);
            ListPays.setDisable(true);
            return false;
        }

    }

}
