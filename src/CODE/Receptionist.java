package CODE;

public class Receptionist extends  User{
    public int Salary;
    public Receptionist(){
        super();
        this.UserRole = StaticDetails.ROLE_RECEPTION;
    }
}
