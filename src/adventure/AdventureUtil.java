package adventure;

public class AdventureUtil {
    // description constants for the 1st floor rooms
    public static final String LOUNGE_AREA_DESCRIPTION = "You are an FBI agent working in the City of Gotham." +
            " You have entered an apartment complex in the worst part of the city.";
    public static final String LOBBY_DESCRIPTION = "You enter the apartment lobby. " +
            "Half of the lights are broken, and you hear eerie sounds echoing throughout the building.\n" +
            "To the North is an Elevator lobby, East is a Janitor’s office, " +
            "To the West is the Security office, and to the South is the lounge area.";
    public static final String JANITORS_OFFICE_DESCRIPTION = "You have entered the janitor’s office, it smells awful and there doesn't seem to be\n" +
            "anything useful here, but it might be worth it to look around.";
    public static final String SECURITY_OFFICE_DESCRIPTION = "You have entered the security office, " +
            "it is a mess and it seems like someone left in a rush.\n" +
            "There is a desk with a computer on it.";
    public static final String ELEVATOR_LOBBY_DESCRIPTION = "There are four elevators, three seem " +
            "to be stuck shut but one of them is slightly open";

    // description constants for the 2nd floor rooms
    public static final String SECOND_FLOOR_LOBBY_DESCRIPTION = "You are in the second floor lobby, there is a hallway with a couple of apartments\n" +
            "to the east, and a few to the west. It is quiet….. too quiet";
    public static final String SECOND_FLOOR_EAST_HALLWAY_DESCRIPTION = "You walk down the East hallway and you see a door to an apartment\n" +
            "slightly open and you hear the sound of a crying child coming from the room.";
    public static final String SECOND_FLOOR_WEST_HALLWAY_DESCRIPTION = "You walk down the West hallway and see nothing but locked apartments.\n" +
            "There is a man sitting at the end of the hallway he seems to be homeless.";
    public static final String SECOND_FLOOR_APARTMENT_DESCRIPTION = "You enter the apartment, there is broken glass and stuff thrown all around the apartment.\n" +
            "On the floor you see a dead woman, and a child crying next to her.";

    // description constants for the 3rd floor rooms
    public static final String THIRD_FLOOR_LOBBY_DESCRIPTION = "You are in the third floor lobby, there is a hallway with a couple of apartments\n" +
            "to the East and to the West. There are a couple of people in the hallways and the atmosphere seems tense.";
    public static final String THIRD_FLOOR_EAST_HALLWAY_DESCRIPTION = "You see an old man standing in the back of the hallway. All of the apartments are locked.";
    public static final String THIRD_FLOOR_WEST_HALLWAY_DESCRIPTION = "There is loud music playing and you can hear people partying in a couple of the apartments.\n" +
            "You can knock on their doors but they won’t hear you over the music.\n" +
            "You would need a key to get into the apartment.";
    public static final String DRUG_LORD_APARTMENT_DESCRIPTION = "You slowly walk into the apartment, no one notices you, yet.\n" +
            "You see three males drinking and watching television. Now’s the perfect time to make the arrest.\n" +
            "The man on the left is wearing a red bandana and has a teardrop tattoo under his left eye,\n" +
            "the man in the middle has a red shirt on and has a baseball hat on, and the man on the right\n" +
            "has a red bandana on and a scar under his left eye.";

    // other constants
    public static final String WIN_MESSAGE = "Congratulations, you have successfully arrested the criminal, you really are a great detective.\n" +
            "Thank you for saving the city, please play again.";
    public static final String LOSE_MESSAGE = "Good job on getting this far, but you didn’t get the right guy! Please turn in your badge, or try again.";
    
    public static final String GUN_MESSAGE = "Here's the thing, you got the right guy, so congratulations, however, now you have a load of paperwork to do! Please play again.";
    // supporting methods related to the player movements

    public static String goNorth(Player player) {
        player.setLocation(player.getLocation().north());
        return "You moved to the " + player.getLocation().getName();
    }

    public static String goSouth(Player player) {
        player.setLocation(player.getLocation().south());
        return "You moved to the " + player.getLocation().getName();
    }

    public static String goWest(Player player) {
        player.setLocation(player.getLocation().west());
        return "You moved to the " + player.getLocation().getName();
    }

    public static String goEast(Player player) {
        player.setLocation(player.getLocation().east());
        return "You moved to the " + player.getLocation().getName();
    }

    // other supporting methods
    public static void finishGame() {
        System.out.println("\nThank you for playing, good bye!");
        System.exit(0);
    }
}
