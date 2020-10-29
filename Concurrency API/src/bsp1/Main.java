/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsp1;

import java.util.Scanner;
import java.util.concurrent.Executors;

/**
 *
 * @author Thomas
 */
public class Main {

    static int dividend;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Input.readCSV();
        System.out.println("chunks>");
        int chunks = Integer.parseInt(sc.nextLine());
        System.out.println("divide>");
        dividend = Integer.parseInt(sc.nextLine());
        int addNumb = Input.numbers.size() / chunks;
        int numbFrom = 0;
        int numbTo = addNumb;
        for (int i = 0; i < chunks; i++) {
            Executors.newCachedThreadPool().submit(new MyRunnable(numbFrom, numbTo));
            numbFrom = +addNumb;
            numbTo = +addNumb - 1;
        }
    }
}
