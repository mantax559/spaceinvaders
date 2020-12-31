package spaceinvaders;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Listener implements KeyListener {

    public boolean pushedLeft = false;
    public boolean pushedRight = false;
    public boolean pushedSpace = false;

    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            setPushedLeft(true);
        } else if (key == KeyEvent.VK_RIGHT) {
            setPushedRight(true);
        } else if (key == KeyEvent.VK_SPACE) {
            setPushedSpace(true);
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            setPushedLeft(false);
        } else if (key == KeyEvent.VK_RIGHT) {
            setPushedRight(false);
        } else if (key == KeyEvent.VK_SPACE) {
            setPushedSpace(false);
        }
    }

    private void setPushedLeft(boolean pushedLeft) {
        this.pushedLeft = pushedLeft;
    }

    private void setPushedRight(boolean pushedRight) {
        this.pushedRight = pushedRight;
    }

    private void setPushedSpace(boolean pushedSpace) {
        this.pushedSpace = pushedSpace;
    }
}