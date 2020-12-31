package spaceinvaders;

import java.io.IOException;

public class GamesRules {

    private final Sprite sprite;
    private final Bullet bullet;
    private final Alien alien;

    private int aliensKilled = 0;
    protected boolean isGameOver = false;

    public GamesRules(Sprite sprite, Bullet bullet, Alien alien) {
        this.sprite = sprite;
        this.bullet = bullet;
        this.alien = alien;
    }

    public void rules() throws IOException {

        for (int i = 0; i < alien.aliens.size(); i++) {
            if (bulletIsInsideTheAlien(i)) {
                aliensKilled++;
                alien.aliens.get(i).setVisible(false);
                alien.aliens.remove(alien.aliens.get(i));
                bullet.setActiveBullet(false);
            }
        }

        if (aliensKilled == Commons.ALIEN_QTY) {
            isGameOver = true;
        }
    }

    public boolean bulletIsInsideTheAlien(int i) throws IOException {
        return getBulletLocationX() >= getAlienLocationX(i) && getBulletLocationX() <= getAlienLocationX(i) + sprite.getImageWidth(Commons.SPRITE_ALIEN) && getBulletLocationY() >= getAlienLocationY(i) && getBulletLocationY() <= getAlienLocationY(i) + sprite.getImageHeight(Commons.SPRITE_ALIEN);
    }

    private int getBulletLocationX () throws IOException {
        return bullet.BulletLabel.getLocation().x + sprite.getImageWidth(Commons.SPRITE_BULLET) / 2;
    }

    private int getBulletLocationY () throws IOException {
        return bullet.BulletLabel.getLocation().y + sprite.getImageHeight(Commons.SPRITE_BULLET) / 2;
    }

    private int getAlienLocationX (int i) {
        return alien.aliens.get(i).getLocation().x;
    }

    private int getAlienLocationY (int i) {
        return alien.aliens.get(i).getLocation().y;
    }
}
