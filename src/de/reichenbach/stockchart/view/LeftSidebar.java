/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.reichenbach.stockchart.view;

import de.reichenbach.stockchart.controller.LeftSideBarController;
import de.reichenbach.stockchart.model.Stock;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author rreichenbach
 */
public class LeftSidebar {
   
   private static final String CSS_CB  =     "-fx-font-size: 14;"
                                            + "-fx-font-weight:bold;"
                                            + "-fx-border-style: none;"
                                            + "-fx-padding: 5";
   
   private static final String CSS_HD  =      "-fx-font-size: 16;"
                                            + "-fx-font-weight:bold;";
   
  private LeftSideBarController controller;
  private Charts chart;
  private CheckBox[] cbs;
  private Stock stock;

   public LeftSidebar(Charts chart) {
       
       this.chart       = chart;
       this.stock       = new Stock();
       this.controller  = new LeftSideBarController(this.chart);
       this.cbs  = new CheckBox[this.stock.getSizeEntries()];
       
       
   }
    
   public VBox create() {
       
       VBox vboxStock = new VBox();
        vboxStock.setStyle(
            "-fx-background-color: linear-gradient(to bottom, gray, gray);"
           +"-fx-padding: 20 0 0 0 ");
       
       Text header = new Text("Aktien");
       header.setStyle(CSS_HD);
       vboxStock.getChildren().add(header);
       
       for(int i=0;i<stock.getSizeEntries();i++) {    
           CheckBox check = new CheckBox(controller.getEntries()[i]); 
           check.setStyle(CSS_CB);
           check.setId(controller.getEntries()[i]);
           //check.setIndeterminate(true);
           //check.setAllowIndeterminate(true);
           
           check.selectedProperty().addListener(new ChangeListener<Boolean>() {
           
           @Override
           public void changed(ObservableValue<? extends Boolean> ov,
              Boolean old_val, Boolean new_val) {
               if(new_val == true) {
                    addStock();
               }
                else {
                   cancelStock();
                }
             }
           });
           
           cbs[i] = check;
          vboxStock.getChildren().add(check);
       }
        return vboxStock;
  }
   
   private void cancelStock() {
        CheckBox select = controller.findDisableCheckbox(this.cbs);
        if(select != null) {
          controller.cancelStock(select.getId()); 
        }
   }   
   
   private void addStock() {
        CheckBox select = controller.findSelectCheckbox(this.cbs);
        if(select != null) {
          controller.addStock(select.getId());
    }
  }
}
