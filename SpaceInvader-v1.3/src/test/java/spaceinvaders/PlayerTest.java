package spaceinvaders;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void getPrimaryLocationTest() throws IOException {
        Player player = new Player();

        assertEquals(317, player.getPrimaryLocationY());
    }
}