/********************************************

 Assignment 1: text-based RPG - NPC Class
 Author: Davin Evans s3409988

 *********************************************/

package rpg.Interactables;

import rpg.Interactable;
import rpg.Inspectable;
import rpg.Player;

public abstract class NPC extends Inspectable implements Interactable {

    // description of the NPC
    public NPC(String description) {
        super(description);
    }

    // called when a player interacts with the NPC
    @Override
    public abstract void interact(Player player);
}
