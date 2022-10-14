package ru.aasmc.effectivejava.chapter_02.item_08;

public class ClientOfRoom {
    public static void main(String[] args) {
        // correct
        try(Room myRoom = new Room(7)) {
            System.out.println("Good bye!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // this may never clean the room
        new Room(10);
        System.out.println("Peace out");
        System.gc(); // this will try to force the Room cleaner to run, but with no guarantee((
    }
}
