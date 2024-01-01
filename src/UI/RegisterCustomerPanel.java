package UI;

import javax.swing.*;

public class RegisterCustomerPanel {

    private JFrame frame;
    private  JTextField FirstNameField;
    private  JTextField LastNameFiled;
    private  JTextField PriceField;
    private  JTextField DiscountRateField;
    private  JTextField TCField;
    private JTextField AccomodationAmountField;
    private JPanel contentPane;


    public RegisterCustomerPanel(){
        Init();
    }
    public void Init(){
        frame = new JFrame();
        frame.setSize(300,350);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        contentPane = new JPanel();
        contentPane.setLayout(null);

        FirstNameField = new JTextField();
        FirstNameField.setBounds(100,20 , 100,20);
        JLabel CustomerNameLabel = new JLabel("Enter Customer Name" , SwingConstants.CENTER);
        CustomerNameLabel.setBounds(50,5 , 200,10);

        LastNameFiled = new JTextField();
        LastNameFiled.setBounds(100,60,100,20);
        JLabel CustomerLastNameLable = new JLabel("Enter cusomer last name" , SwingConstants.CENTER);
        CustomerLastNameLable.setBounds(50,45,200,10);

        PriceField = new JTextField();
        PriceField.setBounds(100,100,100,20);
        JLabel PriceLabel = new JLabel("Enter price");
        PriceLabel.setBounds(100,85,200,10);

        DiscountRateField = new JTextField();
        DiscountRateField.setBounds(100,140,100,20);
        JLabel DiscountRateLabel = new JLabel("Enter discount rate",SwingConstants.CENTER);
        DiscountRateLabel.setBounds(50,125,200,10);

        TCField = new JTextField();
        TCField.setBounds(100,180,100,20);
        JLabel TClabel = new JLabel("Enter TC" ,SwingConstants.CENTER);
        TClabel.setBounds(50,165,200,10);

        AccomodationAmountField = new JTextField();
        AccomodationAmountField.setBounds(100,220,100,20);
        JLabel AccomodationLabel = new JLabel("Enter accomodation amount" , SwingConstants.CENTER);
        AccomodationLabel.setBounds(50,205,200,20);

        JButton goBackBtn = new JButton("Go Back");
        goBackBtn.setBounds(75,250,150,20);

        JButton submitFormBtn = new JButton("Submit");
        submitFormBtn.setBounds(75,280,150,20);

        contentPane.add(FirstNameField);
        contentPane.add(LastNameFiled);
        contentPane.add(PriceField);
        contentPane.add(DiscountRateField);
        contentPane.add(TCField);
        contentPane.add(AccomodationAmountField);
        contentPane.add(CustomerNameLabel);
        contentPane.add(CustomerLastNameLable);
        contentPane.add(PriceLabel);
        contentPane.add(DiscountRateLabel);
        contentPane.add(TClabel);
        contentPane.add(AccomodationLabel);
        contentPane.add(submitFormBtn);
        contentPane.add(goBackBtn);

        frame.setContentPane(contentPane);


//        submitFormBtn.addActionListener(e -> {
//            String FirstName =
//        });

        goBackBtn.addActionListener(e ->{
            frame.dispose();
            new ReceptionistPanel();
        });
    }
}
