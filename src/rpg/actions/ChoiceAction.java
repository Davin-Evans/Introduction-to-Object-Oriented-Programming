/********************************************

 Assignment 1: text-based RPG - Action Class
 Author: Davin Evans s3409988

 *********************************************/

package rpg.actions;

import rpg.Action;
import rpg.Choices;
import rpg.Player;

public abstract class ChoiceAction implements Action {
    private Choices choice = new Choices("action");

    // call to respond to a Choice.
    public ChoiceAction(Choices choice){
        this.choice = choice;
    }

    // Invoke the choice and pass the result to the action.
    @Override
    public void call(Player caller) {
        action(choice.print(), caller);
    }

    public abstract void action(int action, Player caller);
}
