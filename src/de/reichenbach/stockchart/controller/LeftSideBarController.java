/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.reichenbach.stockchart.controller;

import de.reichenbach.stockchart.model.Stock;
import de.reichenbach.stockchart.view.Charts;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.scene.chart.XYChart;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

/**
 *
 * @author rreichenbach
 */
public class LeftSideBarController {
   
   private Charts chart;
   private CheckBox[] cbs;
   private Stock stock;
   private XYChart.Series serie;
   private HashMap <String, XYChart.Series> series; 

   public LeftSideBarController(Charts chart){
       this.chart   = chart;
       this.stock   = new Stock();
       this.series  = new HashMap<String, XYChart.Series>();
   }
   
   public String[] getEntries() {
     return this.stock.getEntries();
   }
   
   public void cancelStock(String stockName) {
     
     XYChart.Series del = (XYChart.Series)  series.get(stockName);
     this.chart.getLineChart().getData().remove(del);
     series.remove(stockName);
   }
    
   public void addStock(String stockName) {
        
       if(!series.containsKey(stockName)) {
        serie = new XYChart.Series();
        serie.getData().add(new XYChart.Data(1, 23));
        serie.getData().add(new XYChart.Data(2, 14));
        serie.getData().add(new XYChart.Data(3, 15));
        serie.getData().add(new XYChart.Data(4, 24));
        serie.getData().add(new XYChart.Data(5, 34));
        serie.getData().add(new XYChart.Data(6, 36));
        serie.getData().add(new XYChart.Data(7, 22));
        serie.getData().add(new XYChart.Data(8, 45));
        serie.getData().add(new XYChart.Data(9, 43));
        serie.getData().add(new XYChart.Data(10, 17));
        serie.getData().add(new XYChart.Data(11, 29));
        serie.getData().add(new XYChart.Data(12, 25));
        
        series.put(stockName, serie);
        this.chart.getLineChart().getData().add(serie);
       }
   }
   
   public CheckBox findSelectCheckbox(CheckBox[] cbs) {
     CheckBox select  = null; 
     for(int i = 0; i< stock.getSizeEntries();i++) {
        if(cbs[i].isSelected()) {
          
          cbs[i].isDisable();
          select = cbs[i];
          break;
        }
      }
    return select;
   }
   
   public CheckBox findDisableCheckbox(CheckBox[] cbs) {
     CheckBox disable  = null; 
     for(int i = 0; i< stock.getSizeEntries();i++) {
        if(!cbs[i].isSelected() && cbs[i].isFocused()) {
          disable = cbs[i];
          break;
        }
      }
    return disable;
   }
   
   
   public void showStockWindows() {
     Stage stage = new Stage();
     
   }
   
   
   

       
       
       
       
       
   }
