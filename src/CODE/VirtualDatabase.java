package CODE;

import java.util.ArrayList;

// database on ram
public class VirtualDatabase {

    public static ArrayList<Admin> AdminDatabase = new ArrayList<>();


    public  static  void LoadVirtualDatabase(){
        LoadAdminVirtualTable();
    }
    public static void LoadAdminVirtualTable(){
        String data = Utility.ReadFile(StaticDetails.AdminDatabasePath);
        String[] records = data.split("\n");
        for(String record : records){
            String[] columns = record.split(";");

            // Create new AdminUser in ram
            Admin adminUser = new Admin();
            adminUser.Id = Integer.parseInt(columns[0]);
            adminUser.FirstName = columns[1];
            adminUser.LastName = columns[2];
            adminUser.UserName = columns[3];
            adminUser.Password = columns[4];

            AdminDatabase.add(adminUser);
        }

    }

}
