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
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 *
 * @author yassine
 */
public class TestGrapheController  implements Initializable{
    
    @FXML
    private AreaChart<String, Integer> Test;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        XYChart.Series series= new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("yassine", 20));
        series.getData().add(new XYChart.Data<>("Ahmed", 40));
        series.getData().add(new XYChart.Data<>("youssef", 80));
        Test.getData().addAll(series);
        
    }
}
