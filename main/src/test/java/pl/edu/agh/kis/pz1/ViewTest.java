package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ViewTest {
    ByteArrayInputStream inputStream = new ByteArrayInputStream("1\na\n0".getBytes());
    @Test
    void testExecute() throws FileNotFoundException {
        ViewCommand viewCommand = new ViewCommand();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        System.setIn(inputStream);
        Hotel hotel = new Hotel();
        MyMap<Room, String> hotelMap = hotel.getHotelMap();
        viewCommand.execute(hotel);
        String[] lines = outputStream.toString().split(System.lineSeparator());
        assertEquals("\nRoom number: 1\nRegistered guest: "+hotelMap.get(hotel.getRoom(1))+"\nRoom description: Small room\nPrice for one night (zl): 80", lines[1]);
        viewCommand.execute(hotel);
        lines = outputStream.toString().split(System.lineSeparator());
        assertEquals("Passed Input is not a number.", lines[3]);
        viewCommand.execute(hotel);
        lines = outputStream.toString().split(System.lineSeparator());
        assertEquals("Room not found.", lines[5]);
    }
}
