/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javafx.scene.control.Alert;

/**
 *
 * @author yassine
 */
public class AlertTypeShow {

    public static void showAlertInfor(String contex) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(contex);
        alert.showAndWait();
    }
     public static void showAlertError(String contex) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(contex);
        alert.showAndWait();
    }
     public static void showAlertWarning(String contex) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(contex);
        alert.showAndWait();
    }
}
