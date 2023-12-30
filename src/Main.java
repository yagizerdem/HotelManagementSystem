import CODE.Admin;
import CODE.User;
import CODE.StaticDetails;
import CODE.VirtualDatabase;
import UI.LogIn;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Load database to ram
        VirtualDatabase.LoadVirtualDatabase();


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