package adventure.rooms;

import adventure.Player;

public class Elevator extends Room {
    public Elevator() {
        super();
        name = "Elevator";
        availableCommands.add("leave elevator");
    }

    @Override
    public String doAction(String action, Player player) {
        action = action.toLowerCase();
        checkPower(player);

        switch (action) {
            case "leave elevator" : {
                return floor1(player);
            }
            case "floor1" : {
                return floor1(player);
            }
            case "floor2" : {
                return floor2(player);
            }
            case "floor3" : {
                return floor3(player);
            }
            case "look" : {
                return look();
            }
        }

        return null;
    }

    private String floor1(Player player) {
        player.setLocation(north);
        return "You moved to the " + north.getName();
    }

    private String floor2(Player player) {
        player.setLocation(west);
        return "You moved to the " + west.getName();
    }

    private String floor3(Player player) {
        player.setLocation(east);
        return "You moved to the " + east.getName();
    }

    private void checkPower(Player player) {
        if (player.powerIsTurnedOn()) {
            description = "The elevator is operational; which floor would you like to go to? There are 3 floors";
            availableCommands.add("floor1");
            availableCommands.add("floor2");
            availableCommands.add("floor3");
            completeDescription();
        }
        else {
            description = "The elevator seems fine, but there is no power running to it right now.";
        }
    }
}
