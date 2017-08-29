/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JukeBox;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import javax.swing.DefaultListModel;
import AudioFiles.AudioFile;


/**
 *
 * @author Luke
 */
public class JukeBox
{
    public static List<AudioFile> playlist;
    public static List<AudioFile> library;
    public static AudioFile currentAudio;
    public static int songIndex;
    //public static int tokens;
    
    public JukeBox()
    {
        library = new ArrayList<AudioFile>();
        playlist = new ArrayList<AudioFile>();
        songIndex = 0;
        loadLibrary();
    }
    
    private void loadLibrary()
    {
        File dir = new File("src/JukeBox/songs");
        File[] directoryListing = dir.listFiles();
        for (File file : directoryListing) {
            AudioFile song = AudioFile.load(file);
            library.add(song);
        }
    }
    
    public DefaultListModel getLibraryList()
    {
        DefaultListModel<String> songNames = new DefaultListModel<>();
        for (AudioFile song : library) {
            songNames.addElement(song.getFile().getName());
        }
        return songNames;
    }
    
    public void addToPlayList(String fileName)
    {
        File af = new File("src/JukeBox/songs/"+fileName);
        AudioFile song = AudioFile.load(af);
        playlist.add(song);
    }
    
    public DefaultListModel getPlayList()
    {
        DefaultListModel<String> songNames = new DefaultListModel<>();
        for (AudioFile song : playlist) {
            songNames.addElement(song.getFile().getName());
        }
        return songNames;
    }
    
    public void removeFromPlayList(String fileName)
    {
        AudioFile af = null;
        for (AudioFile song : playlist) {
            String test = song.getName();
            if(fileName.equals(test)) {
                af = song;
            }   
        }
        playlist.remove(af);
    }
    
    public void startPlayList()
    {
        currentAudio = playlist.get(songIndex);
        Thread t = new Thread() {
            public void run() {
                //int index = 0;
                currentAudio = playlist.get(songIndex);
                currentAudio.play();

                while(currentAudio.state == AudioFile.PLAYERSTATE.PLAY || currentAudio.state == AudioFile.PLAYERSTATE.PAUSE) {
                    try {
                        //double songTimer = currentAudio.getTimer();
                        if(currentAudio.state == AudioFile.PLAYERSTATE.PAUSE)
                            currentAudio.pause();
                        else
                            currentAudio.play();
                        Thread.sleep(1000);
                    }
                    catch(Exception ex) {}
                }
                try{
                    songIndex++;
                    startPlayList();
                }
                catch(IndexOutOfBoundsException ex) {}
            }
        };
        t.start();
    }
    
    public void pauseAudio()
    {
        //try {
            currentAudio.state = AudioFile.PLAYERSTATE.PAUSE;
            currentAudio.pause();
        //}
        //catch(Exception ex) {}
    }
}
