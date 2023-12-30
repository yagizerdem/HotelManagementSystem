package CODE;

import javax.swing.plaf.nimbus.State;

public interface IUser {
    public int Id = 0;
    public String FirstName = "";
    public String LastName = "";

    public String UserName = "";

    public String Password = "";
    public String UserRole = StaticDetails.ROLE_ANONIM;
}
