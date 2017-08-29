/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AudioFiles;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.embed.swing.JFXPanel;
import javafx.util.Duration;
/**
 *
 * @author Luke
 */
public class Mp3 extends AudioFile
{

    private MediaPlayer mediaPlayer;
            
    public Mp3(File file)
    {
        final JFXPanel fxPanel = new JFXPanel();
        try{
            this.file = file;
            String bip = file.getAbsolutePath();
            Media hit = new Media(new File(bip).toURI().toString());
            this.mediaPlayer = new MediaPlayer(hit);
        }
        catch(Exception ex) {
            //TODO... throw new custom fileLoad exception
        }
    }
    
    public void play()
    {   
        mediaPlayer.play();  
        state = PLAYERSTATE.PLAY;
        mediaPlayer.setOnEndOfMedia(
            new Runnable() {
                @Override public void run() {
                  mediaPlayer.stop();
                  state = PLAYERSTATE.STOP;
                  System.out.print("song ended");
                }
            }
        );
    }
    
    public void stop()
    {
        mediaPlayer.stop();
    }
    
    public void pause()
    {
        try{
            mediaPlayer.wait();
        }
       catch(Exception ex){
           //TODO... throw new custom fileLoad exception
       }
    }
    
    public double getTimer()
    {
        Duration dur = mediaPlayer.getCurrentTime();
        return dur.toSeconds();
    }
    
    public String getName()
    {
        return file.getName();
    }
    
    public double getMaxPlayTime()
    {
        Duration dur = mediaPlayer.getTotalDuration();
        return dur.toSeconds();
    }
}
