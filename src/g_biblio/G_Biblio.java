/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g_biblio;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author yassine
 */
public class G_Biblio extends Application {
     
   @Override
    public void start(Stage primaryStage) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            System.out.println(getClass());
            fxmlLoader.setLocation(getClass().getResource("/view/ethentification.fxml"));
            AnchorPane ancr = fxmlLoader.load();
            Scene scene = new Scene(ancr);
            //Stage stage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setTitle("Gestion Bibliotheque");
            primaryStage.show();
            primaryStage.setOnCloseRequest(e -> {
                Platform.exit();
            });
            Image img=new Image("image/iconBib.png");
            primaryStage.getIcons().add(img);

          //  stage.getIcons().add(new Image("/image/save.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
