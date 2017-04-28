package adventure.rooms.floor1;

import adventure.AdventureUtil;
import adventure.Player;
import adventure.rooms.Room;

public class Lobby extends Room {
    public Lobby() {
        super();

        this.name = "Lobby";
        this.description = AdventureUtil.LOBBY_DESCRIPTION;

        initCommands();
        completeDescription();
    }

    @Override
    public String doAction(String action, Player player) {
        action = action.toLowerCase();

        switch (action) {
            case "go north" : {
                return AdventureUtil.goNorth(player);
            }
            case "go south" : {
                return AdventureUtil.goSouth(player);
            }
            case "go east" : {
                return AdventureUtil.goEast(player);
            }
            case "go west" : {
                return AdventureUtil.goWest(player);
            }
            case "look" : {
                return look();
            }

            default: {
                return "unknown command";
            }
        }
    }

    private void initCommands() {
        availableCommands.add("go north");
        availableCommands.add("go south");
        availableCommands.add("go west");
        availableCommands.add("go east");
    }
}
