package algorighms.slot_merge;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Room> rooms = createRoomList();
        List<Room> mergedRooms = mergeRooms(rooms);
        mergedRooms.forEach(System.out::println);
    }

    private static List<Room> mergeRooms(List<Room> rooms) {
        rooms.sort((o1, o2) -> {
            if(o1.id() == o2.id())
                return o1.startDay() - o2.startDay();
            return o1.id() - o2.id();
        });
        int i = 0;
        while(i < rooms.size() - 1) {
            if((rooms.get(i).endDay() + 1 == rooms.get(i+1).startDay())
            && (rooms.get(i).id() == rooms.get(i+1).id())){
                Room firstRoom = rooms.remove(i);
                Room secondRoom = rooms.remove(i);
                rooms.add(i, new Room(firstRoom.id(), firstRoom.price() + secondRoom.price(), firstRoom.startDay(), secondRoom.endDay()));
            }else{
                i++;
            }
        }
        return rooms;
    }

    private static List<Room> createRoomList() {
        List<Room> rooms = new ArrayList<>();
        Room room1 = new Room(1, 10.0, 1, 4);
        rooms.add(room1);
        Room room4 = new Room(2, 10.0, 5, 6);
        rooms.add(room4);
        Room room3 = new Room(1, 10.0, 9, 10);
        rooms.add(room3);
        Room room5 = new Room(2, 10.0, 7, 9);
        rooms.add(room5);
        Room room2 = new Room(1, 10.0, 5, 6);
        rooms.add(room2);

        return rooms;
    }
}

record Room(int id, double price, int startDay, int endDay){}
