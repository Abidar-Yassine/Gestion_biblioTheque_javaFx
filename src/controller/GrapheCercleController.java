/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class GrapheCercleController implements Initializable {

    @FXML
    private PieChart CercleGraphe;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadData();

    }

    public void loadData() {
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
        list.add(new PieChart.Data("ITALY", 5000));
        list.add(new PieChart.Data("Maroc", 4000));
        list.add(new PieChart.Data("USA", 1000));
        list.add(new PieChart.Data("CHINA", 9000));
        CercleGraphe.setData(list);
    }

}
