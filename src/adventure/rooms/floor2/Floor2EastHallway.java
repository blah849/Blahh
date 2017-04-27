package adventure.rooms.floor2;

import adventure.AdventureUtil;
import adventure.Player;
import adventure.rooms.Room;

public class Floor2EastHallway extends Room {
    public Floor2EastHallway() {
        super();
        name = "Second floor east hallway";

        initCommands();
        updateDescription();
    }

    @Override
    public String doAction(String action, Player player) {
        action = action.toLowerCase();

        switch (action) {
            case "go west" : {
                return AdventureUtil.goWest(player);
            }
            case "enter apartment" : {
                return AdventureUtil.goNorth(player);
            }
            case "look" : {
                return look();
            }
        }

        return null;
    }

    private void initCommands() {
        availableCommands.add("enter apartment");
        availableCommands.add("go west");
    }

    private void updateDescription() {
        description = AdventureUtil.SECOND_FLOOR_EAST_HALLWAY_DESCRIPTION;
        completeDescription();
    }
}
