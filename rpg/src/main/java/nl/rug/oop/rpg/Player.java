package nl.rug.oop.rpg;

import java.util.ArrayList;
import java.util.List;

/**
 * The player object
 * Created by PhilO on 27-Apr-17.
 */
public class Player {
    // Stores the room object the player is in
    private Room currentRoom;
    private List<Room> visitedRoomsList;
    private int health;

    // Constructor
    public Player(Room startingRoom) {
        currentRoom = startingRoom;
        visitedRoomsList = new ArrayList<>();
        health = 10;
    }

    // Returns the room object currently in
    public Room getRoom() {
        return currentRoom;
    }

    // Updates the current room, and adds the room to rooms visited if it has not been visited
    public void setRoom(Room room) {
        currentRoom = room;
        if (!visitedRoomsList.contains(room)) {
            visitedRoomsList.add(room);
        }
    }

    public List<Room> getVisitedRoomsList() {
        return visitedRoomsList;
    }

    // Player looks at the doors
    private void seeDoors() {
        int numberOfDoors = currentRoom.getNumberOfDoors();
        for (int i = 0; i < numberOfDoors; i++) {
            System.out.println(currentRoom.getDoor(i).inspect());
        }
    }

    // Player considers which door to enter
    private void considerDoors() {
        int numberOfDoors = currentRoom.getNumberOfDoors();
        System.out.println("\nWhat would you like to do?");
        System.out.println("(0) Stay Here");
        for (int i = 0; i < numberOfDoors; i++) {
            System.out.println("(" + (i + 1) + ") Enter " + currentRoom.getDoor(i).inspect());
        }
    }

    // Player can choose a door
    private int chooseDoor() {
        int numberOfDoors = currentRoom.getNumberOfDoors();
        int choice = HelperClass.getValidChoice(0, numberOfDoors);
        return choice;
    }

    // Steps a player takes to choose a door
    private void enterDoor(int choice) {
        if (choice != 0) {
            System.out.println("You enter through the door");
            currentRoom.getDoor(choice - 1).interact(this);
        } else {
            System.out.println("You do nothing.");
        }
    }

    private void examineNpcs() {
        int numberOfNpcs = currentRoom.getNumberOfnpcs();
        for (int i = 0; i < numberOfNpcs; i++) {
            System.out.println("(" + i + ")" + currentRoom.getnpc(i).inspect());
        }
        System.out.println("Interact? (-1 = do nothing)");
    }

    private int chooseNpc() {
        int numberOfNpcs = currentRoom.getNumberOfnpcs();
        int choice = HelperClass.getValidChoice(-1, numberOfNpcs);
        return choice;
    }

    private void interactWithNpc(int choice) {
        if (choice == -1) {
            System.out.println("You do nothing.");
        } else {
            currentRoom.getnpc(choice).interact(this);
        }
    }

    // The thought process a player takes to enter a door
    public void handleDoorChoices() {
        seeDoors();
        considerDoors();
        int choice = chooseDoor();
        enterDoor(choice);
    }

    public void handleNpcChoices() {
        examineNpcs();
        int choice = chooseNpc();
        interactWithNpc(choice);
    }


}
