package adventure.rooms.floor2;

import adventure.AdventureUtil;
import adventure.Player;
import adventure.rooms.Room;
import adventure.things.Thing;
import adventure.things.generic.Couch;
import adventure.things.generic.Note;
import adventure.things.interactive.Key;
import adventure.things.interactive.Knife;

public class Floor2Apartment extends Room {
    public Floor2Apartment() {
        super();
        name = "Second floor apartment";

        initItems();
        initCommands();
        updateDescription();
    }

    @Override
    public String doAction(String action, Player player) {
        action = action.toLowerCase();

        switch (action) {
            case "pick up note" : {
                return pickUpNote(player);
            }
            case "read note" : {
                return readNote(player);
            }
            case "pick up knife" : {
                return pickUpKnife(player);
            }
            case "search couch" : {
                return searchCouch();
            }
            case "take key" : {
                return takeKey(player);
            }
            case "leave apartment" : {
                return AdventureUtil.goSouth(player);
            }
            case "look" : {
                return look();
            }
        }

        return null;
    }

    private String pickUpNote(Player player) {
        availableCommands.add("read note");
        availableCommands.remove("pick up note");
        player.addItem(findNote());
        itemsInRoom.remove(findNote());
        updateDescription();
        return "You picked up the note. Now you can find it in your inventory or read it.";
    }

    private Thing findNote() {
        Thing note = null;
        for (Thing thing : itemsInRoom) {
            if (thing instanceof Note) {
                note = thing;
            }
        }

        return note;
    }

    private String pickUpKnife(Player player) {
        availableCommands.remove("pick up knife");
        player.addItem(findKnife());
        itemsInRoom.remove(findKnife());
        updateDescription();
        return "You picked up the knife. Now you can find it in your inventory.";
    }

    private Thing findKnife() {
        Thing knife = null;
        for (Thing thing : itemsInRoom) {
            if (thing instanceof Knife) {
                knife = thing;
            }
        }

        return knife;
    }

    private String searchCouch() {
        availableCommands.remove("search couch");
        availableCommands.add("take key");
        itemsInRoom.add(new Key());
        updateDescription();
        return "You find the apartment key under the couch";
    }

    private String takeKey(Player player) {
        availableCommands.remove("take key");
        player.addItem(findKey());
        itemsInRoom.remove(findKey());
        updateDescription();
        return "You took the key. Now you can find it in your inventory";
    }

    private Thing findKey() {
        Thing key = null;
        for (Thing thing : itemsInRoom) {
            if (thing instanceof Key) {
                key = thing;
            }
        }

        return key;
    }

    private String readNote(Player player) {
        return player.getItem("Note").getDescription();
    }

    private void initItems() {
        itemsInRoom.add(new Note());
        itemsInRoom.add(new Knife());
        itemsInRoom.add(new Couch());
    }

    private void initCommands() {
        availableCommands.add("pick up note");
        availableCommands.add("pick up knife");
        availableCommands.add("search couch");
        availableCommands.add("leave apartment");
    }

    private void updateDescription() {
        description = AdventureUtil.SECOND_FLOOR_APARTMENT_DESCRIPTION;
        completeDescription();
    }
}
