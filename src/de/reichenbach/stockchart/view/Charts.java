/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.reichenbach.stockchart.view;

import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author rreichenbach
 */
public class Charts {
    
    private LineChart<Number,Number> lineChart;
  
    public BorderPane create() {
        // X/Y Achse --------------------------------
        
        
      
        final NumberAxis yAxis = new NumberAxis();
        final NumberAxis xAxis = new NumberAxis();
        // -------------------------------------------
        xAxis.setLabel("Number of Month");
        this.lineChart = new LineChart<Number,Number>(xAxis,yAxis);
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        lineChart.getData().add(series);
        // erzeuge BorderPane und füge Chart hinzu--------------------------
        BorderPane pane = new BorderPane();
        pane.setCenter(lineChart);

        return pane;
        
    }

    public LineChart<Number, Number> getLineChart() {
        return lineChart;
    }
}
