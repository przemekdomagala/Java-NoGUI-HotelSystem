package pl.edu.agh.kis.pz1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMapTest {

    @Test
    void mapTest(){
        MyMap<Integer, String> map = new MyMap<>();
        map.put(2, "aaa");
        assertEquals("aaa", map.get(2));
        assertNotNull(map.keys());
        assertNotNull(map.listOfKeys);
        assertNotNull(map.listOfValues);
        assertTrue(map.contains(2));
        assertTrue(map.remove(2));
    }
}