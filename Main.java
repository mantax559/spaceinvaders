import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import java.util.*;
import javax.swing.*;

public class Main extends JFrame {

    static JFrame window = new JFrame();
    static JLabel spaceshipLabel;
    static boolean pushedLeft = false, pushedRight = false;
    static boolean isGameOver = false;
    static ArrayList<JLabel> bullets = new ArrayList<JLabel>();
    static ArrayList<JLabel> enemies = new ArrayList<JLabel>();
    static BufferedImage spaceshipImg, bulletImg, enemyImg;

    public static void main (String[] args) throws InterruptedException {
        window.setSize(600,400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);


        try {
            spaceshipImg = ImageIO.read(new FileInputStream("img/spaceship.png"));
            bulletImg = ImageIO.read(new FileInputStream("img/bullet.png"));
            enemyImg = ImageIO.read(new FileInputStream("img/enemy.png"));

            spaceshipLabel = new JLabel(new ImageIcon(spaceshipImg));
            spaceshipLabel.setSize(50,50);
            spaceshipLabel.setLocation(275,325);
        } catch (Exception e) { System.out.println("Image not found."); }

        for (int i = 0; i < 9; i++) {
            JLabel enemy = new JLabel(new ImageIcon(enemyImg));
            enemy.setSize(50,50);
            enemy.setLocation(40 + (60 * i), 25);
            window.add(enemy);
            enemy.setVisible(true);
            enemies.add(enemy);
        }

        window.add(spaceshipLabel);
        window.addKeyListener(new Listener());
        window.setVisible(true);
        JLabel label1 = new JLabel("Test");

        window.setTitle("3");
        Thread.sleep(1000);
        window.setTitle("2");
        Thread.sleep(1000);
        window.setTitle("1");
        Thread.sleep(1000);
        window.setTitle("GOO!!!");
        Thread.sleep(1000);
        window.setTitle("Space Invaders");

        int enemyDirection = 1;
        while (true) {
            if (pushedLeft == true) {
                spaceshipLabel.setLocation(spaceshipLabel.getLocation().x-10,spaceshipLabel.getLocation().y);
                spaceshipLabel.setVisible(true);
            }
            if (pushedRight == true) {
                spaceshipLabel.setLocation(spaceshipLabel.getLocation().x+10,spaceshipLabel.getLocation().y);
                spaceshipLabel.setVisible(true);
            }

            ArrayList<JLabel> bulletsOutOfBounds = new ArrayList<JLabel>();
            for (int i = 0; i < bullets.size(); i++) {
                int bulletLocationX = bullets.get(i).getLocation().x;
                int bulletLocationY = bullets.get(i).getLocation().y;
                if (bulletLocationY < 0) {
                    bulletsOutOfBounds.add(bullets.get(i));
                }
                bullets.get(i).setLocation(bulletLocationX,bulletLocationY-10);
                bullets.get(i).setVisible(true);
            }

            if (enemyDirection == 1 && enemies.get(enemies.size()-1).getLocation().x > 540) {
                enemyMovement(0,20);
                enemyDirection = -1;
            } else if (enemyDirection == -1 && enemies.get(0).getLocation().x < 10) {
                enemyMovement(0,20);
                enemyDirection = 1;
            } else if (enemyDirection == 1) {
                enemyMovement(5,0);
            } else if (enemyDirection == -1) {
                enemyMovement(-5,0);
            }

            ArrayList<JLabel> enemiesKilled = new ArrayList<JLabel>();
            for (int u = 0; u < bullets.size(); u++) {
                int bulletLocationX = bullets.get(u).getLocation().x + 10;
                int bulletLocationY = bullets.get(u).getLocation().y + 10;
                for (int q = 0; q < enemies.size(); q++) {
                    int enemyLocationX = enemies.get(q).getLocation().x;
                    int enemyLocationY = enemies.get(q).getLocation().y;
                    if (bulletLocationX >= enemyLocationX && bulletLocationX <= enemyLocationX + 50 && bulletLocationY >= enemyLocationY && bulletLocationY <= enemyLocationY+50) {
                        bullets.get(u).setVisible(false);
                        bulletsOutOfBounds.add(bullets.get(u));
                        enemies.get(q).setVisible(false);
                        enemiesKilled.add(enemies.get(q));
                    }
                    if (enemyLocationX <= spaceshipLabel.getLocation().x && enemyLocationX + 50 >= spaceshipLabel.getLocation().x && enemyLocationY <= spaceshipLabel.getLocation().y && enemyLocationY + 50 >= spaceshipLabel.getLocation().y) {
                        isGameOver = true;
                    }
                }
            }

            bullets.removeAll(bulletsOutOfBounds);
            enemies.removeAll(enemiesKilled);
            if (enemies.size() == 0 || isGameOver == true) {
                for (int u = 0; u < bullets.size(); u++) {
                    bullets.get(u).setVisible(false);
                }
                spaceshipLabel.setVisible(true);
                spaceshipLabel.setLocation(300-25, 200-25);
                if (isGameOver) {
                    while(true) {
                        window.setTitle("YOU LOST!");
                        Thread.sleep(1000);
                        window.setTitle("");
                        Thread.sleep(1000);
                    }
                } else {
                    while(true) {
                        window.setTitle("YOU WIN!");
                        Thread.sleep(1000);
                        window.setTitle("");
                        Thread.sleep(1000);
                    }
                }
            }

            try { Thread.sleep(60); } catch (Exception e) { }
            window.repaint();
        }
    }

    public static void enemyMovement(int x, int y) {
        for (int j = 0; j < enemies.size(); j++) {
            enemies.get(j).setLocation(enemies.get(j).getLocation().x+x,enemies.get(j).getLocation().y+y);
        }
    }

    static class Listener implements KeyListener {
        public void keyTyped(KeyEvent e) { }
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                pushedLeft = true;
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                pushedRight = true;
            } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                JLabel bulletLabel = new JLabel(new ImageIcon(bulletImg));
                bulletLabel.setSize(5,5);
                bulletLabel.setLocation(spaceshipLabel.getLocation().x+24, spaceshipLabel.getLocation().y+30);
                window.add(bulletLabel);
                bullets.add(bulletLabel);
            }
        }
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                pushedLeft = false;
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                pushedRight = false;
            }
        }
    }
}
