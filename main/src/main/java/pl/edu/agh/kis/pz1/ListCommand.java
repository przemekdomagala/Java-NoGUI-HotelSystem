package pl.edu.agh.kis.pz1;


public class ListCommand extends Command{

    @Override
    protected void execute(Hotel operatedHotel){
        MyMap<Room, String> hotelMap = operatedHotel.getHotelMap();
        for(var key: hotelMap.keys()){
            System.out.println("\nRoom number: "+key.getRoomNumber()+"\nAvailability: "+
                    (hotelMap.get(key).equals("none") ? "available" : "not available"));
        }
    }
}
