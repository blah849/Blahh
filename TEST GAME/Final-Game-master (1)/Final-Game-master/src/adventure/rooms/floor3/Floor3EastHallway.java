package adventure.rooms.floor3;

import adventure.AdventureUtil;
import adventure.Player;
import adventure.rooms.Room;
import adventure.things.generic.OldMan;

public class Floor3EastHallway extends Room {
    public Floor3EastHallway() {
        super();
        name = "Third floor east hallway";

        initItems();
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
            case "talk to old man" : {
                return talkToOldMan();
            }
            case "look" : {
                return look();
            }
        }

        return null;
    }

    private String talkToOldMan() {
        return itemsInRoom.get(0).getDescription();
    }

    private void initItems() {
        itemsInRoom.add(new OldMan());
    }

    private void initCommands() {
        availableCommands.add("talk to old man");
        availableCommands.add("go west");
    }

    private void updateDescription() {
        description = AdventureUtil.THIRD_FLOOR_EAST_HALLWAY_DESCRIPTION;
        completeDescription();
    }
}
