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
public class Auteur {
    private int id;
    private String nom;
    private String prenom;
    private String pays;

    public int getId() {
        return id;
    }

    public Auteur(int id, String nom, String prenom, String pays) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.pays = pays;
    }

    public Auteur() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
    
    
    
}
