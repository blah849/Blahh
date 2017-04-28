package adventure.rooms.floor3;

import adventure.AdventureUtil;
import adventure.Player;
import adventure.rooms.Room;

public class DrugLordApartment extends Room {
    public DrugLordApartment() {
        super();
        name = "Drug lord apartment";

        initCommands();
        updateDescription();
    }

    @Override
    public String doAction(String action, Player player) {
        action = action.toLowerCase();

        switch (action) {
            case "arrest man on the left" : {
                return arrestManOnTheLeft();
            }
            case "arrest man on the middle" : {
                return arrestManOnTheMiddle();
            }
            case "arrest man on the right" : {
                return arrestManOnTheRight();
            }
            case "leave room" : {
                return AdventureUtil.goSouth(player);
            }
            case "look" : {
                return look();
            }
        }

        return null;
    }

    private String arrestManOnTheLeft() {
        return AdventureUtil.LOSE_MESSAGE;
    }

    private String arrestManOnTheMiddle() {
        return AdventureUtil.LOSE_MESSAGE;
    }

    private String arrestManOnTheRight() {
        return AdventureUtil.WIN_MESSAGE;
    }
    
      private String shootManOnTheRight() {
        return AdventureUtil.GUN_MESSAGE;
    }
      private String shootManOnTheMiddle() {
        return AdventureUtil.LOSE_MESSAGE;
    }
      private String shootManOnTheLeft() {
        return AdventureUtil.LOSE_MESSAGE;
    }

    private void initCommands() {
        availableCommands.add("arrest man on the left");
        availableCommands.add("arrest man on the middle");
        availableCommands.add("arrest man on the right");
        availableCommands.add("shoot man on the left");
        availableCommands.add("shoot man on the middle");
        availableCommands.add("shoot man on the right");
        availableCommands.add("leave room");
    }

    private void updateDescription() {
        description = AdventureUtil.DRUG_LORD_APARTMENT_DESCRIPTION;
        completeDescription();
    }
}
