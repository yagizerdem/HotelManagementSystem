package CODE;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files
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

}
