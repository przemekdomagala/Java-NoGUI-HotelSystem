package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExitTest {
    ExitCommand exitCommand = new ExitCommand();
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    @Test
    void testExecute() throws FileNotFoundException {
        var hotel = new Hotel();
        System.setOut(new PrintStream(outputStream));
        exitCommand.execute(hotel);
        String[] lines = outputStream.toString().split(System.lineSeparator());
        assertEquals("System closed.", lines[0]);
    }
}
