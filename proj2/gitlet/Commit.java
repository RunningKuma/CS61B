package gitlet;

// TODO: any imports you need here

import java.util.Date; // TODO: You'll likely use this in this class

/** Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Commit {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */

    /** The message of this Commit. */
    private String message;
    Date timestamp;
    //keep track of what file
    Commit parent;


    /* TODO: fill in the rest of this class. */
    public Commit(String message, Commit parent) {
        this.message = message;
        this.parent = parent;
    }

    public String getMessage() {
        return this.message;
    }

    public String getStamp() {
        return this.toString();
    }

    public Commit getParent() {
        return this.parent;
    }
}
