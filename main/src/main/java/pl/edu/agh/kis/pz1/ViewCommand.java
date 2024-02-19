package pl.edu.agh.kis.pz1;

import static pl.edu.agh.kis.pz1.Main.s;

public class ViewCommand extends Command{

    @Override
    protected void execute(Hotel hotel) {
        System.out.println("Enter the room number:");
        var hotelMap = hotel.getHotelMap();
        try {
            int roomNumber = Integer.parseInt(s.nextLine());
            for (var key : hotelMap.keys()) {
                if (key.getRoomNumber() == roomNumber) {
                    System.out.println("\nRoom number: " + key.getRoomNumber() + "\nRegistered guest: " + hotelMap.get(key) + "\nRoom description: " +
                            key.getDescription() + "\nPrice for one night (zl): " + key.getPrice());
                    return;
                }
            }
            System.out.println("Room not found.");
        }catch (NumberFormatException e) {
            System.out.println("Passed Input is not a number.");
        }
    }
}
