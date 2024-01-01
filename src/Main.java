import CODE.*;
import UI.RegisterCustomerPanel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Load database to ram
        VirtualDatabase.LoadVirtualDatabase();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
//                    new LogIn();
//                    new RegisterCustomerPanel();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }
}