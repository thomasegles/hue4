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
public class MyRunnable implements Runnable {

    final int numbFrom;
    final int numbTo;
    Input inpt = new Input();

    public MyRunnable(int numbFrom, int numbTo) {
        this.numbFrom = numbFrom;
        this.numbTo = numbTo;
    }

    @Override
    public void run() {
        for (int i = numbFrom; i <= numbTo; i++) {
            if (inpt.numbers.get(i) % Main.dividend == 0) {
                System.out.println(i);
            }
        }
    }

}
