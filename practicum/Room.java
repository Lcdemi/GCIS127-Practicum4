package practicum;

/**
 * A simple class representing a room that can fit up to 3 people at the same
 * time.
 * 
 * @author SE Department Faculty
 */
public class Room {
    /**
     * The maximum occupancy of the room.
     */
    private static final int MAX_OCCUPANCY = 3;

    /**
     * The current occupancy of the room.
     */
    private int occupancy;

    /**
     * Creates a new, empty room.
     */
    public Room() {
        this.occupancy = 0;
    }

    /**
     * Checks to see if there is space enough for at least one more person in 
     * the room. This method should be called before a person attempts to enter
     * the room to make sure that there is space enough for them to fit.
     * 
     * @return True if there is space for at least one more person in the room.
     */
    public boolean hasRoom() {
        return occupancy < MAX_OCCUPANCY;
    }

    /**
     * Called when a person enters the room. If this causes the room to be over
     * the maximum capacity, an unchecked exception is thrown.
     */
    public void enter() {
        this.occupancy++;
        if(occupancy > MAX_OCCUPANCY) {
            throw new IllegalStateException("Maximum occupancy exceeded!");
        }
    }

    /**
     * Called when a person exits the room. If this causes the occupancy to be
     * negative, an unchecked exception is thrown.
     */
    public void exit() {
        this.occupancy--;
        if(this.occupancy < 0) {
            throw new IllegalStateException("Negative occupants?!");
        }
    }

    @Override
    public String toString() {
        return "Room (" + this.occupancy + ")";
    }
}
