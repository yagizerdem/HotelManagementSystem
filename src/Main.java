import CODE.*;
import UI.LogIn;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Load database to ram
        VirtualDatabase.LoadVirtualDatabase();
//        ArrayList<Customer> customers = VirtualDatabase.CustomerDatabase;
//        int a = 0;
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    new LogIn();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }
}