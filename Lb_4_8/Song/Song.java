package Lb_4_8.Song;

//Song class representing a musical composition
public class Song {
	 private String title;
	 private String artist;
	 private int durationInSeconds;
	 private String style;
	
	 // Constructor
	 public Song(String title, String artist, int durationInSeconds, String style) {
	     this.title = title;
	     this.artist = artist;
	     this.durationInSeconds = durationInSeconds;
	     this.style = style;
	 }
	
	 // Getter methods
	
	 public String getTitle() {
	     return title;
	 }
	
	 public String getArtist() {
	     return artist;
	 }
	
	 public int getDurationInSeconds() {
	     return durationInSeconds;
	 }
	
	 public String getStyle() {
	     return style;
	 }
	
	 // Override toString method for informative output
	 @Override
	 public String toString() {
	     return "Title: " + title + ", Artist: " + artist + ", Duration: " + durationInSeconds + "s, Style: " + style;
	 }
	
	public static Song fromFileString(String line) {
		String[] words = line.split("_#_");
		// TODO Auto-generated method stub
		return new Song(words[0], words[1], Integer.parseInt(words[2]), words[3]);
	}
	
	public String getlineForWrite() {
		 return title + "_#_" + artist + "_#_" + durationInSeconds + "_#_" + style;
	}

}
