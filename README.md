# LukesJukeBox
Simple JukeBox functionality

To run this project just execute the "LukeJukeBox.jar" file in the project root.

There is lots more functionality still needed to complete this Jukebox application but I ran out of time. Right now only mp3 files have been tested. To add new songs, place audio files in the "src\JukeBox\songs" folder and they will be picked up automatically and added to the library. 

The applicaiton is split into two packages plus the directory that stores the audio files. The "AudioFiles" package is responsible for running different types of audio files. I only had time to complete mp3. However, it is very extensible becuase there is an abstract class called "AudioFile" that is used as a class factory which will instantiate and return the appropreate child class depending on the file type. All additional file types must extend this abstract class as well as add a "case" to the switch statement in the AudioFile's static "load" method. The JukeBox class stores everything as an abstract AudioFile. This abstraction makes adding new file types very easy. 

There are three seperate theads running concurrently. One to play music, one to update the user interface, and the main execution thread. 
