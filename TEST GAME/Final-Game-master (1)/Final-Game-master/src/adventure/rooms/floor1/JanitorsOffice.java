package adventure.rooms.floor1;

import adventure.AdventureUtil;
import adventure.Player;
import adventure.rooms.Room;
import adventure.things.generic.BreakerBox;

public class JanitorsOffice extends Room {
    public JanitorsOffice() {
        super();
        name = "Janitors office";

        initItems();
        initCommands();
        updateDescription();
    }

    @Override
    public String doAction(String action, Player player) {
        action = action.toLowerCase();

        switch (action) {
            case "flip breaker switch" : {
                return flipBreakerSwitch(player);
            }
            case  "leave room" : {
                return AdventureUtil.goWest(player);
            }
            case "look" : {
                return look();
            }
        }

        return null;
    }

    private String flipBreakerSwitch(Player player) {
        availableCommands.remove("flip breaker switch");
        updateDescription();
        player.turnOnPower();
        return itemsInRoom.get(0).getDescription();
    }

    private void initItems() {
        itemsInRoom.add(new BreakerBox());
    }

    private void initCommands() {
        availableCommands.add("flip breaker switch");
        availableCommands.add("leave room");
    }

    private void updateDescription() {
        description = AdventureUtil.JANITORS_OFFICE_DESCRIPTION;
        completeDescription();
    }
}
