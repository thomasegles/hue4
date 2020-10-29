/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsp1;

/**
 *
 * @author Thomas
 */
public class Main {

    public static void main(String[] args) {
        Input inpt = new Input();
        inpt.readCSV();
        inpt.numbers.forEach((number) -> {
            System.out.print(number + ";");
        });
    }

}
