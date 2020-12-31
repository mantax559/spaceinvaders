package spaceinvaders;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Sprite {

    protected JLabel setJLabel(String src) throws IOException {
        JLabel jLabel = new JLabel(new ImageIcon(setBufferedImage(src)));
        setJLabelSize(jLabel, src);
        return jLabel;
    }

    private BufferedImage setBufferedImage(String src) throws IOException {
        return ImageIO.read(new FileInputStream(src));
    }

    private void setJLabelSize(JLabel jLabel, String src) throws IOException {
        jLabel.setSize(getImageWidth(src),getImageHeight(src));
    }

    protected int getImageWidth(String src) throws IOException {
        return ImageIO.read(new FileInputStream(src)).getWidth();
    }

    protected int getImageHeight(String src) throws IOException {
        return ImageIO.read(new FileInputStream(src)).getHeight();
    }
}