/********************************************

 Assignment 1: text-based RPG - Locked Door Class
 Author: Davin Evans s3409988

 *********************************************/

package rpg.Interactables;

import rpg.Room;
import rpg.Player;

import rpg.Items.KeyType;
import rpg.Interactables.Door;

public class LockedDoor extends Door {

    private Boolean locked; // is the door locked or not?
    private KeyType keyType;

    public LockedDoor(String description, Room room, Boolean locked, KeyType keyType) {
        super(description, room); // room is the room the door leads to
        this.locked = locked;
        this.keyType = keyType;
    }

    // unlock the door
    public void unlock(){
        locked = false;
    }

    // lock the door
    public void lock(){
        locked = true;
    }

    // inspect the door
    @Override
    public void inspect(){
        System.out.print(getDescription());
    }

    // if the door is unlocked, travel through - if not return
    @Override
    public void interact(Player player){
        if(locked) {
            if (!player.has(keyType)) {
                System.out.println("This door appears to be locked.");
                System.out.println("Maybe you can find a key...");
            } else {
                goThroughDoor(player);
            }
        }
        else{
            goThroughDoor(player);
            lock();
        }
    }
}
