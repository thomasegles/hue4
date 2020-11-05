/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsp2;

import java.util.concurrent.Callable;

/**
 *
 * @author Thomas
 */
public class MyCallable implements Callable<Integer> {

    int from;
    int to;

    public MyCallable(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Integer call() throws Exception {
        int addNumb = 0;
        for (int i = from; i < to; i++) {
            addNumb = +i;
        }
        return addNumb;
    }

}
