package Lb_4_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;



// Main class for the console program
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SongCollection songCollection = new SongCollection();

        // Sample songs
        songCollection.addSong(new Song("Song1", "Artist1", 180, "Pop"));
        songCollection.addSong(new Song("Song2", "Artist2", 220, "Rock"));
        songCollection.addSong(new Song("Song3", "Artist3", 150, "Pop"));

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a song");
            System.out.println("2. Calculate total duration");
            System.out.println("3. Sort songs by style");
            System.out.println("4. Find a songs in duration range");
            System.out.println("5. Display all songs");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add a song to the collection
                    System.out.print("Enter song title: ");
                    String title = scanner.next();
                    System.out.print("Enter artist name: ");
                    String artist = scanner.next();
                    System.out.print("Enter duration in seconds: ");
                    int duration = scanner.nextInt();
                    System.out.print("Enter style: ");
                    String style = scanner.next();
                    Song newSong = new Song(title, artist, duration, style);
                    songCollection.addSong(newSong);
                    System.out.println("Song added successfully!");
                    break;
                case 2:
                    // Calculate total duration of the collection
                    int totalDuration = songCollection.calculateTotalDuration();
                    System.out.println("Total duration of the collection: " + totalDuration + " seconds");
                    break;
                case 3:
                    // Sort songs by style
                    songCollection.sortByStyle();
                    System.out.println("Songs sorted by style.");
                    break;
                case 4:
                    // Find a song in a specified duration range
                    System.out.print("Enter minimum duration: ");
                    int minDuration = scanner.nextInt();
                    System.out.print("Enter maximum duration: ");
                    int maxDuration = scanner.nextInt();
                    
                  
                    ArrayList<Song> foundSong = songCollection.findSongInDurationRange(minDuration, maxDuration);
    
                    if (foundSong.size() > 0) {
                    	  for (Song song : foundSong) {
                              
                              System.out.println(song);
                          }
                    } else {
                        System.out.println("No song found in the specified duration range.");
                    }
                    break;
                case 5:
                    // Display all songs in the collection
                    System.out.println("Songs in the collection:");
                    songCollection.displaySongs();
                    break;
                case 6:
                    // Exit the program
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                case 7:
                    // Write tracklist to a text file
                    System.out.print("Enter file path to write tracklist: ");
                    String writeFilePath = scanner.next();
                    songCollection.writeTracklistToFile(writeFilePath);
                    break;
                case 8:
                    // Read tracklist from a text file
                    System.out.print("Enter file path to read tracklist: ");
                    String readFilePath = scanner.next();
                    songCollection.readTracklistFromFile(readFilePath);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

