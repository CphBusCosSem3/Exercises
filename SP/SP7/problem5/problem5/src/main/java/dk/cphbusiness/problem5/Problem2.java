/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.problem5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * This will (sometimes) throw a runtime exception. Can you find the problem 
 * without running the code? What was the problem?
 * @author jens
 */
public class Problem2 {
    
    private List<Integer> myList = new ArrayList<>();

    public Problem2() {
        myList.addAll(Arrays.asList(4, 10, 28, 3, 29, 17, 3, 10));
    }
    
    private void removeLastElement() {
        final Iterator<Integer> iterator = myList.iterator();
        while(iterator.hasNext()) {
            // Wait until last element
            iterator.next();
        }
        iterator.remove();
    }
    
    public static void main(String[] args) throws InterruptedException {
        Problem2 fixMe = new Problem2();
        Runnable runnable = () -> fixMe.removeLastElement();
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        Thread t4 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }
    
}