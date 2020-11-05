/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsp2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thomas
 */
public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("n> ");
        int userNumb = Integer.parseInt(s.nextLine());
        int from = 0;
        int to = from + 100;
        MyCallable[] addCallables = new MyCallable[(int) userNumb / 100 + 1];
        for (int i = 0; i < (int) userNumb / 100 + 1; i++) {
            addCallables[i] = new MyCallable(from, to);
            from = to + 1;
            if (i != (int) userNumb / 100) {
                to = from + 99;
            } else {
                to = userNumb;
            }
        }
        final ExecutorService pool = Executors.newCachedThreadPool();
        final List<? extends Callable<Integer>> callables = Arrays.asList(addCallables);
        int finalNumb = 0;
        try {
            for (final Future<Integer> future : pool.invokeAll(callables)) {
                finalNumb = +future.get();
            }
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        pool.shutdown();
        System.out.println("Sum:" + finalNumb);
    }
}
