/********************************************

 Assignment 1: text-based RPG - Item Class
 Author: Davin Evans s3409988

 *********************************************/

package rpg.Items;

import rpg.Inspectable;
import rpg.Items.ItemType;

public abstract class Item extends Inspectable{

    private ItemType type;
    private int cost;

    public Item(String description, ItemType type, int cost) {
        super(description);
        this.type = type;
        this.cost = cost;
    }

    // return the type of item
    public ItemType getType() {
        return type;
    }

    // return the item's cost
    public int getCost() {
        return cost;
    }

}
