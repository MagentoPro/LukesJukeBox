# LukesJukeBox
Simple JukeBox functionality

To run this project just execte the "LukeJukeBox.jar" file in the project root.

There is lots of functionality still needed to be completed for this Jukebox application but I ran out of time. Right now only mp3 files have been tested. The applicaiton is split into two packages plus the directory to store the audio files. To add new songs, place audio files in the "src\JukeBox\songs" folder and they will be picked up automatically and added to the library. 

The "AudioFiles" package is responsible for running different types of audio files. I only had time to complete mp3. However, it is very extensible. There is an abstract class called AudioFile that is used as a class factory which will instantiate and return the appropreate child class depending on the file type. All additional file types must extend this abstract class and a case statment added to the switch in the AudioFile's "load" method. This makes adding new file types extreamly easy.
