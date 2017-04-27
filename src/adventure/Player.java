package adventure;

import adventure.rooms.Room;
import adventure.things.Thing;

import java.util.ArrayList;

public class Player {
    private Room location;
    private ArrayList<Thing> inventory;

    boolean turnedOnPower;

    public Player() {
        this.inventory = new ArrayList<>();
    }

    public Room getLocation() {
        return location;
    }

    public void setLocation(Room location) {
        this.location = location;
    }

    public void addItem(Thing thing) {
        inventory.add(thing);
    }

    public Thing getItem(String itemName) {
        for (Thing thing : inventory) {
            if (thing.getName().equals(itemName)) {
                return thing;
            }
        }

        return null;
    }

    public void dropItem(Thing thing) {
        if (inventory.contains(thing)) {
            inventory.remove(thing);
        }
        else {
            throw new IllegalArgumentException("Invalid item!");
        }
    }

    public void turnOnPower() {
        turnedOnPower = true;
    }

    public boolean powerIsTurnedOn() {
        return turnedOnPower;
    }
}
