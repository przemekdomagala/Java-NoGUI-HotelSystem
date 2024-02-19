package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckOutTest {
    private CheckoutCommand checkoutCommand;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    ByteArrayInputStream inputStream = new ByteArrayInputStream("1\n1\na\n999".getBytes());

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
        System.setIn(inputStream);
        checkoutCommand = new CheckoutCommand();
    }
    @Test
    void executeSuccessfully() throws FileNotFoundException {
        var hotel = new Hotel();
        var hotelMap = hotel.getHotelMap();
        Room room = hotel.getRoom(1);
        hotelMap.put(room, "John Doe");
        checkoutCommand.execute(hotel);
        String[] lines = outputStream.toString().split(System.lineSeparator());
        assertEquals("You have checked out successfully, thank you for using our service.", lines[1]);
        checkoutCommand.execute(hotel);
        lines = outputStream.toString().split(System.lineSeparator());
        assertEquals("There isn't any guest registered for that room.", lines[3]);
        checkoutCommand.execute(hotel);
        lines = outputStream.toString().split(System.lineSeparator());
        assertEquals("Passed Input is not a number.", lines[5]);
        checkoutCommand.execute(hotel);
        lines = outputStream.toString().split(System.lineSeparator());
        assertEquals("Room not found.\n", lines[7]);
    }
}
