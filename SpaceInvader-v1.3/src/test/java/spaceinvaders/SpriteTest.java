package spaceinvaders;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class SpriteTest {

    @Test
    public void getImageDimensions() throws IOException {
        Sprite sprite = new Sprite();

        assertEquals(43, sprite.getImageWidth(Commons.SPRITE_ALIEN));
        assertEquals(29, sprite.getImageHeight(Commons.SPRITE_ALIEN));
    }
}