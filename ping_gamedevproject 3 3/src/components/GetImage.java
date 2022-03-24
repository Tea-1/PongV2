package components;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.*;

public class GetImage {

    public static BufferedImage retrieve(String in) { // 'in' formatted as filename.jpg
        BufferedImage out = null;
        try {
            out = ImageIO.read(new File("./images/" + in));
        } catch (IOException e) {
            //System.out.println("unable to retrieve " + in);
            System.out.println(e);
        }
        return out;
    }

    /*
    public static BufferedImage retrieve(String path) { //old function broke on windows so had to make this temporary fix
        try {
            File pathToFile = new File(path);
            BufferedImage image = ImageIO.read(pathToFile);
            return image;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    } */



    /* Main method to test 
    public static void main(String[] args) {
        if(retrieve("ball.jpg") == null){
            System.out.println("failed");
        } else {
            System.out.println("success");
        }
    }*/
}