package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {
    @Test
    void TestHotel() throws FileNotFoundException {
        Hotel hotel = new Hotel();
        assertFalse(hotel.contains(1));
        assertTrue(hotel.contains(0));
        Room room = new Room();
        assertNotNull(hotel.getRoom(1));
        assertNotEquals(room, hotel.getRoom(0));
        MyMap<Room, String> hotelMap = hotel.getHotelMap();
        for(var key: hotelMap.keys()){
            if(!(hotelMap.get(key).equals("none"))){
                hotelMap.put(key, "none");
            }
        }
        assertEquals("none", hotelMap.get(hotel.getRoom(1)));
    }
}
