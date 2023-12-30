package CODE;

public class Admin implements IUser {
    public int Id = 0;
    public String FirstName = "";
    public String LastName = "";

    public String UserName = "";

    public String Password = "";
    public String UserRole = StaticDetails.ROLE_ADMIN;
}

