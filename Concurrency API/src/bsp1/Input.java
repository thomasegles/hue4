/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thomas
 */
public class Input {

    ArrayList<Integer> numbers = new ArrayList();

    public void readCSV() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("numbers.csv")));
            String strNumb = br.readLine();
            while (strNumb != null) {
                checkNumb(strNumb);
                strNumb = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void checkNumb(String line) {
        String[] spltLine = line.split(":");
        for (int i = 0; i < spltLine.length; i++) {
            if (spltLine[i] != null) {
                int numb = 0;
                boolean isNumb = true;
                try {
                    numb = Integer.parseInt(spltLine[i]);
                } catch (NumberFormatException nfe) {
                    isNumb = false;
                }
                if (isNumb) {
                    numbers.add(numb);
                }
            }
        }
    }
}
