package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FullListTest {
    private final FullListCommand fullListCommand = new FullListCommand();
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    @Test
    void testExecute() throws FileNotFoundException {
        var hotel = new Hotel();
        System.setOut(new PrintStream(outputStream));
        MyMap<Room, String> hotelMap = hotel.getHotelMap();
        fullListCommand.execute(hotel);
        String[] lines = outputStream.toString().split(System.lineSeparator());
        assertEquals("\nRoom number: 1\nRegistered guest: "+hotelMap.get(hotel.getRoom(1))+"\nRoom description: Small room\nPrice for one night (zl): 80", lines[0]);
    }
}
