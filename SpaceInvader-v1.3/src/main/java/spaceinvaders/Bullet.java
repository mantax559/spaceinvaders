package spaceinvaders;

import javax.swing.*;
import java.io.IOException;

public class Bullet {

    private final JFrame window;
    private final Sprite sprite;
    private final Player player;
    private final Listener listener;

    public JLabel BulletLabel;

    private boolean isActiveBullet = false;

    public Bullet(JFrame window, Sprite sprite, Player player, Listener listener) throws IOException {
        this.window = window;
        this.sprite = sprite;
        this.player = player;
        this.listener = listener;
        setBullet();
    }

    private void setBullet() throws IOException {
        BulletLabel = sprite.setJLabel(Commons.SPRITE_BULLET);
    }

    public void moveBullet() {
        moveActiveBullet();

        if (BulletLabel.getY() < 0) {
            setActiveBullet(false);
        }
    }

    private void moveActiveBullet() {
        if (listener.pushedSpace && !isActiveBullet) {
            setBulletPrimaryPosition(BulletLabel, player.SpaceshipLabel);
            addToTheWindow(BulletLabel);
            setActiveBullet(true);
        } else if (isActiveBullet) {
            move(BulletLabel, -Commons.BULLET_SPEED);
        }
    }

    private void setBulletPrimaryPosition(JLabel jLabel, JLabel jLabel1) {
        jLabel.setLocation(getCurrentLocationX(jLabel1),getCurrentLocationY(jLabel1));
    }

    private int getCurrentLocationX(JLabel jLabel) {
        return jLabel.getLocation().x;
    }

    private int getCurrentLocationY(JLabel jLabel) {
        return jLabel.getLocation().y;
    }

    private void addToTheWindow(JLabel jLabel) {
        window.add(jLabel);
    }

    protected void setActiveBullet(boolean activeBullet) {
        isActiveBullet = activeBullet;
        BulletLabel.setVisible(activeBullet);
    }

    private void move(JLabel jLabel, int i) {
        jLabel.setLocation(jLabel.getLocation().x, jLabel.getLocation().y + i);
    }
}