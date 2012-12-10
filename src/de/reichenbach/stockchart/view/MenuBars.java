/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.reichenbach.stockchart.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;


/**
 *
 * @author rreichenbach
 */
public class MenuBars {
    
    private static final String CSS_MENU = "menubar";
    
    private static final String FILE = "Datei";
    private static final String EDIT = "Bearbeiten";
    private static final String INFO = "Info";
    
    // ITEMS Datei
    private static final String NEWSTOCK    = "Neue Aktie";
    private static final String DELETESTOCK = "Neue Aktie";
    private static final String EXIT        = "Beenden";
    
    private MenuBar menuBar;
    private Menu file;
    private Menu edit;
    private Menu info;
    private MenuItem newStock;
    private MenuItem deleteStock;
    private MenuItem exit;
    
    public MenuBars(){
        createMenu();
    }
    
    /**
     * erzeuge die Menübar, mit den dazugehörigen Menü-Einträgen
     */
    private void createMenu() {
        menuBar = new MenuBar();
        menuBar.setId("menubars");
        file          = new Menu(FILE);
        edit          = new Menu(EDIT);
        info          = new Menu(INFO);
        
        newStock      = new MenuItem(NEWSTOCK);
        deleteStock   = new MenuItem(DELETESTOCK);
        this.exit     = new MenuItem(EXIT);
        
        
        menuBar.getMenus().addAll(file, edit, info);
        // erzeuge Item fuer den Punkt Datei
        file.getItems().add(newStock);
        file.getItems().add(deleteStock);
        file.getItems().add(exit);

        // set event handler
        
        exit.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent t) {
          System.exit(0);
        }
        });
    }
  public MenuBar getMenuBar() {
        return menuBar;
    }
}
