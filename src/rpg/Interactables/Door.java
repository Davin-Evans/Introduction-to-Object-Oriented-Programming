 /********************************************

 Assignment 1: text-based RPG - Interactables Class
 Author: Davin Evans s3409988

 *********************************************/

 package rpg.Interactables;

 import rpg.Inspectable;
 import rpg.Interactable;
 import rpg.Room;
 import rpg.Player;

public class Door extends Inspectable implements Interactable {

    // define the room that the door leads to
    private Room room;

    public Door(String description, Room room) {
        super(description);
        this.room = room;
    }

    // return the room that the door leads to
    public Room getRoom() {
        return room;
    }

    // interact with the door
    @Override
    public void interact(Player player){
        goThroughDoor(player);
    }

     public void goThroughDoor(Player player){
        System.out.print("You go through the");
        // find the correct door
        String arr[] = getDescription().split(" ");
        for(int i = 1; i < arr.length; i++){
            System.out.print(" " + arr[i]);
        }
        System.out.println(".");
        player.setCurrentRoom(getRoom());
     }
}
