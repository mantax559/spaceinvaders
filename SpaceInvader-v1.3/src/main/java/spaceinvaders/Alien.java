package spaceinvaders;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.StrictMath.round;

public class Alien {

    private JFrame window;
    private Sprite sprite;
    public JLabel AlienLabel;

    private int alienDirection = 1;

    public ArrayList<JLabel> aliens = new ArrayList<JLabel>();

    public Alien() {
    }

    public Alien(JFrame window, Sprite sprite) throws IOException {
        this.window = window;
        this.sprite = sprite;
        setAliens();
    }

    public void moveAliens() throws IOException {
        verticalAliensMovement();
        horizontalAliensMovement();
    }

    private void verticalAliensMovement() throws IOException {
        if (alienDirection == 1 && aliens.get(aliens.size()-1).getLocation().x > Commons.WINDOW_WIDTH * 0.95 - sprite.getImageWidth(Commons.SPRITE_ALIEN)) {
            setAlienPositions(aliens, 0, Commons.WINDOW_HEIGHT / 20);
            alienDirection = -1;
        } else if (alienDirection == -1 && aliens.get(0).getLocation().x < Commons.WINDOW_WIDTH * 0.02) {
            setAlienPositions(aliens, 0, Commons.WINDOW_HEIGHT / 20);
            alienDirection = 1;
        }
    }

    private void horizontalAliensMovement() {
        if (alienDirection == 1) {
            setAlienPositions(aliens, Commons.ALIEN_SPEED, 0);
        } else if (alienDirection == -1) {
            setAlienPositions(aliens, -Commons.ALIEN_SPEED, 0);
        }
    }

    private void setAlienPositions(ArrayList<JLabel> list, int x, int y) {
        for (int i = 0; i < list.size(); i++) {
            setAlienPosition(list, i, x, y);
        }
    }

    private void setAlienPosition(ArrayList<JLabel> list, int i, int x, int y) {
        list.get(i).setLocation(getAlienPositionX(list, i) + x, getAlienPositionY(list, i) + y);
    }

    private int getAlienPositionX(ArrayList<JLabel> list, int i) {
        return list.get(i).getLocation().x;
    }

    private int getAlienPositionY(ArrayList<JLabel> list, int i) {
        return list.get(i).getLocation().y;
    }

    private void setAliens() throws IOException {
        for (int i = 0; i < Commons.ALIEN_QTY; i++) {
            setAlien(i);
            addToTheWindow(AlienLabel);
        }
    }

    private void setAlien(int i) throws IOException {
        AlienLabel = sprite.setJLabel(Commons.SPRITE_ALIEN);
        setPrimaryAlienPosition(AlienLabel, i);
    }

    private void setPrimaryAlienPosition(JLabel jLabel, int x) {
        jLabel.setLocation(getPrimaryLocationX(x),getPrimaryLocationY());
    }

    public int getPrimaryLocationX(int i) {
        return 60 * i + 10;
    }

    private int getPrimaryLocationY() {
        return (int) round(Commons.WINDOW_WIDTH * 0.05);
    }

    private void addToTheWindow(JLabel jLabel) {
        window.add(jLabel);
        aliens.add(jLabel);
    }
}