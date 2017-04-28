package adventure;

import adventure.rooms.*;
import adventure.rooms.floor1.*;
import adventure.rooms.floor2.Floor2Apartment;
import adventure.rooms.floor2.Floor2EastHallway;
import adventure.rooms.floor2.Floor2Lobby;
import adventure.rooms.floor2.Floor2WestHallway;
import adventure.rooms.floor3.DrugLordApartment;
import adventure.rooms.floor3.Floor3EastHallway;
import adventure.rooms.floor3.Floor3Lobby;
import adventure.rooms.floor3.Floor3WestHallway;

import java.util.ArrayList;
import java.util.Scanner;

public class AdventureModel {
    private Player player;
    private ArrayList<Room> rooms;

    public AdventureModel() {
        initPlayer();
        initRooms();
    }

    public void playGame() {
        String command;
        System.out.println("Welcome to Gotham's Dark Agent!" +
                "\nTip: Investigate the current location using \"look\" command.\n");

        while (true) {
            command = getCommand();

            if (command.equals("quit")) {
                break;
            }

            if (!player.getLocation().actionIsAvailable(command)) {
                continue;
            }

            String currentMessage = player.getLocation().doAction(command, player);
            System.out.println(currentMessage);

            if (currentMessage.equals(AdventureUtil.WIN_MESSAGE) || currentMessage.equals(AdventureUtil.LOSE_MESSAGE || currentMessage.equals(AdventureUtil.GUN_MESSAGE)) {
                AdventureUtil.finishGame();
            }
        }
    }

    private void initPlayer() {
        player = new Player();
    }

    private void initRooms() {
        rooms = new ArrayList<>();

        // init rooms
        Room loungeArea = new LoungeArea();
        rooms.add(loungeArea);

        Room lobby = new Lobby();
        rooms.add(lobby);

        Room elevatorLobby = new ElevatorLobby();
        rooms.add(elevatorLobby);

        Room securityOffice = new SecurityOffice();
        rooms.add(securityOffice);

        Room janitorsOffice = new JanitorsOffice();
        rooms.add(janitorsOffice);

        // floor 2

        Room elevator = new Elevator();
        rooms.add(elevator);

        Room floor2Lobby = new Floor2Lobby();
        rooms.add(floor2Lobby);

        Room floor2WestHallway = new Floor2WestHallway();
        rooms.add(floor2WestHallway);

        Room floor2EastHallway = new Floor2EastHallway();
        rooms.add(floor2EastHallway);

        Room floor2Apartment = new Floor2Apartment();
        rooms.add(floor2Apartment);

        // floor 3
        Room floor3Lobby = new Floor3Lobby();
        rooms.add(floor3Lobby);

        Room floor3EastHallway = new Floor3EastHallway();
        rooms.add(floor3EastHallway);

        Room floor3WestHallway = new Floor3WestHallway();
        rooms.add(floor3WestHallway);

        Room drugLordApartment = new DrugLordApartment();
        rooms.add(drugLordApartment);

        // create room connections for the 1st floor
        loungeArea.setNorth(lobby);

        lobby.setSouth(loungeArea);
        lobby.setNorth(elevatorLobby);
        lobby.setWest(securityOffice);
        lobby.setEast(janitorsOffice);

        securityOffice.setEast(lobby);

        janitorsOffice.setWest(lobby);

        elevatorLobby.setSouth(lobby);
        elevatorLobby.setNorth(elevator);

        // create room connections for the 2nd floor
        elevator.setNorth(elevatorLobby);
        elevator.setWest(floor2Lobby);
        elevator.setEast(floor3Lobby);

        floor2Lobby.setSouth(elevator);
        floor2Lobby.setWest(floor2WestHallway);
        floor2Lobby.setEast(floor2EastHallway);

        floor2WestHallway.setEast(floor2Lobby);

        floor2EastHallway.setWest(floor2Lobby);
        floor2EastHallway.setNorth(floor2Apartment);

        floor2Apartment.setSouth(floor2EastHallway);

        // create room connections for the 3rd floor
        floor3Lobby.setSouth(elevator);
        floor3Lobby.setEast(floor3EastHallway);
        floor3Lobby.setWest(floor3WestHallway);

        floor3EastHallway.setWest(floor3Lobby);

        floor3WestHallway.setEast(floor3Lobby);
        floor3WestHallway.setNorth(drugLordApartment);

        drugLordApartment.setSouth(floor3WestHallway);

        player.setLocation(loungeArea);
    }

    private String getCommand() {
        System.out.println("Enter the command: ");
        System.out.print(" > ");
        return new Scanner(System.in).nextLine();
    }
}

