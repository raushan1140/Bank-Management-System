package bank.management.system;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Vector;

public class MiniStatement extends JFrame implements ActionListener {

    String pin;
    JButton button;
    JTable table;

    MiniStatement(String pin) {
        this.pin = pin;

        JLabel bankLabel = new JLabel("Chitkara Bank");
        bankLabel.setFont(new Font("System", Font.BOLD, 24));
        bankLabel.setBounds(180, 20, 200, 30);
        add(bankLabel);

        JLabel cardLabel = new JLabel();
        cardLabel.setFont(new Font("System", Font.PLAIN, 16));
        cardLabel.setBounds(20, 80, 400, 20);
        add(cardLabel);

        try {
            Con c = new Con();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM login WHERE pin = '" + pin + "'");

            if (rs.next()) {
                cardLabel.setText("Card Number: " + rs.getString("card_number").substring(0, 4) + "XXXXXXXX" + rs.getString("card_number").substring(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Vector<String> columnNames = new Vector<>();
        columnNames.add("Date");
        columnNames.add("Type");
        columnNames.add("Amount");

        Vector<Vector<Object>> data = new Vector<>();
        try {
            Con c = new Con();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "' ORDER BY date DESC LIMIT 10");
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getString("date"));
                row.add(rs.getString("type"));
                row.add(rs.getString("amount"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable(data, columnNames);
        table.setFont(new Font("Serif", Font.PLAIN, 14));
        table.setRowHeight(30);

        // Adjust column widths
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(180); // Date column
        columnModel.getColumn(1).setPreferredWidth(100); // Type column
        columnModel.getColumn(2).setPreferredWidth(100); // Amount column

        // Center the text in the table cells
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 150, 400, 300);
        add(scrollPane);

        JLabel balanceLabel = new JLabel();
        balanceLabel.setFont(new Font("System", Font.BOLD, 18));
        balanceLabel.setBounds(20, 470, 400, 20);
        add(balanceLabel);

        try {
            int balance = 0;
            Con c = new Con();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
            while (rs.next()) {
                if (rs.getString("type").equalsIgnoreCase("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balanceLabel.setText("Your Total Balance is Rs. " + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        button = new JButton("Exit");
        button.setBounds(160, 520, 100, 30);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.addActionListener(this);
        add(button);

        getContentPane().setBackground(new Color(255, 204, 204));
        setSize(450, 600); // Adjusted frame size
        setLocation(150, 150);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
