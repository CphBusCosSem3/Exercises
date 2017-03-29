/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.problem5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This will never reach the code in the getNumber method. Can you find the
 * problem without running the code? What was the problem?
 *
 * @author jens
 */
public class Problem3 {

    private static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        EXECUTOR.submit(getRunnable());
        EXECUTOR.shutdown();
    }

    private static Runnable getRunnable() {
        return () -> {
            try {
                Callable<Integer> task = getCallable();

                Future<Integer> taskFuture = EXECUTOR.submit(task);

                System.out.println(taskFuture.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        };
    }

    private static Callable<Integer> getCallable() {
        return () -> {
            return getNumber();
        };
    }

    private static Integer getNumber() {
        try {
            Thread.sleep(2000);
            return 10;
        } catch (InterruptedException e) {
            return getNumber();
        }
    }

}
