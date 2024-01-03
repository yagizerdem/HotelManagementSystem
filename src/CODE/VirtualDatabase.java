package CODE;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Locale;

// database on ram
public class VirtualDatabase {

    public static ArrayList<Admin> AdminDatabase = new ArrayList<>();
    public static ArrayList<Room> RoomDatabase = new ArrayList<>();
    public static ArrayList<Customer> CustomerDatabase = new ArrayList<>();
    public static ArrayList<Receptionist> ReceptionistDatabase = new ArrayList<>();
    public  static  void LoadVirtualDatabase(){
        LoadAdminVirtualTable();
        LoadRoomVirtualTable();
        LoadCustomerVirtualTable();
        LoadReceptionistTable();
    }
    public static void LoadAdminVirtualTable(){
        String data = Utility.ReadFile(StaticDetails.AdminDatabasePath);
        if(data.equals("")) return;
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
    public static void LoadRoomVirtualTable(){
        String data = Utility.ReadFile(StaticDetails.RoomDatabasePath);
        if(data.equals("")) return;
        String[] records = data.split("\n");
        for(String record : records){
            String[] columns = record.split(";");

            // Create new Room in ram
            Room newRoom = new Room();
            newRoom.Id = Integer.parseInt(columns[0]);
            newRoom.floorNo = Integer.parseInt(columns[1]);
            newRoom.bedCount = Integer.parseInt(columns[2]);
            newRoom.roomFacility = columns[3].split(",");
            newRoom.price = Integer.parseInt(columns[4]);
            newRoom.OccupiedCustomerId = Integer.parseInt(columns[5]);
            newRoom.Isinmaintenance = Boolean.parseBoolean(columns[6]);

            RoomDatabase.add(newRoom);
        }
    }

    public static void LoadCustomerVirtualTable(){
        String data = Utility.ReadFile(StaticDetails.CustomerDatabasePath);
        if(data.equals("")) return;
        String[] records = data.split("\n");
        for(String record : records){
            String[] columns = record.split(";");

            // Create new Customer in ram
            Customer newCustomer = new Customer();
            newCustomer.Id = Integer.parseInt(columns[0]);
            newCustomer.FirstName = columns[1];
            newCustomer.LastName = columns[2];
            newCustomer.TC = columns[5];
            newCustomer.Payment = Integer.parseInt(columns[6]);
            try {
                newCustomer.EntrenceDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US).parse(columns[3]);
                newCustomer.ExitDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US).parse(columns[4]);

                CustomerDatabase.add(newCustomer);
            } catch (ParseException e) {
                e.printStackTrace(); // Log or handle the exception appropriately
            }


        }
    }
    public static  void LoadReceptionistTable(){
        String data = Utility.ReadFile(StaticDetails.ReceptionistDatatbasePath);
        if(data.equals("")) return;
        String[] records = data.split("\n");
        for(String record : records){
            String[] columns = record.split(";");

            // Create new Receptionist in ram
            Receptionist newReceptionist = new Receptionist();
            newReceptionist.Id = Integer.parseInt(columns[0]);
            newReceptionist.FirstName = columns[1];
            newReceptionist.LastName = columns[2];
            newReceptionist.UserName = columns[3];
            newReceptionist.Salary = Integer.parseInt(columns[4]);
            newReceptionist.Password = columns[5];

            ReceptionistDatabase.add(newReceptionist);

        }
    }

}
