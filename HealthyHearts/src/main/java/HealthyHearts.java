
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
            while (ageConditions == true) {

                Scanner myScanner = new Scanner(System.in);
                System.out.println("What is your age?");
                String age = myScanner.nextLine();
                int intAge = Integer.parseInt(age);
                if (intAge > -1 ) {
                   System.out.println(intAge);
                   int maxHeart = 220-intAge;
                   System.out.println("Your maximum heart rate should be "+maxHeart+" beats per minute");
                   int hrZoneMin=maxHeart/2;
                   int hrZoneMax=(maxHeart*85)/100;
                   System.out.println("Your target HR Zone is " + hrZoneMin + " - " + hrZoneMax +" beats per minute" );
                   ageConditions = false;  
                    
                } else {
                    System.out.println("Please choose a valid number!");
                }
            }
            
            
        }
}
