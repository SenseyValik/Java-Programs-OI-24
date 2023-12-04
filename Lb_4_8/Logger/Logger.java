package Lb_4_8.Logger;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


public class Logger {
	   private static final String LOGS_FOLDER = "logs";
	 

	    public Logger() {
	        createLogsFolder();
	    }

	    private void createLogsFolder() {
	        Path logsFolderPath = Paths.get(LOGS_FOLDER);

	        if (!Files.exists(logsFolderPath)) {
	            try {
	                Files.createDirectory(logsFolderPath);
	            } catch (IOException e) {
	                e.printStackTrace();
	                System.err.println("Error creating logs folder: " + e.getMessage());
	            }
	        }
	    }

	    public void log(String action,String message) {
	    	String patternDate = "yyyy-MM-dd"; //filename
	    	String patternDateTime = "yyyy-MM-dd HH:mm:ss"; //action execute time
	    	
	    	
	    	DateFormat dateFormat = new SimpleDateFormat(patternDate);
	    	DateFormat dateTimeFormat = new SimpleDateFormat(patternDateTime);
	    	
	    	String logFileName = dateFormat.format(new Date()) + ".log";
	    	
	        Path logFilePath = Paths.get(LOGS_FOLDER, logFileName);
	        String formattedMessage = "time [" + dateTimeFormat.format(new Date()) + "] action [" + action + "]  message [" + message +"]"+ System.lineSeparator();

	        try {
	            Files.write(logFilePath, formattedMessage.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.err.println("Error writing to log file: " + e.getMessage());
	        }
	    }
	    
	

	 
	    

}




