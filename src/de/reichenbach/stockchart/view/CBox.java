/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.reichenbach.stockchart.view;

import javafx.scene.control.CheckBox;

/**
 *
 * @author rreichenbach
 */
public class CBox extends CheckBox {
    private String name;
    public CBox(String name) {
        super(name);
        this.name = name;
    }
    
    
}
