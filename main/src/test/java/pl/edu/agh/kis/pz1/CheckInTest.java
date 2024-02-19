package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckInTest {
    private CheckinCommand checkinCommand;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    ByteArrayInputStream inputStream = new ByteArrayInputStream("101\nJohn Doe\n101\na\n1\n1\na\n999\n1\na\n0".getBytes());

    @BeforeEach
    public void checkInSetUp() {
        System.setOut(new PrintStream(outputStream));
        System.setIn(inputStream);
        checkinCommand = new CheckinCommand();
    }

    @Test
    void checkInExecuteSuccessfully() throws FileNotFoundException {
        var hotel = new Hotel();
        var hotelMap = hotel.getHotelMap();
        checkinCommand.execute(hotel);
        assertEquals("John Doe", hotelMap.get(hotel.getRoom(101)));
        hotelMap.remove(hotel.getRoom(101));
        checkinCommand.execute(hotel);
        String[] lines = outputStream.toString().split(System.lineSeparator());
        assertEquals("Room not found.\n", lines[4]);
        checkinCommand.execute(hotel);
        lines = outputStream.toString().split(System.lineSeparator());
        assertEquals("Passed Input is not a number.", lines[6]);
    }
}
