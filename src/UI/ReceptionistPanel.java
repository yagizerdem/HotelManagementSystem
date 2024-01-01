package UI;

import CODE.Room;
import CODE.Utility;
import CODE.VirtualDatabase;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;
public class ReceptionistPanel {

    private JFrame frame;
    // Table
    private JTable table;
    private JButton registerCustomerButton;
    public  ReceptionistPanel(){
        Init();
    }

    public void Init(){
        frame = new JFrame();
        frame.setSize(800,500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
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
        table = new JTable(data, columnNames);
        table.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(table);
        frame.add(sp);

        registerCustomerButton = new JButton("Register Customer");
        registerCustomerButton.setLayout(null);
        registerCustomerButton.setBounds(100, 300, 150, 30);
        registerCustomerButton.setSize(new Dimension(50, 50));
        frame.add(registerCustomerButton , BorderLayout.SOUTH);
        frame.pack();

        registerCustomerButton.addActionListener(e ->{
            frame.dispose();
            new RegisterCustomerPanel();
        });



    }
}
