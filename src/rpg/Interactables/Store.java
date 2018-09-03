/********************************************

 Assignment 1: text-based RPG - Shop Interface
 Author: Davin Evans s3409988

 *********************************************/

package rpg.Interactables;

import rpg.Items.Item;

public interface Store {
    // adds an item to the shop
    NPC addItems(Item[] items);
}
