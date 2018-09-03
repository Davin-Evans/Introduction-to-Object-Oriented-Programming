/********************************************

 Assignment 1: text-based RPG - Key Class
 Author: Davin Evans s3409988

 *********************************************/

package rpg.Items;

public class KeyItem extends Item {

    private KeyType keyType;

    public KeyItem(String description, KeyType keyType, int cost) {
        super(description, ItemType.KEY, cost);
        this.keyType = keyType;
    }

    // return which key
    public KeyType getKeyType(){
        return keyType;
    }
}
