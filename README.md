# LukesJukeBox
Simple JukeBox functionality

To run this project just execute the "LukeJukeBox.jar" file in the project root.

There is lots of functionality still needed to be completed for this Jukebox application but I ran out of time. Right now only mp3 files have been tested. The applicaiton is split into two packages plus the directory to store the audio files. To add new songs, place audio files in the "src\JukeBox\songs" folder and they will be picked up automatically and added to the library. 

The "AudioFiles" package is responsible for running different types of audio files. I only had time to complete mp3. However, it is very extensible becuase there is an abstract class called "AudioFile" that is used as a class factory which will instantiate and return the appropreate child class depending on the file type. All additional file types must extend this abstract class as well as add a "case" to the switch statement in the AudioFile's "load" method. This abstraction makes adding new file types very easy. The JukeBox class stores everything as the abstract AudioFile.

There are three seperate theads running concurrently. One to play music, one to update the user interface, and the main execution thread. 
