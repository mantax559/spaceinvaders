package spaceinvaders;

import javax.swing.*;
import java.io.IOException;

public class GameWindow extends JFrame {

    static JFrame window = new JFrame();

    public GameWindow() throws IOException {
        window.setTitle(Commons.WINDOW_METATILE);
        window.setSize(Commons.WINDOW_WIDTH, Commons.WINDOW_HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLayout(null);

        Listener listener = new Listener();

        Sprite sprite = new Sprite();

        Alien alien = new Alien(window, sprite);

        Player player = new Player(window, listener);

        Bullet bullet = new Bullet(window, sprite, player, listener);

        GamesRules gamesRules = new GamesRules(sprite, bullet, alien);

        window.addKeyListener(listener);
        window.setVisible(true);

        while (!gamesRules.isGameOver) {
            player.moveSpaceship();
            bullet.moveBullet();
            alien.moveAliens();
            gamesRules.rules();

            try {
                Thread.sleep(30);
            } catch (Exception e) {}

            window.repaint();
        }

        window.setTitle(Commons.WINDOW_METATILE_GAME_OVER);
    }
}