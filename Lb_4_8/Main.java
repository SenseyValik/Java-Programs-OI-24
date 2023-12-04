package Lb_4_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import Lb_4_8.Logger.*;
import Lb_4_8.Song.*;


// Main class for the console program
public class Main {
	
	public static Logger logger = new Logger();

	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SongCollection songCollection = new SongCollection(); 

        
        songCollection.readTracklistFromFile("liked.txt", false);
       
        if(songCollection.getCountOfSongs() == 0) {
        	 System.out.println("\nInit default file:");
        	 // Sample songs
            songCollection.addSong(new Song("Кожен новий день", "Epolets", 180, "Rock"));
            songCollection.addSong(new Song("Bounce", "Oliver tree", 220, "Pop"));
            songCollection.addSong(new Song("Highway to hell", "AC/DC", 150, "Rock"));
            songCollection.addSong(new Song("Казка", "Epolets", 150, "Rock"));
            songCollection.addSong(new Song("With you", "Oliver tree", 220, "Pop"));
            songCollection.addSong(new Song("All eyez on me", "2pac", 130, "Rap"));
            songCollection.writeTracklistToFile("liked.txt");
            songCollection.displaySongs();
        }
       
        String filename;
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a song");
            System.out.println("2. Calculate total duration");
            System.out.println("3. Sort songs by style");
            System.out.println("4. Find a songs in duration range");
            System.out.println("5. Display all songs");
            System.out.println("6. Write track list to file");
            System.out.println("7. Read track list from file");
            System.out.println("8. Clear list");
            System.out.println("99. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    // Add a song to the collection
                    System.out.print("Enter song title:\n");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist name:\n");
                    String artist = scanner.nextLine();
                    System.out.print("Enter duration in seconds:\n");
                    int duration = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter style:\n");
                    String style = scanner.nextLine();
                    Song newSong = new Song(title, artist, duration, style);
                    songCollection.addSong(newSong);
                    System.out.println("Song added successfully!");
                    logger.log(Action.Add.name(),newSong.toString());
                    break;
                case 2:
                    // Calculate total duration of the collection
                    int totalDuration = songCollection.calculateTotalDuration();
                    System.out.println("Total duration of the collection: " + totalDuration + " seconds");
                    logger.log(Action.CalculateTotalDuration.name(),"Total duration of the collection: " + totalDuration + " seconds");
                    break;
                case 3:
                    // Sort songs by style
                    songCollection.sortByStyle();
                    System.out.println("Songs sorted by style.");
                    logger.log(Action.Sort.name(),"Songs sorted by style.");
                    break;
                case 4:
                    // Find a song in a specified duration range
                    System.out.print("Enter minimum duration: ");
                    int minDuration = scanner.nextInt();
                    System.out.print("Enter maximum duration: ");
                    int maxDuration = scanner.nextInt();
                    
                  
                    ArrayList<Song> foundSong = songCollection.findSongInDurationRange(minDuration, maxDuration);
                    String logMessage = "minimum duration " + minDuration + " maximum duration " + maxDuration+"";
                    if (foundSong.size() > 0) {
                    	  for (Song song : foundSong) {
                              
                              System.out.println(song);
                              logMessage += song+" ";
                          }
                    } else {
                        System.out.println("No song found in the specified duration range.");
                        logMessage += "No song found in the specified duration range.";
                    }
                    logger.log(Action.FindSongInDurationRange.name(),logMessage);
                    break;
                case 5:
                    // Display all songs in the collection
                    System.out.println("Songs in the collection:");
                    songCollection.displaySongs();
                    break;
                case 6:
                    // Write tracklist to a text file
                    System.out.print("Enter file filename to write tracklist:\n");
                    filename = scanner.nextLine();
                    filename = filename+".txt";
                    songCollection.writeTracklistToFile(filename);
                    break;
                case 7:
                    // Read tracklist from a text file
                    System.out.print("Enter file path to read tracklist:\n");
                    filename = scanner.nextLine();
                    filename = filename+".txt";
                    songCollection.readTracklistFromFile(filename, true);
                    break;
                case 8:
                	songCollection.clearList();
                	 logger.log(Action.ClearList.name(),"Clear List");
                    break;
                case 99:
                    // Exit the program
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

