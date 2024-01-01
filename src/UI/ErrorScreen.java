package UI;

import javax.swing.*;

public class ErrorScreen {

    private JFrame frame;
    public  JTextArea textArea;
    public  ErrorScreen(String errorMessage){
        Init(errorMessage);
    }
    public void Init(String errorMessage){
        frame = new JFrame();
        textArea = new JTextArea(errorMessage);

        frame = new JFrame();
        frame.setSize(400,400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.getContentPane().add(textArea);

    }

}
