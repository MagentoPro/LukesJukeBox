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
public abstract class AudioFile 
{
    //protected String filePath;
    //protected String name;
    protected File file;
    public enum PLAYERSTATE { PLAY, PAUSE, STOP }
    public PLAYERSTATE state;
    
    public abstract void play();
    public abstract void stop();
    public abstract void pause();
    public abstract double getTimer();
    public abstract String getName();
    public abstract double getMaxPlayTime();
    
    public static AudioFile load(File file)
    {
        AudioFile song = null;
        String fileType = getFileType(file.getName());
        //use a switch statment to check file type and load mps or wave
        switch(fileType) {
            case "mp3":
                song = new Mp3(file);
                break;
            case "wav":
                song = new Wav(file);
                break;
            default :
                song = new Mp3(file);
                break;
        }
        
        return song;
    }
    
    public File getFile()
    {
        return this.file;
    }
    
    private static String getFileType(String fileName)
    {
        String extension = "";

        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i+1);
        }
        
        return extension;
    }
//    public void setName(String name)
//    {
//        this.name = name;
//    }
//    public String getName()
//    {
//        return name;
//    }
}
