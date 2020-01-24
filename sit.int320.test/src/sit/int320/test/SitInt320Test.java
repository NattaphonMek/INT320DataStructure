/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.int320.test;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author int320
 */
public class SitInt320Test {

    /**
     * @param args the command line arguments
     */
    public static class CocktailSort {

        void cocktailSort(int a[]) {
            boolean swapped = true;
            int start = 0;
            int end = a.length;

            while (swapped == true) {
                // reset the swapped flag on entering the 
                // loop, because it might be true from a 
                // previous iteration. 
                swapped = false;

                // loop from bottom to top same as 
                // the bubble sort 
                for (int i = start; i < end - 1; ++i) {
                    if (a[i] > a[i + 1]) {
                        int temp = a[i];
                        a[i] = a[i + 1];
                        a[i + 1] = temp;
                        swapped = true;
                    }
                }

                // if nothing moved, then array is sorted. 
                if (swapped == false) {
                    break;
                }

                // otherwise, reset the swapped flag so that it 
                // can be used in the next stage 
                swapped = false;

                // move the end point back by one, because 
                // item at the end is in its rightful spot 
                end = end - 1;

                // from top to bottom, doing the 
                // same comparison as in the previous stage 
                for (int i = end - 1; i >= start; i--) {
                    if (a[i] > a[i + 1]) {
                        int temp = a[i];
                        a[i] = a[i + 1];
                        a[i + 1] = temp;
                        swapped = true;
                    }
                }

                // increase the starting point, because 
                // the last stage would have moved the next 
                // smallest number to its rightful spot. 
                start = start + 1;
            }
        }

        /* Prints the array */
        void printArray(int a[]) {
            int n = a.length;
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter input");
        int input = myObj.nextInt();
        System.out.println("input is: " + input);
        int max = 50;
        int min = 10;
//        
        int[] a = new int[input];
        for (int i = 0; i < input; i++) {
////            int rand = (int) Math.random()*10; 
////            System.out.println(Math.random()*10);   

            Random r = new Random();
            //System.out.println(r.nextInt(((max - min)+1)+min));
            a[i] = r.nextInt(((max - min)+1)+min);
        }
        System.out.println(Arrays.toString(a));
        
        
        
        System.out.println("-----------------------------------------");
        System.out.println("Arrays.Sorted"); 
        long start = System.nanoTime();
        Arrays.sort(a);
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println(start + "\n" + finish + "\n" + timeElapsed);
        
        System.out.println("-----------------------------------------");
        System.out.println("Cockatiel Sorted"); 
        long startt = System.nanoTime();
        CocktailSort ob = new CocktailSort(); 
        ob.cocktailSort(a); 
//        ob.printArray(a); 
        long finishh = System.nanoTime();
        long timeElapsedd = finishh - startt;
        System.out.println(startt + "\n" + finishh + "\n" + timeElapsedd);
        System.out.println("-----------------------------------------");
    }

}
