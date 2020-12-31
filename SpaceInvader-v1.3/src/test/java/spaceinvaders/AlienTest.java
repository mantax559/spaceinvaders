package spaceinvaders;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlienTest {

    @Test
    public void getPrimaryLocationTest() {
        Alien alien = new Alien();

        assertEquals(-110, alien.getPrimaryLocationX(-2));
        assertEquals(-50, alien.getPrimaryLocationX(-1));
        assertEquals(10, alien.getPrimaryLocationX(0));
        assertEquals(70, alien.getPrimaryLocationX(1));
        assertEquals(130, alien.getPrimaryLocationX(2));
    }
}