package adventure.rooms;

import adventure.Player;
import adventure.things.Thing;

import java.util.ArrayList;
import java.util.List;

public abstract class Room {
    protected String name;
    protected String description;

    protected List<Thing> itemsInRoom;
    protected List<String> availableCommands;

    // exits
    protected Room north;
    protected Room south;
    protected Room east;
    protected Room west;

    public Room() {
        itemsInRoom = new ArrayList<>();
        availableCommands = new ArrayList<>();
        availableCommands.add("look");
    }

    public String doAction(String action, Player player) {
        return null;
    }

    public boolean actionIsAvailable(String action) {
        if (!availableCommands.contains(action.toLowerCase())) {
            System.out.println("Command " + action + " is not allowed here.");
            System.out.println("Try \"look\" command to investigate the room");
            return false;
        }

        return true;
    }

    protected void completeDescription() {
        description += "\n    Available commands: ";
        for (int i = 0; i < availableCommands.size() - 1; i++) {
            description += availableCommands.get(i) + ", ";
        }
        description += availableCommands.get(availableCommands.size() - 1) + ".";

        if (itemsInRoom.isEmpty()) {
            return;
        }

        description += "\n    Items in room: ";
        for (int i = 0; i < itemsInRoom.size() - 1; i++) {
            description += itemsInRoom.get(i).getName() + ", ";
        }
        description += itemsInRoom.get(itemsInRoom.size() - 1).getName() + ".";
    }

    public String getName() {
        return name;
    }

    protected String look() {
        return description;
    }

    public Room north() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room south() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public Room east() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room west() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }
}
