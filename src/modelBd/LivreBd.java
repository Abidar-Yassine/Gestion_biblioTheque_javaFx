/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelBd;

import Model.Livre;
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
public class LivreBd {

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

    public static int saveLivre(Livre livre) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int rep = 0;
        try {
            String sql = "Insert into livres(Isbn,titre,id_auteur,longue,Nbexemp) Values(?,?,?,?,?)";
            Connection con = LivreBd.getconnection();
//            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            //preparedStatement2.setString(1,livre.getISBN());
            ps.setString(1, livre.getIsbn());
            ps.setString(2, livre.getTitre());
            ps.setString(4, livre.getLongue());
            ps.setInt(3, livre.getId_auteur());
            ps.setInt(5, livre.getNbexemp());
            rep = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return rep;
    }

    public List<Livre> getAll() {
        List<Livre> livreses = new ArrayList<Livre>();
        try {
            String sql = "select * from livres";
            Connection con = LivreBd.getconnection();
//            PreparedStatement pr = (PreparedStatement) con.prepareStatement(sql);
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            while (re.next()) {
                Livre livres = new Livre();
                livres.setId(re.getInt(1));
                livres.setIsbn(re.getString(2));
                livres.setTitre(re.getString(3));
                livres.setId_auteur(re.getInt(5));
                livres.setLongue(re.getString(4));
                livres.setNbexemp(re.getInt(6));
                livres.setEtat(re.getString(7));
                livreses.add(livres);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());

        }
        return livreses;

    }

    public ObservableList<Livre> getallListOb() {
        ObservableList<Livre> livrese = FXCollections.observableArrayList();
        try {
            String sql = "select * from livres";
            Connection con = LivreBd.getconnection();
//             PreparedStatement pr = (PreparedStatement) con.prepareStatement(sql);
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            while (re.next()) {
                //livrese.add(new Livres(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getString(7)));
                livrese.add(new Livre(re.getInt(1), re.getString(2), re.getString(3), re.getInt(4), re.getInt(6), re.getString(7), re.getString(5)));
                

            }
            con.close();
        } catch (Exception e) {

            System.out.println(e.getLocalizedMessage());
        }
        return livrese;

    }

    public Livre findByid(long id) {
        List<Livre> list = getAll();
        for (Livre livres : list) {
            if (livres.getId() == id) {
                return livres;
            }
        }
        return null;
    }

}
