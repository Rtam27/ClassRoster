/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.summativesums;

/**
 *
 * @author raymondtam
 */
public class SummativeSums {

    public static int sum(int[] array) {
        int total = 0;
        System.out.println(array);
        for (int i = 0; i < array.length; i++) { //loops through the whole array and add each index to total and returns total
            total += array[i];
        }
        return total;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 90, -33, -55, 67, -16, 28, -55, 15};
        int[] array2 = {999, -60, -77, 14, 160, 301};
        int[] array3 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130,
            140, 150, 160, 170, 180, 190, 200, -99};

        int total = sum(array3); //change arrays to find the sum
        System.out.println("Array Sum: " + total);
    }

}
