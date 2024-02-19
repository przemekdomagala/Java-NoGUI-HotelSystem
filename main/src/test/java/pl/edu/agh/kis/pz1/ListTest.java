package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListTest {
    private final ListCommand ListCommand = new ListCommand();
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    @Test
    void testExecute() throws FileNotFoundException {
        System.setOut(new PrintStream(outputStream));
        Hotel hotel = new Hotel();
        MyMap<Room, String> hotelMap = hotel.getHotelMap();
        Room room = hotel.getRoom(1);
        hotelMap.put(room, "none");
        ListCommand.execute(hotel);
        String[] lines = outputStream.toString().split(System.lineSeparator());
        assertEquals("\nRoom number: 1\nAvailability: available", lines[0]);
        hotelMap.put(room, "John Doe");
        ListCommand.execute(hotel);
        lines = outputStream.toString().split(System.lineSeparator());
        assertEquals("\nRoom number: 1\nAvailability: not available", lines[36]);
    }
}
