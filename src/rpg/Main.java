/********************************************

 Assignment 1: text-based RPG - Main Class
 Author: Davin Evans s3409988

 *********************************************/

package rpg;

import rpg.Interactables.*;
import rpg.actions.ChoiceAction;
import rpg.Items.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    private static Boolean running; // allow termination

    /******************     Main program    *************************/
    public static void main(String[] args) {
        running = true;
        Room start = buildRooms(); // build all necessary rooms
        Player player = new Player(start); // create the player and insert in the first room
        ChoiceAction basicOptions = basicOptions();
        while (running) {
            basicOptions.call(player);
        }
    }

    private static ChoiceAction basicOptions(){
        Choices choice = new Choices("What do you want to do?")
                .addChoice("Look around")
                .addChoice("Look for a way out")
                .addChoice("Look for company")
                .addChoice("look for something to open")
                .addChoice("QuickSave")
                .addChoice("QuickLoad")
                .addChoice("Save")
                .addChoice("Load")
                .addChoice("quit");
        //return that integer.
        return new ChoiceAction(choice) {
            @Override
            public void action(int action, Player player) {
                switch(action){
                    case 0:
                        lookAround(player);
                        break;
                    case 1:
                        lookAtDoors(player);
                        break;
                    case 2:
                        lookForCompany(player);
                        break;
                    case 3:
                        lookForChests(player);
                        break;
                    case 4:
                        // turn this into QuickSave
                        running = false;
                        break;
                    case 5:
                        // turn this into QuickLoad
                        running = false;
                        break;
                    case 6:
                        // turn this into Save
                        running = false;
                        break;
                    case 7:
                        // turn this into load
                        running = false;
                        break;
                    default:
                        running = false;
                        break;
                }
            }
        };
    }

    /******************     Choice Options     *************************/
    // Look around the room - should print a room coulour and the number of doors (if any)
    private static void lookAround(Player player){
        Room room = player.getCurrentRoom(); // determine where player is
        System.out.print("You see: ");
        room.inspect(); // prints the room's description ie colour (see Inspectable superclass)
        List<Door> doors = room.getDoors(); // create a list with the doors in the room
        // provided the list is not empty, print the number of doors
        if (!doors.isEmpty()) {
            System.out.print(" with " + doors.size() + " door(s)");
        }
        else {
            System.out.print(System.lineSeparator());
        }
        // do the same for NPC's
        List<NPC> npcs = room.getNPCs();
        if(!npcs.isEmpty()){
            System.out.print(" and " + npcs.size() + " person(s)");
        }
        System.out.println(".");
        // and again for boxes
        List<Chest> chests = room.getChest();
        if(!chests.isEmpty()){
            System.out.print("There also appears to be " + chests.size() + " box(es)");
        }
        System.out.println(".");
    }

    // Observe the doors - should print a list of all doors in room with their description
    private static void lookAtDoors(Player player){
        Room room = player.getCurrentRoom(); // determine where the player is
        // check that there is at least one door
        if(room.getDoors().isEmpty()){
            System.out.println("It would appear that you are trapped!.");
            System.out.println("You scream for help.");
            return;
        }
        // print the list of doors when there are some
        System.out.println("You look around for doors and you see:");
        for(int i = 0; i < room.getDoors().size(); i++){
            System.out.print("(" + i + ") ");
            room.getDoors().get(i).inspect();
            System.out.println(".");
        }
        System.out.println("Which door do you take? (-1 : to stay here) ");
        Choices c = new Choices("test");
        int path = c.getInput();
        // choose the correct door from list or remain in place
        if(path >= room.getDoors().size() || path < 0){
            return;
        }
        room.getDoors().get(path).interact(player);
    }

    // look for NPCs
    private static void lookForCompany(Player player) {
        Room room = player.getCurrentRoom();
        if(room.getNPCs().isEmpty()){
            // test this
            if(room.getDoors().isEmpty()){
                System.out.println("It would appear that you are alone.");
                System.out.println("There is no one to hear you scream.");
            }
            else{
                System.out.println("It would appear that you are alone.");
            }
            return;
        }
        // print the list of NPCs if there are some
        System.out.println("You look around for company. You see:");
        for(int i = 0; i < room.getNPCs().size(); i++){
            System.out.print("(" + i + ") ");
            room.getNPCs().get(i).inspect();
            System.out.println(".");
        }
        System.out.println("talk to: (-1 : no one) ");
        Choices c = new Choices("test");
        int who = c.getInput();
        if(who >= room.getNPCs().size() || who < 0){
            return;
        }
        room.getNPCs().get(who).interact(player);
    }

    // look for boxes
    private static void lookForChests(Player player){
        Room room = player.getCurrentRoom();
        if(room.getChest().isEmpty()){
            System.out.println("There would not appear to be anything of interest here.");
            return;
        }
        System.out.println("You look around for chests. You see:");
        for(int i = 0; i < room.getChest().size(); i++){
            System.out.print("(" + i + ") ");
            room.getChest().get(i).inspect(); // HERE
            System.out.println(".");
        }
        System.out.println("Do nothing: (-1 : no one) ");
        Choices c = new Choices("test");
        int what = c.getInput();
        if(what >= room.getChest().size() || what < 0){
            return;
        }
        room.getChest().get(what).interact(player);
    }

    /******************     build the rooms    *************************/
    private static Room buildRooms() {
        Room whiteRoom, blueRoom, greenRoom, entry;

        // create our rooms
        entry = new Room("An open field");
        whiteRoom = new Room("a white room");
        blueRoom = new Room("a blue room");
        greenRoom = new Room("a green room");

        // create some locked doors
        LockedDoor gate = new LockedDoor("a great stone gateway", whiteRoom, true, KeyType.NONE);

        // a random amount of gold
        int randomNum = ThreadLocalRandom.current().nextInt(10, 50);

        // fill the rooms
        entry.addDoor(gate)
                .addNPC(new NPC("a gentleman") {
                    @Override
                    public void interact(Player player) {
                        System.out.println("Greetings sir! Welcome to this game.");
                        System.out.println("Pass through the gate to proceed.");
                        gate.unlock();
                    }
                });

        whiteRoom.addDoor(new Door("a red door", blueRoom))
                .addDoor(new Door("a black door", greenRoom))
                .addDoor(gate)
                .addChest(new Chest("a small box ", "in the corner of the room", randomNum));

        blueRoom.addDoor(new LockedDoor("a large oak door", greenRoom, true, KeyType.RUSTY))
                .addDoor(new Door("a red door", whiteRoom))
                .addNPC(new Salesman("a shady looking man holding open his trenchcoat revealing a variety of wares").addItems(
                        new Item[]{
                                new KeyItem("a rusty old key", KeyType.RUSTY, 20),
                                new KeyItem("a small golden key", KeyType.SMALL, 500)
                        }
                ))
                ;

        greenRoom.addDoor(new Door("a black door", whiteRoom))
                .addDoor(new LockedDoor("a large oak door", blueRoom, true, KeyType.RUSTY));

        return entry;
    }
}