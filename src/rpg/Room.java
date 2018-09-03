/********************************************

 Assignment 1: text-based RPG - Rooms Class
 Author: Davin Evans s3409988

 *********************************************/

package rpg;

import rpg.Interactables.Door;
import rpg.Interactables.Chest;
import rpg.Interactables.LockedDoor;
import rpg.Interactables.NPC;

import java.util.ArrayList;
import java.util.List;

public class Room extends Inspectable {

    private List<Door> doors; // define the list of doors
    private List<NPC> npcs;
    private List<Chest> chests;

    Room(String description) {
        super(description);
        doors = new ArrayList<>();
        npcs = new ArrayList<>();
        chests = new ArrayList<>();
    }

    // add a Door to the room.  ie extend the doors list
    Room addDoor(Door door) {
        doors.add(door);
        return this;
    }
    Room addDoor(LockedDoor door){
        doors.add(door);
        return this;
    }

    // return the list of all doors (in this room)
    List<Door> getDoors(){
        return doors;
    }

    // add NPCs to room
    public Room addNPC(NPC npc){
        npcs.add(npc);
        return this;
    }

    // remove an NPC from the room
    public void removeNPC(NPC npc){
        npcs.remove(npc);
    }

    // return list of NPCs in the room
    List<NPC> getNPCs() {
        return npcs;
    }

    // add a chest to the room.
    Room addChest(Chest chest) {
        chests.add(chest);
        return this;
    }

    // return list of chests in the room
    List<Chest> getChest() {
        return chests;
    }
}