
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author raymondtam
 */
public class HealthyHearts {
 
//        
    public static void main(String[] args) {
           boolean ageConditions = true;
            while (ageConditions == true) { //loop is to make sure age of negative cannot be applied

                Scanner myScanner = new Scanner(System.in);
                System.out.println("What is your age?");
                String age = myScanner.nextLine();
                int intAge = Integer.parseInt(age); //will stop the program if a non number is applied
                if (intAge > -1 ) {
                   System.out.println(intAge);
                   int maxHeart = 220-intAge; 
                   System.out.println("Your maximum heart rate should be "+maxHeart+" beats per minute");
                   int hrZoneMin=maxHeart/2; // 50% of max heart rate
                   int hrZoneMax=(maxHeart*85)/100; // 85% of max heart rate
                   System.out.println("Your target HR Zone is " + hrZoneMin + " - " + hrZoneMax +" beats per minute" );
                   ageConditions = false;  //stops the loop
                    
                } else {
                    System.out.println("Please choose a valid number!"); // make user redo the loop if number is negative
                }
            }
            
            
        }
}
