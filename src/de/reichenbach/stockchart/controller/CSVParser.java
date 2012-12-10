/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csvreader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rreichenbach
 */
public class CSVParser {
    private static final String DELIMITER = ",";
    
    
    private String  date;
    private double  openCourse;
    private double  highCourse;
    private double  lowCourse;
    private double  clouseCourse;
    private double  volume;
    private double  adj;
    private double  closeCourse;
    
    
    String filename;
    private BufferedReader reader;
    private ArrayList<String> rows; 
    
    
    
    
    public CSVParser(String filename) {
        this.filename = filename;
        rows = new ArrayList<String>();
        readFile();
        parseCSV();
    
    }
    
    
    private void openFile() {
        try {
            
             File datei = new File("table.csv");
             System.out.println(datei.getAbsolutePath());
            this.reader = new BufferedReader(new FileReader(datei));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSVParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private ArrayList<String> readFile() {
        openFile();
        String row = null;
        try {
            while((row = reader.readLine()) != null) {
                rows.add(row);
            }
        } catch (IOException ex) {
            Logger.getLogger(CSVParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.rows;    
    }
    
    public String[][] parseCSV() {
        String[][] csvArray = new String [this.rows.size()][];
        for(int i=0;i<this.rows.size();i++) {
          String[] a = this.rows.get(i).split(DELIMITER);
          
          for(int j =0;j<a.length;j++) {
            switch(j) {
              case 0: ;
                
            };
            
            System.out.print(a[j]);
          }
            System.out.println(); 
        }
    
        return null;
    }
    
    
    
    
    
    
    
}
