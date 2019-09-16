package Utilities;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ThreadPhotos implements Runnable {

    private String source;
    private Image image;

    public  ThreadPhotos(String source, Image image) {

        this.source = source;
        this.image = image;
    }

    @Override
    public void run() {

        System.out.println("Nel Thread : " + Thread.currentThread().getName());

        try {
            BufferedImage img = ImageIO.read(new File(source));
            Image fxImg = SwingFXUtils.toFXImage(img,null);

            synchronized (image) {
                image = fxImg;
            }
        } catch (IOException e) {
            System.out.println(" Exception while reading images' bytes");
            e.printStackTrace();
        }

    }
}
