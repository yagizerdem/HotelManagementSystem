package CODE;

import java.util.ArrayList;

public  class UserManager
{
    public static int ActiveUserId;
    public static  String ActiveUserName;
    public static String ROLE;

    public  static  boolean CheckLogIn(String userName , String password){
        ArrayList<User> allUsers = new ArrayList<>();
        allUsers.addAll(VirtualDatabase.AdminDatabase);

        for(User user : allUsers){
            if(userName.equals(user.UserName) && password.equals(user.Password)){
                System.out.println("Logged In");
                ActiveUserId = user.Id;
                ROLE = user.UserRole;
                ActiveUserName = user.UserName;

                return  true;
            }
        }
        return  false;
    }
}
