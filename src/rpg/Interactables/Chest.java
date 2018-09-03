/********************************************

 Assignment 1: text-based RPG - Chest Class
 Author: Davin Evans s3409988

 *********************************************/

package rpg.Interactables;

import rpg.Inspectable;
import rpg.Interactable;
import rpg.Player;

public class Chest extends Inspectable implements Interactable{
    // implement a chest that can yield the player a random amount of money
    private int gold;
    private String locationDesc;

    public Chest(String description, String locationDesc, int gold) {
        super(description);
        this.locationDesc = locationDesc;
        this.gold = gold;
    }

    // get the location description
    // IS this right?
    protected String getLocation(){
        return locationDesc;
    }

    // interact with the player
    @Override
    public void interact(Player player){
        findGold(player);
    }

    public void findGold(Player player){
        System.out.print("You open the");
        // find the correct chest
        String arr[] = getDescription().split(" ");
        for(int i = 1; i < arr.length; i++){
            System.out.print(" " + arr[i]);
        }
        // if the chest has gold
        if(gold > 0) {
            System.out.print(" and find " + gold + " gold.\n");
            player.giveGold(gold);
            System.out.println("You now have " + player.getGold() + " gold.");
            gold = 0;  // empty the chest
        }
        // otherwise show that it is empty
        else{
            System.out.println(" but it appears to be empty.");
        }
    }

}
