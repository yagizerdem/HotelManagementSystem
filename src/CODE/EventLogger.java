package CODE;

import UI.ErrorScreen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import static CODE.Utility.getExceptionAsString;

public class EventLogger {

    public static void log(String message , String type){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String dateTimeNow = dateFormat.format(date).replace("/" ,"_");

        // creating logging folder
        File theDir = new File(StaticDetails.LogFolderPath + "\\" + type +"\\"+ dateTimeNow);
        boolean RecoredsExist = theDir.exists();
        if(!RecoredsExist){
            try{
                theDir.mkdir();
            }catch (Exception ex){
                String errorMessage = getExceptionAsString(ex);
                new ErrorScreen("Something went wrog contack with It workers \n\n " + errorMessage);
            }
        }
        //

        // crate log file
        File logFile = new File(theDir + "\\" + LocalDateTime.now().toString().replace(":","_") );
        try {
            if (logFile.createNewFile()) {
                System.out.println("File created: " + logFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        // write log file
        try {
            // Create a FileWriter object with the specified file name
            FileWriter fileWriter = new FileWriter(logFile);

            // Wrap the FileWriter with BufferedWriter for efficient writing
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write data to the file
            bufferedWriter.write(message);

            // Close the BufferedWriter to ensure data is flushed to the file
            bufferedWriter.close();

            System.out.println("Data has been written to the file.");

        } catch (IOException e) {
            // Handle exceptions, such as FileNotFound or IOException
            e.printStackTrace();
        }


    }
}
