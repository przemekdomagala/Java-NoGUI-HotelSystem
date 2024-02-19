package pl.edu.agh.kis.pz1;

import static pl.edu.agh.kis.pz1.Main.s;

/** Class representing Check out command letting user check out from the room. */
public class CheckoutCommand extends Command{

    @Override
    protected void execute(Hotel operatedHotel) {
        System.out.println("Enter room number:");
        try {
            int roomNumber = Integer.parseInt(s.nextLine());
            if (operatedHotel.contains(roomNumber)) {
                System.out.println("Room not found.\n");
                return;
            }
            var hotelMap = operatedHotel.getHotelMap();
            if(!hotelMap.get(operatedHotel.getRoom(roomNumber)).equals("none")){
                System.out.println("You have checked out successfully, thank you for using our service.");
                hotelMap.put(operatedHotel.getRoom(roomNumber), "none");
            }
            else{
                System.out.println("There isn't any guest registered for that room.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Passed Input is not a number.");
        }
    }
}
