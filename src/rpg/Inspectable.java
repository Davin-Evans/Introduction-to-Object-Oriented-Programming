/********************************************

 Assignment 1: text-based RPG - Inspectable Super Class
 Author: Davin Evans s3409988

 *********************************************/

package rpg;

public abstract class Inspectable {

    private String description;

    // @param desc The description of the inspectable object.
    public Inspectable(String description){
        setDescription(description);
    }

    // prints the description of the inspectable object.
    public void inspect(){
        System.out.print(getDescription());
    }

    // returns a description of the object
    protected String getDescription() {
        return description;
    }

    // sets the description of the object
    protected void setDescription(String description) {
        this.description = description;
    }
}
