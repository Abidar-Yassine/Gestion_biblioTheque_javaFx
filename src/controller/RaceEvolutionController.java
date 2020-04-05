/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class RaceEvolutionController implements Initializable {

    @FXML
    private JFXComboBox<String> BeefType;
    @FXML
    private JFXComboBox<String> evolution;
    @FXML
    private BarChart<String, Integer> A3mida;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;
    @FXML
    private AreaChart<String, Integer> mon7ana;
    @FXML
    private NumberAxis y1;
    @FXML
    private CategoryAxis x1;
    @FXML
    private PieChart da2ira;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadData();
        BeefType.getItems().addAll("type1","type2","type3");
        evolution.getItems().addAll("Evolution Global de la race","Evolution specifier");
    }

    public void loadData() {
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
        list.add(new PieChart.Data("ITALY", 5000));
        list.add(new PieChart.Data("Maroc", 4000));
        list.add(new PieChart.Data("USA", 1000));
        list.add(new PieChart.Data("CHINA", 8000));
        da2ira.setData(list);
        XYChart.Series series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("ITALY", 5000));
        series.getData().add(new XYChart.Data<>("Maroc", 4000));
        series.getData().add(new XYChart.Data<>("USA", 1000));
        series.getData().add(new XYChart.Data<>("CHINA", 8000));
        A3mida.getData().addAll(series);
        XYChart.Series series1 = new XYChart.Series<>();
        series1.getData().add(new XYChart.Data<>("CHINA", 8000));
        series1.getData().add(new XYChart.Data<>("USA", 1000));
        series1.getData().add(new XYChart.Data<>("Maroc", 4000));
        series.getData().add(new XYChart.Data<>("ITALY", 5000));
        mon7ana.getData().addAll(series1);
    }

}
