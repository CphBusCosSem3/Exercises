/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.problem5;

import java.util.ArrayList;
import java.util.List;

/**
 * This will (sometimes) throw a runtime exception. Can you find the problem 
 * without running the code? What was the problem?
 *
 * @author jens
 */
public class Problem1 {

    private static final int[] COUNTER = new int[]{0};
    private static final int ITERATIONS = 100000;

    public static void main(String[] args) throws InterruptedException {
        List<Runnable> runnables = new ArrayList<>();
        for (int i = 0; i < ITERATIONS; i++) {
            runnables.add(() -> {
                COUNTER[0]++;
            });
        }

        for (Runnable runnable : runnables) {
            new Thread(runnable).start();
        }

        if (COUNTER[0] != ITERATIONS) {
            throw new RuntimeException("COUNTER != " + ITERATIONS);
        }
    }

}
