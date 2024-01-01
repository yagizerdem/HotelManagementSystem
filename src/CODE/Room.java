package CODE;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Room {
    public int Id;
    public int floorNo;
    public int bedCount;
    public String[] roomFacility;
    public int price;
    public int OccupiedCustomerId;
    public boolean Isinmaintenance;

    public int getColumnCount() {
        return getClass().getDeclaredFields().length;
    }


}
