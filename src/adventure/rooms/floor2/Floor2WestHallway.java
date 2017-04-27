package adventure.rooms.floor2;

import adventure.AdventureUtil;
import adventure.Player;
import adventure.rooms.Room;
import adventure.things.generic.HomelessMan;

public class Floor2WestHallway extends Room {
    public Floor2WestHallway() {
        super();
        name = "Second floor west hallway";

        initItems();
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
            case "talk to homeless man" : {
                return talkToHomelessMan();
            }
            case "look" : {
                return look();
            }
        }

        return null;
    }

    private String talkToHomelessMan() {
        return itemsInRoom.get(0).getDescription();
    }

    private void initItems() {
        itemsInRoom.add(new HomelessMan());
    }

    private void initCommands() {
        availableCommands.add("go east");
        availableCommands.add("talk to homeless man");
    }

    private void updateDescription() {
        description = AdventureUtil.SECOND_FLOOR_WEST_HALLWAY_DESCRIPTION;
        completeDescription();
    }
}
