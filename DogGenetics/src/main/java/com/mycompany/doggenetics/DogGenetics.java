
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author raymondtam
 */
public class DogGenetics {
    
//    public void DogBreedAnalyse(Map<Integer,String> Breeds){
//        System.out.println(Breeds.get(1));
//    }
    
    // tried to pass a hash map into the method above (see line 46), could not figure it out for now.
    
    public static void main(String[] args) {
                Scanner myScanner = new Scanner(System.in);
                Map<Integer,String> dogBreeds = new HashMap<Integer,String>();
                int totalPerc=100;
                int currentBreed;
                int max=10; //tried to set it to hash map size but it was not working. Need to do more research
                int min=1;
                int range = max - min +1;
                int randomNum;
          
                
                dogBreeds.put(1, "Rottweiler");
                dogBreeds.put(2, "Dachshund");
                dogBreeds.put(3, "Poodle");
                dogBreeds.put(4, "Bulldog");
                dogBreeds.put(5, "Pomeranian");
                dogBreeds.put(6, "Akbash");
                dogBreeds.put(7,"Akita");
                dogBreeds.put(8,"Afador");
                dogBreeds.put(9,"Old English Sheepdog");
                dogBreeds.put(10, "Otterhound");
                
//              DogBreedAnalyse(dogBreeds);
                System.out.println("What is your dog's name?");
                
                String dogName = myScanner.nextLine();
                
                System.out.println("Well then, I have this highly reliable report on" + " "+ dogName + "'s" + " " + "prestigious background right here.");
                
                System.out.println(dogName + " is:");
                
//                 for generating a random number from 1-100
                int maxPerc=100;
                int minPerc=1;
                int rangePerc = maxPerc-minPerc+1;
                int randPerc;
               
                int successfulTries=0;
                int total = 100;
                Random rand = new Random();
         
                
                while(successfulTries<5){
                    randomNum=(int)(Math.random()*range)+min;

                    if(dogBreeds.get(randomNum)!=null){ //removing a breed from the hashmap everytime it is called. So i need to make sure if randomNum generate a duplicate number that has already been called, run again.
                        randPerc = (int)(Math.random()*rangePerc)+min;
                        int check = total-randPerc;
//                        System.out.println(check);
                        if(successfulTries!=4 && check<5){
                        // making sure everything beside the last breed does not have a percentage that will cause the total to drop to 5 or lower
                            continue;
                        }
                        else{
                            if(successfulTries==4){ //if this is the last loop just give the last remaining percentages to the last breed
                                System.out.println(total+"%"+" "+dogBreeds.get(randomNum));
                                successfulTries++;
                            }
                            else{
                                total-=randPerc;
                                System.out.println(randPerc+"%"+" "+dogBreeds.get(randomNum));
                                dogBreeds.remove(randomNum);
                                successfulTries++;
                            }
                        
                        }
                        
                    }
                    else{
                        continue;
                    }
                   
                }
                
            
           System.out.println("Wow, that's QUITE the dog!");
    }
    
    
}
