package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;

    JCheckBox c1,c2,c3,c4,c5,c6;

    JButton s, c;

    String formno;

    Signup3(String formno){

        this.formno = formno;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2= i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150,5,100,100);
        add(image);

        JLabel l1 = new JLabel("Page 3");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel l2 = new JLabel("Account Details");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(280,70,400,40);
        add(l2);

        JLabel l3 = new JLabel("Account Type: ");
        l3.setFont(new Font("Raleway",Font.BOLD,18));
        l3.setBounds(100,140,200,30);
        add(l3);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(new Color(215,252,252));
        r1.setBounds(100,180,150,30);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(new Color(215,252,252));
        r2.setBounds(350,180,300,30);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(new Color(215,252,252));
        r3.setBounds(350,220,250,30);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(new Color(215,252,252));
        r4.setBounds(100,220,250,30);
        add(r4);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);
        buttonGroup.add(r4);

        JLabel l4 = new JLabel("Card Number: ");
        l4.setFont(new Font("Raleway",Font.BOLD,22));
        l4.setBounds(100,300,200,30);
        add(l4);

        JLabel l5 = new JLabel("(Your 16-digits Card Number)");
        l5.setFont(new Font("Raleway",Font.BOLD,12));
        l5.setBounds(100,330,200,20);
        add(l5);

        JLabel l6 = new JLabel("XXXX-XXXX-XXXX-1234");
        l6.setFont(new Font("Raleway",Font.BOLD,22));
        l6.setBounds(330,300,350,30);
        add(l6);

        JLabel l7 = new JLabel("(It would appear on atm card/check and Bank Statement)");
        l7.setFont(new Font("Raleway",Font.BOLD,12));
        l7.setBounds(330,330,500,20);
        add(l7);

        JLabel l8 = new JLabel("PIN: ");
        l8.setFont(new Font("Raleway",Font.BOLD,22));
        l8.setBounds(100,370,200,30);
        add(l8);

        JLabel l9 = new JLabel("XXXX");
        l9.setFont(new Font("Raleway",Font.BOLD,22));
        l9.setBounds(330,370,200,30);
        add(l9);

        JLabel l10 = new JLabel("(4-digit Password)");
        l10.setFont(new Font("Raleway",Font.BOLD,12));
        l10.setBounds(100,400,200,20);
        add(l10);


        JLabel l11 = new JLabel("Services Required: ");
        l11.setFont(new Font("Raleway",Font.BOLD,22));
        l11.setBounds(100,450,300,30);
        add(l11);

        c1 = new JCheckBox("ATM Card");
        c1.setBackground(new Color(215,252,252));
        c1.setFont(new Font("Raleway", Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(new Color(215,252,252));
        c2.setFont(new Font("Raleway", Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(new Color(215,252,252));
        c3.setFont(new Font("Raleway", Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);

        c4 = new JCheckBox("Email Alerts");
        c4.setBackground(new Color(215,252,252));
        c4.setFont(new Font("Raleway", Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(new Color(215,252,252));
        c5.setFont(new Font("Raleway", Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(new Color(215,252,252));
        c6.setFont(new Font("Raleway", Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);

        JCheckBox c7 = new JCheckBox("I/We hereby confirm that the above entered details is correct to the best of my knowledge.", true);
        c7.setBackground(new Color(215,252,252));
        c7.setFont(new Font("Raleway", Font.BOLD,12));
        c7.setBounds(100,680,700,20);
        add(c7);

        JLabel l12 = new JLabel("Form No: ");
        l12.setFont(new Font("Raleway",Font.BOLD,14));
        l12.setBounds(700,10,100,30);
        add(l12);

        JLabel l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway",Font.BOLD,14));
        l13.setBounds(760,10,60,30);
        add(l13);


        s = new JButton("Submit");
        s.setFont(new Font("Raleway",Font.BOLD,14));
        s.setBackground(Color.BLACK);
        s.setForeground(Color.WHITE);
        s.setBounds(250,720,100,30);
        s.addActionListener(this);
        add(s);

        c = new JButton("Cancel");
        c.setFont(new Font("Raleway",Font.BOLD,14));
        c.setBackground(Color.BLACK);
        c.setForeground(Color.WHITE);
        c.setBounds(420,720,100,30);
        c.addActionListener(this);
        add(c);



        getContentPane().setBackground(new Color(215,252,252));
        setSize(850,800);
        setLayout(null);
        setLocation(400,20);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String atype = null;
        if (r1.isSelected()) {
            atype = "Saving Account";
        } else if (r2.isSelected()) {
            atype = "Fixed Deposit Account";
        } else if (r3.isSelected()) {
            atype = "Current Account";
        } else if (r4.isSelected()) {
            atype = "Recurring Deposit Account";
        }

        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 1409963000000000L;
        String cardno = "" + Math.abs(first7);

        // pin
        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);

        StringBuilder services = new StringBuilder();

        if (c1.isSelected()) {
            services.append("ATM Card, ");
        }
        if (c2.isSelected()) {
            services.append("Internet Banking, ");
        }
        if (c3.isSelected()) {
            services.append("Mobile Banking, ");
        }
        if (c4.isSelected()) {
            services.append("Email Alerts, ");
        }
        if (c5.isSelected()) {
            services.append("Cheque Book, ");
        }
        if (c6.isSelected()) {
            services.append("E-Statement, ");
        }

        // Remove the trailing comma and space
        if (services.length() > 0) {
            services.setLength(services.length() - 2);
        }

        try {
            if (e.getSource() == s) {
                if (atype == null) {
                    JOptionPane.showMessageDialog(null, "Fill all the fields");
                } else {
                    Con c1 = new Con();
                    String q1 = "insert into signupthree values('" + formno + "', '" + atype + "', '" + cardno + "', '" + pin + "', '" + services + "')";
                    String q2 = "insert into login values('" + formno + "', '" + cardno + "', '" + pin + "')";
                    c1.statement.executeUpdate(q1);
                    c1.statement.executeUpdate(q2);

                    JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\nPin: " + pin);

                    new Deposit(pin);
                    setVisible(false);
                }
            } else if (e.getSource() == c) {
                System.exit(0);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Signup3("");
    }
}
