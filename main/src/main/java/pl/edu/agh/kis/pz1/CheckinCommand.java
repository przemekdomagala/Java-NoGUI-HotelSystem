package pl.edu.agh.kis.pz1;

import static pl.edu.agh.kis.pz1.Main.s;

/** Class representing Check In command letting user check in to the room. */
public class CheckinCommand extends Command {

    @Override
    protected void execute(Hotel operatedHotel) {
        System.out.println("Enter the room number:");
        MyMap<Room, String> hotelMap = operatedHotel.getHotelMap();
        try {
            int roomNumber = Integer.parseInt(s.nextLine());
            if (operatedHotel.contains(roomNumber)) {
                System.out.println("Room not found.\n");
                return;
            }
            if(!hotelMap.get(operatedHotel.getRoom(roomNumber)).equals("none")){
                System.out.println("This room is not available.");
                return;
            }
            System.out.println("Enter your name and surname:");
            String guest = s.nextLine();
            for (var key : hotelMap.keys()) {
                if (key.getRoomNumber() == roomNumber) {
                    hotelMap.put(key, guest);
                    System.out.println("You have successfully checked in.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Passed Input is not a number.");
        }
    }
}
