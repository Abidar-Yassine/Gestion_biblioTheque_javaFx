/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelBd;

import Model.Adherent;
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
public class AdherentBd {
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

    public static List<Adherent> getAll() {
        List<Adherent> adrerens = new ArrayList<Adherent>();
        try {
            String sql = "select * from Adherent";
            Connection con = AuteurBd.getconnection();
            PreparedStatement pr = (PreparedStatement) con.prepareStatement(sql);
            ResultSet re = pr.executeQuery();
            while (re.next()) {
                Adherent adherent = new Adherent();
                adherent.setId(re.getInt(1));
                adherent.setNom(re.getString(2));
                adherent.setCode(re.getString(4));
                adherent.setEmail(re.getString(3));
                adrerens.add(adherent);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());

        }
        return adrerens;

    }

    public static ObservableList<Adherent> getallListOb() {
        ObservableList<Adherent> adherents = FXCollections.observableArrayList();
        try {
            String sql = "select * from Adherent";
            Connection con = AuteurBd.getconnection();
            PreparedStatement pr = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {

                //livrese.add(new Livres(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6), rs.getString(7)));
               // autrs.add(new Auteur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
              adherents.add(new Adherent(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(3)));
            }
            con.close();
        } catch (Exception e) {

            System.out.println(e.getLocalizedMessage());
        }
        return adherents;

    }

    public static int saveAuteur(Adherent adher) {
        int rep = 0;
        try {
            String sql = "Insert into Adherent (nom,email,code) Values(?,?,?)";
            Connection con = AuteurBd.getconnection();
            PreparedStatement pr = (PreparedStatement) con.prepareStatement(sql);
            pr.setString(1, adher.getNom());
            pr.setString(2, adher.getEmail());
            pr.setString(3, adher.getCode());
            rep = pr.executeUpdate();
            con.close();

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return rep;
    }

    public Adherent findById(long id) {
        List<Adherent> auteurs = getAll();
        for (Adherent adher : auteurs) {
            if (adher.getId() == id) {
                return adher;
            }
        }
        return null;

    }
    
}
