package adventure.rooms.floor3;

import adventure.AdventureUtil;
import adventure.Player;
import adventure.rooms.Room;
import adventure.things.Thing;

public class Floor3WestHallway extends Room {
    public Floor3WestHallway() {
        super();
        name = "Third floor west hallway";

        initCommands();
        updateDescription();
    }

    @Override
    public String doAction(String action, Player player) {
        action = action.toLowerCase();

        switch (action) {
            case "go east" : {
                return AdventureUtil.goEast(player);
            }
            case "use key" : {
                return useKey(player);
            }
            case "look" : {
                return look();
            }
        }

        return null;
    }

    private String useKey(Player player) {
        Thing key = player.getItem("Key");
        if (key == null) {
            return "The door is locked and you do not have the key.";
        }

        return AdventureUtil.goNorth(player);
    }

    private void initCommands() {
        availableCommands.add("go east");
        availableCommands.add("use key");
    }

    private void updateDescription() {
        description = AdventureUtil.THIRD_FLOOR_WEST_HALLWAY_DESCRIPTION;
        completeDescription();
    }
}
