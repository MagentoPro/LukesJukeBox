/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AudioFiles;
import java.io.File;

/**
 *
 * @author Luke
 */
public class Wav extends AudioFile
{
    
    public Wav(File file)
    {
        //this.filePath = filePath;
    }
    
    public void play() {}
    public void stop() {}
    public void pause() {}
    public double getTimer() { return (double)123; }
    public String getName() { return "name"; }
    public double getMaxPlayTime() { return (double)123; }
}
