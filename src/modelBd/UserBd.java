/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelBd;

import Model.User;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yassine
 */
public class UserBd {

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

    public static List<User> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<User> users = new ArrayList<User>();
        try {
            String sql = "select * from users";
            Connection con = UserBd.getconnection();
            PreparedStatement pr = (PreparedStatement) con.prepareStatement(sql);
            ResultSet re = pr.executeQuery();
            while (re.next()) {
                User user = new User();
                user.setId(re.getInt(1));
                user.setUsername(re.getString(2));
                user.setEmail(re.getString(3));
                user.setPassword(re.getString(4));
                users.add(user);
            }
            con.close();

        } catch (Exception e) {

            //System.out.println("walo");
            e.getMessage();
            e.getLocalizedMessage();
        }

        return users;

    }

    /* tested**/
    public static User getUserByCode(int code) throws IOException, SQLException {
        User user = new User();
        String sql = "select * from users where id=?";
        Connection con = UserBd.getconnection();
        PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
        preparedStatement.setInt(1, code);
        ResultSet re = preparedStatement.executeQuery();
        if (re.next()) {
            user.setId(re.getInt(1));
            user.setUsername(re.getString(2));
            user.setEmail(re.getString(3));
            user.setPassword(re.getString(4));
        } else {
            return null;
        }
        con.close();
        return user;
    }

    /* tested*/

    public static int deleteUser(User user) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int st = 0;
        try {
            String sql = "delete from users where id=?";// la requte sql
            Connection con = UserBd.getconnection();// avoir la connexion
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
            preparedStatement.setDouble(1, user.getId());
            st = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.getLocalizedMessage();

        }
        return st;
    }

    /* tested*/

    public static int saveUser(User user) {
        int rep = 0;
        try {
            String sql = "Insert into users(userName,password,email) Values(?,?,?)";
            Connection con = UserBd.getconnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
            //preparedStatement2.setString(1,livre.getISBN());
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            // preparedStatement.setBinaryStream(4,(InputStream)file,100);
            rep = preparedStatement.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return rep;
    }

    /* tested*/
    public static User getById(Long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<User> users = getAll();
        for (User u : users) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public static int update(User user) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int res = 0;
        try {
            String sql = "UPDATE users set userName=?,password=?, emial=? where id=?";
            Connection con = UserBd.getconnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(2, user.getEmail());
            res = preparedStatement.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return res;

    }

    public User findByUserName(String name) {
        List<User> users = getAll();
        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(name)) {
                return u;
            }
        }
        return null;
    }

}
