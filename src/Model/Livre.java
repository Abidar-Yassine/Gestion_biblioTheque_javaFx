/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author yassine
 */
public class Livre {
    
    private int id;
    private String Isbn;
    private String titre;
    private int id_auteur;
    private int Nbexemp;
    private String Etat;
    private String longue;

    public Livre(int id, String Isbn, String titre, int id_auteur, int nbExemplaire, String Etat, String longue) {
        this.id = id;
        this.Isbn = Isbn;
        this.titre = titre;
        this.id_auteur = id_auteur;
        this.Nbexemp = nbExemplaire;
        this.Etat = Etat;
        this.longue = longue;
    }

    public String getLongue() {
        return longue;
    }

    public void setLongue(String longue) {
        this.longue = longue;
    }
    

    public Livre() {
    }

    public Livre(String Isbn, String titre, int id_auteur, int nbExemplaire, String Etat) {
        this.Isbn = Isbn;
        this.titre = titre;
        this.id_auteur = id_auteur;
        this.Nbexemp = nbExemplaire;
        this.Etat = Etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String Isbn) {
        this.Isbn = Isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getId_auteur() {
        return id_auteur;
    }

    public void setId_auteur(int id_auteur) {
        this.id_auteur = id_auteur;
    }

    public int getNbexemp() {
        return Nbexemp;
    }

    public void setNbexemp(int Nbexemp) {
        this.Nbexemp = Nbexemp;
    }

   

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String Etat) {
        this.Etat = Etat;
    }
    
    
}
