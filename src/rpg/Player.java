/********************************************

 Assignment 1: text-based RPG - Player Class
 Author: Davin Evans s3409988

 *********************************************/

package rpg;

import rpg.Items.*;
import java.util.List;
import java.util.ArrayList;

public class Player {

    private Room currentRoom;
    private int gold;
    private List<Item> inventory;

    public Player(Room room){
        setCurrentRoom(room);
        inventory = new ArrayList<>();
        gold = 0;
    }

    // set the player's current room
    public Room getCurrentRoom(){
        return currentRoom;
    }

    // return the player's current room
    public void setCurrentRoom(Room currentRoom){
        this.currentRoom = currentRoom;
    }

    // give the player a certain item
    public void giveItem(Item item) {
        inventory.add(item);
    }

    // determine whether player has a certain key
    public boolean has(KeyType keyType){
        for(Item item : inventory){
            if(item.getType().equals(ItemType.KEY) && ((KeyItem)item).getKeyType().equals(keyType)){
                System.out.println("This door was locked but you have the key!");
                return true;
            }
        }
        return false;
    }

    // return the amount of gold the player has
    public int getGold() {
        return gold;
    }

    // give gold to the player
    public void giveGold(int amount) {
        gold += amount;
    }

    // remove gold from the player
    public boolean takeGold(int cost) {
        if(cost > gold) {
            return false;
        }else{
            gold -= cost;
            return true;
        }
    }
}
