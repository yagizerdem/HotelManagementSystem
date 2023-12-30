import CODE.Admin;
import CODE.IUser;
import CODE.StaticDetails;
import UI.LogIn;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
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