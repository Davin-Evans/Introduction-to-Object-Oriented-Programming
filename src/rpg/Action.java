/********************************************

 Assignment 1: text-based RPG - Action Interface
 Author: Davin Evans s3409988

 *********************************************/

package rpg;

public interface Action {
    // call this to perform an action.
    // caller is the player performing the action
    void call(Player caller);
}
