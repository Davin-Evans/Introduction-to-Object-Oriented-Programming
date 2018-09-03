/********************************************

 Assignment 1: text-based RPG - Choices Class
 Author: Davin Evans s3409988

 *********************************************/

package rpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Choices {

    private String description; // whatever string I want to print

    private List<String> choices; // the list of all current choices

    // ask the player to make a choice
    public Choices(String description){
        this.description = description;
        choices = new ArrayList<>();
    }

    // add a choice to the list
    public Choices addChoice(String description){
        choices.add(description);
        return this;
    }

    // prints the choice list and asks for integer decision
    public int print() {
        System.out.println(description);
        for(int i = 0; i < choices.size(); i++) {
            System.out.println("(" + i + ") " + choices.get(i));
        }
        return getInput();
    }

    // takes an integer input
    public int getInput(){
        Scanner scanner = new Scanner(System.in); // build the scanner
        while(!scanner.hasNextInt()){ // Wait until we have an integer as input.
            if(scanner.hasNext()){ // disregard non-integer inputs
                scanner.next();
            }
        }
        return scanner.nextInt();  // take the input
    }
}
