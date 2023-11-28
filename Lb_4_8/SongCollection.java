package Lb_4_8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SongCollection {
	    private ArrayList<Song> songs = new ArrayList<>();

	    // Add a song to the collection
	    public void addSong(Song song) {
	        songs.add(song);
	    }

	    // Calculate the total duration of the collection
	    public int calculateTotalDuration() {
	        int totalDuration = 0;
	        for (Song song : songs) {
	            totalDuration += song.getDurationInSeconds();
	        }
	        return totalDuration;
	    }

	    // Sort songs based on style
	    public void sortByStyle() {
	        Collections.sort(songs, Comparator.comparing(Song::getStyle));
	    }

	    // Find a song within a specified duration range
	    public ArrayList<Song> findSongInDurationRange(int minDuration, int maxDuration) {
	    	ArrayList<Song> foundedSongs = new ArrayList<>(); 
	        for (Song song : songs) {
	            int duration = song.getDurationInSeconds();
	            if (duration >= minDuration && duration <= maxDuration) {
	            	foundedSongs.add(song);
	            }
	        }
	     
	        return foundedSongs; // No matching song found
	    }

	    // Display all songs in the collection
	    public void displaySongs() {
	        for (Song song : songs) {
	            System.out.println(song);
	        }
	    }
	    
	    public int getCountOfSongs() {
	    	return this.songs.size();
	    }
	    
	    // Method to write the tracklist to a text file
	    public void writeTracklistToFile(String filePath) {
	    	Path currentRelativePath = Paths.get("");
	    	String s = currentRelativePath.toAbsolutePath().toString();
	    	String filename = "'C:\\Äëÿ ³ãðè\\\\'text.txt";
	        Path path = Paths.get(filename);
	        System.out.println(s+'\\'+filename);
	        try {
	            List<String> lines = new ArrayList<>();
	            for (Song song : songs) {
	                lines.add(song.toString());
	            }
	            Files.write(path, lines);
	            System.out.println("Tracklist written to file successfully.");
	        } catch (IOException e) {
	            System.out.println("Error writing tracklist to file: " + e.getMessage());
	        }
	    }

	    // Method to read the tracklist from a text file
	    public void readTracklistFromFile(String filePath) {
	        Path path = Paths.get(filePath);

	        try {
	            List<String> lines = Files.readAllLines(path);
	            songs.clear(); // Clear existing songs
	            for (String line : lines) {
	                Song song = Song.fromFileString(line);
	                songs.add(song);
	            }
	            System.out.println("Tracklist read from file successfully.");
	        } catch (IOException e) {
	            System.out.println("Error reading tracklist from file: " + e.getMessage());
	        }
	    }
	
}
