package thread;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ThreadImages implements Runnable {

    private String source;
    private List<Image> fxImages ;

    public ThreadImages(String source , List<Image> fxImages){

        this.source = source;   //stringa relativa all'immagine (dal bean) -> PATH!!!!!
        this.fxImages = fxImages;   //lista immagini
    }

    @Override
    public void run() {

        System.out.println("Nel Thread : " + Thread.currentThread().getName());
        try{
            //CREO una foto e la metto in fxImages
            BufferedImage img = ImageIO.read(new File(source)); //legge il path
            Image fxImg = SwingFXUtils.toFXImage(img,null);     //crea l'immagine a partire dal path

            synchronized (fxImages){
                fxImages.add(fxImg);        //aggiunge immagine creata alla lista delle immagini
            }


        } catch (IOException e) {
            System.out.println(" Exception while reading images' bytes");
            e.printStackTrace();
        }


    }
}
