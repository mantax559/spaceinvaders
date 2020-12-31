package spaceinvaders;

import javax.swing.*;
import java.io.IOException;

public class Player extends Sprite{

    private JFrame window;
    private Listener listener;

    public JLabel SpaceshipLabel;

    public Player(JFrame window, Listener listener) throws IOException {
        this.window = window;
        this.listener = listener;
        setPlayer();
    }

    public Player() {}

    public void moveSpaceship() {
        if (listener.pushedLeft) {
            move(SpaceshipLabel, -Commons.PLAYER_SPEED);
        } else if (listener.pushedRight) {
            move(SpaceshipLabel, Commons.PLAYER_SPEED);
        }
    }

    private void setPlayer() throws IOException {
        SpaceshipLabel = setJLabel(Commons.SPRITE_SPACESHIP);
        setPlayerPosition(SpaceshipLabel);
        addToTheWindow(SpaceshipLabel);
    }

    private void setPlayerPosition(JLabel jLabel) throws IOException {
        jLabel.setLocation(getPrimaryLocationX(),getPrimaryLocationY());
    }

    private int getPrimaryLocationX() throws IOException {
        return (int) ((Commons.WINDOW_WIDTH - getImageWidth(Commons.SPRITE_SPACESHIP)) * 0.5);
    }

    protected int getPrimaryLocationY() throws IOException {
        return (int) (Commons.WINDOW_HEIGHT - Commons.WINDOW_HEIGHT * 0.15 - getImageHeight(Commons.SPRITE_SPACESHIP));
    }

    private void addToTheWindow(JLabel jLabel) {
        window.add(jLabel);
    }

    private void move(JLabel jLabel, int i) {
        jLabel.setLocation(jLabel.getLocation().x + i, jLabel.getLocation().y);
    }
}