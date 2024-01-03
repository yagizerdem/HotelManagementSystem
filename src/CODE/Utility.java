package CODE;
import UI.ErrorScreen;

import java.io.*;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.*;
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
                EventLogger.log("database record folder created successfull" , StaticDetails.infoLog);
            }catch (Exception ex){
                String message = getExceptionAsString(ex);
                new ErrorScreen("Something went wrog contactk with It workers \n\n " + message);
                EventLogger.log(message , StaticDetails.errorLog);
            }
        }

        // back up database files
        String CONTEXTPATH = "C:\\Users\\yagiz\\Desktop\\HotelManagementSystem\\src\\CONTEXT";
        File CONTEXTDIRECTORY = new File(CONTEXTPATH);
        String[] list = CONTEXTDIRECTORY.list();
        int currentIndex = 0;
        for(String item : list){
            Path  sourecePath = Paths.get(CONTEXTPATH + "\\" + item);
            Path  destinationPath = Paths.get(recordDir +"\\" + item);
            try {
                Files.copy(sourecePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                if(currentIndex == list.length - 1){
                    EventLogger.log("Database files resotred successfull" , StaticDetails.infoLog);
                }
            }catch (Exception ex){
                String message = getExceptionAsString(ex);
                new ErrorScreen("Something went wrog contactk with It workers \n\n " + message);
                EventLogger.log(message , StaticDetails.errorLog);
            }
            currentIndex++;
        }
    }
    public static String getExceptionAsString(Throwable throwable) {
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

    // batch transaction
    public static void DatabaseTransaction(){
        // wrtie files
        String data = "";
        for(Admin admin : VirtualDatabase.AdminDatabase){
            String template = "%s;%s;%s;%s;%s";
            String formattedString = String.format(template, admin.Id , admin.FirstName , admin.LastName, admin.UserName,admin.Password );
            data += formattedString + "\n";
        }
        WriteFile(StaticDetails.AdminDatabasePath , data);
        data = "";
        for(Receptionist receptionist: VirtualDatabase.ReceptionistDatabase){
            String template = "%s;%s;%s;%s;%s;%s";
            String formattedString = String.format(template, receptionist.Id , receptionist.FirstName , receptionist.LastName,
                    receptionist.UserName,receptionist.Salary,receptionist.Password );
            data += formattedString + "\n";
        }
        WriteFile(StaticDetails.ReceptionistDatatbasePath , data);
        data = "";
        for(Room room: VirtualDatabase.RoomDatabase){
            String template = "%s;%s;%s;%s;%s;%s;%s";
            String arrayAsString = Arrays.toString(room.roomFacility);
            // Manipulate the string to remove square brackets and spaces
            String commaSeparatedString = arrayAsString.substring(1, arrayAsString.length() - 1).replace(" ", "");
            System.out.println(commaSeparatedString);
            String formattedString = String.format(template, room.Id , room.floorNo,
                    room.bedCount , commaSeparatedString , room.price , room.OccupiedCustomerId , room.Isinmaintenance);
            data += formattedString + "\n";
        }
        WriteFile(StaticDetails.RoomDatabasePath , data);
        data = "";
        for(Customer customer: VirtualDatabase.CustomerDatabase){
            String template = "%s;%s;%s;%s;%s;%s;%s";
            String formattedString = String.format(template, customer.Id , customer.FirstName,
                    customer.LastName , customer.EntrenceDate , customer.ExitDate , customer.TC , customer.Payment);
            data += formattedString + "\n";
        }
        WriteFile(StaticDetails.CustomerDatabasePath , data);
        data = "";
    }

    public  static void WriteFile(String path , String content){
        Path filePath = Path.of(path);
        try {
            // Write the content to the file
            Files.write(filePath, content.getBytes(), StandardOpenOption.CREATE);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
