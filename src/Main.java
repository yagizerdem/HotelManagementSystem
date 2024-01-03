import CODE.*;
import UI.ReceptionistPanel;
import UI.RegisterCustomerPanel;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Load database to ram
        VirtualDatabase.LoadVirtualDatabase();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
//                    new LogIn();
                   // new RegisterCustomerPanel();
                    new ReceptionistPanel();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.out.println("In shutdown hook");
                Utility.DatabaseTransaction();
            }
        }, "Shutdown-thread"));

    }
}