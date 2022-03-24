package run;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class App {
    public static void main(String[] args) throws Exception {
        Main.createWindow();

        /*while (true) {
            Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
            File file = new File(path + "src/1.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
            Thread.sleep(12000);
        } */

    }
}
