package pl.edu.agh.kis.pz1;


/** Class representing Full list command letting user see detailed list of all hotel rooms. */
public class FullListCommand extends Command{

    @Override
    protected void execute(Hotel hotel){
        var hotelMap = hotel.getHotelMap();
        for(var key: hotelMap.keys()){
            System.out.println("\nRoom number: "+key.getRoomNumber()+"\nRegistered guest: "+hotelMap.get(key)+"\nRoom description: "+
                    key.getDescription()+"\nPrice for one night (zl): "+key.getPrice());
        }
    }
}
