/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelBd;

import Model.Auteur;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static modelBd.UserBd.con;

/**
 *
 * @author yassine
 */
public class AuteurBd {

    static Connection con = null;

    public static Connection getconnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/gestion_bibliotheque1?characterEncoding=latin1";
           con = DriverManager.getConnection(url, "root", "");
            System.out.println("connected");
        } catch (Exception e) {
            System.out.println("walo am3lam");
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
        }
        return con;
    }

    public static List<Auteur> getAll() {
        List<Auteur> autrs = new ArrayList<Auteur>();
        try {
            String sql = "select * from auteur";
            Connection con = AuteurBd.getconnection();
            PreparedStatement pr = (PreparedStatement) con.prepareStatement(sql);
            ResultSet re = pr.executeQuery();
            while (re.next()) {
                Auteur aut = new Auteur();
                aut.setId(re.getInt(1));
                aut.setNom(re.getString(2));
                aut.setPrenom(re.getString(3));
                aut.setPays(re.getString(4));
                autrs.add(aut);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());

        }
        return autrs;

    }

    public ObservableList<Auteur> getallListOb() {
        ObservableList<Auteur> autrs = FXCollections.observableArrayList();
        try {
            String sql = "select * from auteur";
            Connection con = AuteurBd.getconnection();
            PreparedStatement pr = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {

                //livrese.add(new Livres(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6), rs.getString(7)));
                autrs.add(new Auteur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));

            }
            con.close();
        } catch (Exception e) {

            System.out.println(e.getLocalizedMessage());
        }
        return autrs;

    }

    public static int saveAuteur(Auteur auteur) {
        int rep = 0;
        try {
            String sql = "Insert into auteur (nom,prenom,pays) Values(?,?,?)";
            Connection con = AuteurBd.getconnection();
            PreparedStatement pr = (PreparedStatement) con.prepareStatement(sql);
            pr.setString(1, auteur.getNom());
            pr.setString(2, auteur.getPrenom());
            pr.setString(3, auteur.getPays());
            rep = pr.executeUpdate();
            con.close();

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return rep;
    }

    public Auteur findById(long id) {
        List<Auteur> auteurs = getAll();
        for (Auteur auteur_1 : auteurs) {
            if (auteur_1.getId() == id) {
                return auteur_1;
            }
        }
        return null;

    }

}
