package adventure.rooms.floor1;

import adventure.AdventureUtil;
import adventure.Player;
import adventure.rooms.Room;
import adventure.things.generic.Computer;
import adventure.things.interactive.Gun;
import adventure.things.Thing;

public class SecurityOffice extends Room {
    public SecurityOffice() {
        super();
        name = "Security office";

        initItems();
        initCommands();
        updateDescription();
    }

    @Override
    public String doAction(String action, Player player) {
        action = action.toLowerCase();

        switch (action) {
            case "look in desk" : {
                return lookInDesk();
            }
            case "use computer" : {
                return useComputer();
            }
            case "leave room" : {
                return AdventureUtil.goEast(player);
            }
            case "take the gun" : {
                return takeTheGun(player);
            }
            case "look" : {
                return look();
            }
        }

        return null;
    }

    public String lookInDesk() {
        availableCommands.remove("look in desk");
        availableCommands.add("take the gun");
        itemsInRoom.add(new Gun());
        updateDescription();
        return "You found a gun in the desk, maybe you should take it.";
    }

    public String useComputer() {
        return findComputer().getDescription();
    }

    private Thing findComputer() {
        Thing computer = null;
        for (Thing thing : itemsInRoom) {
            if (thing instanceof Computer) {
                computer = thing;
            }
        }

        return computer;
    }

    private String takeTheGun(Player player) {
        player.addItem(findGun());
        availableCommands.remove("take the gun");
        itemsInRoom.remove(findGun());
        updateDescription();
        return "You took the gun, now you can find it in your inventory";
    }

    private Thing findGun() {
        Thing gun = null;
        for (Thing thing : itemsInRoom) {
            if (thing instanceof Gun) {
                gun = thing;
            }
        }

        return gun;
    }

    private void initItems() {
        itemsInRoom.add(new Computer());
    }

    private void initCommands() {
        availableCommands.add("look in desk");
        availableCommands.add("use computer");
        availableCommands.add("leave room");
    }

    private void updateDescription() {
        description = AdventureUtil.SECURITY_OFFICE_DESCRIPTION;
        completeDescription();
    }
}
