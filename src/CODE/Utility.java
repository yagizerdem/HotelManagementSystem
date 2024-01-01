package CODE;
import UI.ErrorScreen;

import java.io.*;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files
import java.nio.file.*;
public class Utility {

    public static String ReadFile(String path){
        StringBuilder content = new StringBuilder();
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                content.append(data).append("\n");
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return  content.toString();
    }

    public static Integer GenerateRandomId(){
        return  (int)Math.random() * 1000000;
    }

    public static String[] getPropertyNames(Class<?> clazz) {
        List<String> propertyNames = new ArrayList<>();

        // Get all fields of the class, including inherited fields
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            // Exclude synthetic fields, which are compiler-generated
            if (!field.isSynthetic()) {
                propertyNames.add(field.getName());
            }
        }
        return propertyNames.toArray(new String[0]);
    }

    public static String getStringPropertyValue(Object obj, String propertyName) {
        try {
            Field field = obj.getClass().getDeclaredField(propertyName);
            field.setAccessible(true); // Enable access to private fields

            Object value = field.get(obj);
            if(value.getClass().isArray()){
                String temp = "";
                for(String item : (String[]) value){
                    temp += item + " ";
                }
                value = temp;
            }
            // Ensure that the value is not null before attempting to convert to String
            if (value != null) {
                return value.toString();
            } else {
                return null; // Or handle the case where the property is null
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace(); // Handle the exception appropriately
            return null;
        }
    }

    public static int findIndex(String[] array, String targetValue) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(targetValue)) {
                return i; // Found the index
            }
        }
        return -1; // Value not found in the array
    }


    public static void BackupDatabase(){
        File theDir = new File("C:\\Users\\yagiz\\Desktop\\HotelManagementSystem\\DatabaseBackup\\Records");
        boolean RecoredsExist = theDir.exists();
        if(!RecoredsExist){
            try{
                theDir.mkdir();
            }catch (Exception ex){
                String message = getExceptionAsString(ex);
                new ErrorScreen("Something went wrog contactk with It workers \n\n " + message);
            }
        }
        // crating record dir
        File recordDir = new File(theDir,"Record" + LocalDateTime.now().toString().replace(":","_"));
        RecoredsExist = recordDir.exists();
        if(!RecoredsExist){
            try{
                recordDir.mkdir();
            }catch (Exception ex){
                String message = getExceptionAsString(ex);
                new ErrorScreen("Something went wrog contactk with It workers \n\n " + message);
            }
        }

        // back up database files
        String CONTEXTPATH = "C:\\Users\\yagiz\\Desktop\\HotelManagementSystem\\src\\CONTEXT";
        File CONTEXTDIRECTORY = new File(CONTEXTPATH);
        String[] list = CONTEXTDIRECTORY.list();
        for(String item : list){
            Path  sourecePath = Paths.get(CONTEXTPATH + "\\" + item);
            Path  destinationPath = Paths.get(recordDir +"\\" + item);
            try {
                Files.copy(sourecePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            }catch (Exception ex){
                String message = getExceptionAsString(ex);
                new ErrorScreen("Something went wrog contactk with It workers \n\n " + message);
            }
        }
    }

    private static String getExceptionAsString(Throwable throwable) {
        // Create a StringBuilder to build the exception information
        StringBuilder exceptionInfo = new StringBuilder();

        // Append the exception message
        exceptionInfo.append("Exception Message: ").append(throwable.getMessage()).append("\n");

        // Append the stack trace
        exceptionInfo.append("Stack Trace:\n");
        for (StackTraceElement element : throwable.getStackTrace()) {
            exceptionInfo.append(element).append("\n");
        }

        // If there is a cause, append its information recursively
        Throwable cause = throwable.getCause();
        if (cause != null) {
            exceptionInfo.append("\nCause:\n").append(getExceptionAsString(cause));
        }

        return exceptionInfo.toString();
    }

    private  static void Logger(String path , String message){
        // creating logging folder
        File theDir = new File("C:\\Users\\yagiz\\Desktop\\HotelManagementSystem\\Logs");
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

    }


}
