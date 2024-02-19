package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;

class SystemTest {
    @Test
    void systemTest() throws IOException {
        SystemHandler systemHandler = new SystemHandler();
        Hotel hotel = new Hotel();
        systemHandler.execute(1, hotel);
        systemHandler.execute(5, hotel);
        systemHandler.execute(6, hotel);
        systemHandler.execute(7, hotel);
        assertFalse(systemHandler.isPickAnother());
    }
}
