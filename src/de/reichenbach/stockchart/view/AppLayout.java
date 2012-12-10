/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.reichenbach.stockchart.view;

import de.reichenbach.stockchart.app.StockChart;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author rreichenbach
 */
public class AppLayout extends AbstractLayout {
    
    private Stage stage;
    private BorderPane borderPane;
    private Charts chart;
    
    public AppLayout(Stage stage) {
        this.stage = stage;
    }
    
    public void createLayout() {
        // set tilte
        this.stage.setTitle("StockChart 0.1 alpha - R. Reichenbach");
        // init variables
        this.borderPane         = new BorderPane();
        Scene scene             = new Scene(borderPane, 1024, 768);
        // set borderpane layout
        borderPane.setId("appContainer");
        stage.setScene(scene);
        // create all components
        createMenuBar();
        cretateChart();
        cretateLeftSideBar();
        // show all components
        stage.show();
    }

    @Override
    protected void createMenuBar() {
        VBox hBoxTop = new VBox();
        hBoxTop.getChildren().add(new MenuBars().getMenuBar());
        this.borderPane.setTop(hBoxTop);
    }

    @Override
    protected void cretateChart() {
        this.chart = new Charts();
        BorderPane chartDraw = this.chart.create();
        chartDraw.setId("bla");
        this.borderPane.setCenter(chartDraw);
    }

    @Override
    protected void cretateLeftSideBar() {
        VBox ld = new LeftSidebar(this.chart).create();
        ld.setId("bla");
        
        this.borderPane.setLeft(ld);
    }     
}
