package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoomTest {
    @Test
    void roomTest(){
        Room room = new Room();
        room.setRoomNumber(15000);
        room.setDescription("DESCRIPTION");
        room.setPrice(9999999);
        assertEquals(15000, room.getRoomNumber());
        assertEquals("DESCRIPTION", room.getDescription());
        assertEquals(9999999, room.getPrice());
    }
}
