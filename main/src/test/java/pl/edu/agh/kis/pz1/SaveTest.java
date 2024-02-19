package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SaveTest {
    @Test
    void testExecute() throws IOException {
        SaveCommand saveCommand = new SaveCommand();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Hotel hotel = new Hotel();
        saveCommand.execute(hotel);
        String[] lines = outputStream.toString().split(System.lineSeparator());
        assertEquals("Data Saved", lines[0]);
    }
}
