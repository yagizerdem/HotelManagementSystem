package UI;

import CODE.Room;
import CODE.Utility;
import CODE.VirtualDatabase;
import javax.swing.*;
import java.util.ArrayList;
public class ReceptionistPanel {

    private JFrame frame;
    // Table
    private JTable j;
    public  ReceptionistPanel(){
        Init();
    }

    public void Init(){
        frame = new JFrame();
        frame.setSize(800,500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // fetching data from virtual database
        ArrayList<Room> allRooms = VirtualDatabase.RoomDatabase;
        String[][] data = new String[allRooms.size()][allRooms.get(0).getColumnCount()];
        String[] columnNames = Utility.getPropertyNames(Room.class);

        // filling data
        for(int i = 0 ; i < allRooms.size(); i++){
            for(int j = 0 ; j < columnNames.length ; j++){
                String key = columnNames[j];
                data[i][j] = Utility.getStringPropertyValue(allRooms.get(i) , key);
            }
        }

        // Initializing the JTable
        j = new JTable(data, columnNames);
        j.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(j);
        frame.add(sp);
    }
}
