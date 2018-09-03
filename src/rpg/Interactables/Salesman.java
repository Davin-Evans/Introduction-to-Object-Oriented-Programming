/********************************************

 Assignment 1: text-based RPG - Salesman Class
 Author: Davin Evans s3409988

 *********************************************/

package rpg.Interactables;

import rpg.Choices;
import rpg.Items.Item;
import rpg.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Salesman extends NPC{

    private List<Item> items;
    private Choices greeting;

    public Salesman(String description) {
        super(description);
        items = new ArrayList<>();
        greeting = new Choices("Got some rare things on sale, stranger!")
                .addChoice("I'm alright, thanks.")
                .addChoice("Tell me more.");
    }

    // add some items for the salesman to sell
    public NPC addItems(Item[] items) {
        this.items.addAll(Arrays.asList(items));
        return this;
    }

    // call to have the player interact
    @Override
    public void interact(Player player) {
        // if the player chooses "No"
        if (greeting.print() == 0) {
            System.out.println("Fair enough then...");
        }
        // if the player chooses "Yes"
        else {
            int c = 0;
            boolean b = false;
            System.out.println("What're ya buyin'? (-1 : nothing)");
            while (c >= 0 && c < items.size()) {
                for (int i = 0; i < items.size(); i++) {
                    // need to get getDescription() working...
                    System.out.println("(" + i + ") " +" for " + items.get(i).getCost() + " Gold.");
                }
                Choices choice = new Choices("test");
                c = choice.getInput();
                // return if invalid input
                if (c < 0 || c >= items.size()) {
                    if (b) {
                        System.out.println("Heh heh heh... Thank you!");
                    } else {
                        System.out.println("I hate this job.");
                    }
                    return;
                }
                if (player.getGold() < items.get(c).getCost()) {
                    System.out.println("Not enough cash, stranger!");
                    continue;
                }
                b = true;
                player.giveItem(items.get(c));
                player.takeGold(items.get(c).getCost());
                System.out.println(" . \n has been added to your inventory. " +
                        "\n you now have " + player.getGold() + "gold." +
                        "\n ."); // need to get getDescription() working...
                System.out.println("Is that all, stranger? (-1 : nothing)");
            }
        }
    }
}
