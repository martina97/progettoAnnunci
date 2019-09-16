package thread;

import images.ImagesPath;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class ListImages {
    List<Image> fxImages = new ArrayList<>();
    ImagesPath myImage= new ImagesPath();

    public List<Image> loadImageList() {
        List<String> images = new ArrayList<String>();
        images.add(myImage.pathImage1);
        images.add(myImage.pathImage2);
        images.add(myImage.pathImage3);
        images.add(myImage.pathImage4);
        images.add(myImage.pathImage5);

        int size = images.size();

        Thread threadVector[] = new Thread[size];   //crea un vettore di thread (uno per immagine)

        for (int x = 0; x < size; x++) {

            threadVector[x] = new Thread(new ThreadImages(images.get(x), fxImages)); //all'i-esimo posto del vettore CREA un thread

            threadVector[x].setName("Thread " + x + " per il caricamento delle immagini");

            threadVector[x].start();        //parte il run

        }


        for (int x = 0; x < size; x++) {
            try {
                threadVector[x].join(); //for debugging
            } catch (InterruptedException e) {
                System.out.println("errore nella terminazione dei thread!");
                e.printStackTrace();
            }
        }

        return fxImages;
    }


}
