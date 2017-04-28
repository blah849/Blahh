package adventure.rooms.floor2;

import adventure.AdventureUtil;
import adventure.Player;
import adventure.rooms.Room;

public class Floor2Lobby extends Room {
    public Floor2Lobby() {
        super();
        name = "Second floor lobby";

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
            case "go east" : {
                return AdventureUtil.goEast(player);
            }
            case "enter elevator" : {
                return AdventureUtil.goSouth(player);
            }
            case "look" : {
                return look();
            }
        }

        return null;
    }

    private void initCommands() {
        availableCommands.add("go west");
        availableCommands.add("go east");
        availableCommands.add("enter elevator");
    }

    private void updateDescription() {
        description = AdventureUtil.SECOND_FLOOR_LOBBY_DESCRIPTION;
        completeDescription();
    }
}
