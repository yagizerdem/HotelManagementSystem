package UI;

import CODE.UserManager;

import javax.swing.*;
import java.awt.*;
public class LogIn {

    private JFrame frame;

    public  LogIn(){
        Init();
    }
    public void Init(){
        frame = new JFrame();
        frame.setSize(400,400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // stackoverflow code  dont change
        ImageIcon background=new ImageIcon("C:\\Users\\yagiz\\Desktop\\HotelManagementSystem\\src\\IMAGES\\HotelImage.jpg");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(400,400,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
        back.setLayout(null);
        back.setBounds(0,0,500,600);
        //

        frame.add(back); // adding background img in login screen

        // Button
        Button logInButton = new Button("LogIn");
        logInButton.setBounds(150,320,100,40);
        back.add(logInButton);
        //

        // Inoput type text UserName
        JLabel userNameLable = new JLabel("enter user name");
        userNameLable.setBounds(110,210,100 , 10);
        userNameLable.setForeground(Color.BLACK);
        back.add(userNameLable);
        JTextField userNameField = new JTextField();
        userNameField.setBounds(110,220,180 , 40);
        back.add(userNameField);
        //
        // Input type text password
        JLabel passwordLabel = new JLabel("enter password");
        passwordLabel.setBounds(110,260,100 , 10);
        passwordLabel.setForeground(Color.BLACK);
        back.add(passwordLabel);
        JTextField passwordField = new JTextField();
        passwordField.setBounds(110,270,180 , 40);
        back.add(passwordField);
        //

        // event handlers
        logInButton.addActionListener(e ->
        {
            String password = passwordField.getText();
            String userName = userNameField.getText();
            boolean flag = UserManager.CheckLogIn(userName , password);

            if(flag){
                // logged in successfull redirect to new frame
                
            }
        });

    }

}
