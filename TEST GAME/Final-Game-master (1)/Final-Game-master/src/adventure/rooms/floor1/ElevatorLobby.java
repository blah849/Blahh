package adventure.rooms.floor1;

import adventure.AdventureUtil;
import adventure.Player;
import adventure.rooms.Room;
import adventure.things.interactive.Ammunition;
import adventure.things.Thing;
import adventure.things.generic.TrashBin;

public class ElevatorLobby extends Room {
    public ElevatorLobby() {
        super();
        name = "Elevator lobby";

        initItems();
        initCommands();
        updateDescription();
    }

    @Override
    public String doAction(String action, Player player) {
        action = action.toLowerCase();

        switch (action) {
            case "enter elevator" : {
                return AdventureUtil.goNorth(player);
            }
            case "go south" : {
                return AdventureUtil.goSouth(player);
            }
            case "open trash bin" : {
                return openTrashBin(player);
            }
            case "take the ammo clip" : {
                return takeTheAmmoClip(player);
            }
            case "look" : {
                return look();
            }
        }

        return null;
    }

    private String openTrashBin(Player player) {
        availableCommands.add("take the ammo clip");
        itemsInRoom.add(new Ammunition());
        availableCommands.remove("open trash bin");
        updateDescription();
        return "You open the trash bin and see the ammo clip inside";
    }

    private String takeTheAmmoClip(Player player) {
        availableCommands.remove("take the ammo clip");
        player.addItem(findAmmunition());
        itemsInRoom.remove(findAmmunition());
        updateDescription();
        return "You took the ammunition. Now you can find it in your inventory";
    }

    private Thing findAmmunition() {
        Thing ammunition = null;
        for (Thing thing: itemsInRoom) {
            if (thing instanceof  Ammunition) {
                ammunition = thing;
            }
        }

        return ammunition;
    }

    private void initCommands() {
        availableCommands.add("enter elevator");
        availableCommands.add("go south");
        availableCommands.add("open trash bin");
    }

    private void initItems() {
        itemsInRoom.add(new TrashBin());
    }

    private void updateDescription() {
        description = AdventureUtil.ELEVATOR_LOBBY_DESCRIPTION;
        completeDescription();
    }
}
