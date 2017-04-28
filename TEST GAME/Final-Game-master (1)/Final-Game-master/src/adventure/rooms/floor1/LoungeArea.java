package adventure.rooms.floor1;

import adventure.AdventureUtil;
import adventure.Player;
import adventure.rooms.Room;
import adventure.things.interactive.Journal;
import adventure.things.interactive.Magazine;
import adventure.things.Thing;

public class LoungeArea extends Room {
    public LoungeArea() {
        super();
        name = "Lounge area";

        initItems();
        initCommands();
        updateDescription();
    }

    @Override
    public String doAction(String action, Player player) {
        action = action.toLowerCase();

        switch (action) {
            case "leave room" : {
                return AdventureUtil.goNorth(player);
            }
            case "take journal" : {
                return takeJournal(player);
            }
            case "read journal" : {
                return readJournal(player);
            }
            case "take magazine" : {
                return takeMagazine(player);
            }
            case "read magazine" : {
                return readMagazine(player);
            }
            case "look" : {
                return look();
            }

            default: {
                return "unknown command";
            }
        }
    }

    private String takeJournal(Player player) {
        player.addItem(findJournal());
        availableCommands.add("read journal");
        availableCommands.remove("take journal");

        itemsInRoom.remove(findJournal());
        updateDescription();
        return "You took the journal. Now you can find it in your inventory";
    }

    private Thing findJournal() {
        Thing journal = null;
        for (Thing thing : itemsInRoom) {
            if (thing instanceof Journal) {
                journal = thing;
            }
        }

        return journal;
    }

    private String readJournal(Player player) {
        return player.getItem("Journal").getDescription();
    }

    private String takeMagazine(Player player) {
        player.addItem(findMagazine());
        availableCommands.add("read magazine");
        availableCommands.remove("take magazine");

        itemsInRoom.remove(findMagazine());
        updateDescription();
        return "You took the magazine. Now you can find it in your inventory";
    }

    private Thing findMagazine() {
        Thing magazine = null;
        for (Thing thing : itemsInRoom) {
            if (thing instanceof Magazine) {
                magazine = thing;
            }
        }

        return magazine;
    }

    private String readMagazine(Player player) {
        return player.getItem("Magazine").getDescription();
    }

    private void initItems() {
        itemsInRoom.add(new Journal());
        itemsInRoom.add(new Magazine());
    }

    private void initCommands() {
        availableCommands.add("leave room");
        availableCommands.add("take journal");
        availableCommands.add("take magazine");
    }

    private void updateDescription() {
        description = AdventureUtil.LOUNGE_AREA_DESCRIPTION;
        completeDescription();
    }
}
