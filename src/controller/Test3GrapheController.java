/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class Test3GrapheController implements Initializable {

    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;
    @FXML
    private BarChart<String, Integer> Barchart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         XYChart.Series series= new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("yassine", 20));
        series.getData().add(new XYChart.Data<>("Ahmed", 40));
        series.getData().add(new XYChart.Data<>("youssef", 80));
        Barchart.getData().addAll(series);
    }    
    
}
