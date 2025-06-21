package view;

import javax.swing.*;
import java.awt.*;

public class ATMView extends JFrame {
    public JTextField userIdField, amountField;
    public JPasswordField pinField;
    public JButton createAccountButton, withdrawButton, depositButton, checkBalanceButton;
    public JLabel messageLabel;

    public ATMView() {
        setTitle("ATM Machine");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        inputPanel.add(new JLabel("User ID:"));
        userIdField = new JTextField(15);
        inputPanel.add(userIdField);
        inputPanel.add(new JLabel("PIN:"));
        pinField = new JPasswordField(15);
        inputPanel.add(pinField);
        inputPanel.add(new JLabel("Amount:"));
        amountField = new JTextField(15);
        inputPanel.add(amountField);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        createAccountButton = new JButton("Create Account");
        withdrawButton = new JButton("Withdraw");
        depositButton = new JButton("Deposit");
        checkBalanceButton = new JButton("Check Balance");

        buttonPanel.add(createAccountButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(depositButton);
        buttonPanel.add(checkBalanceButton);

        messageLabel = new JLabel("Welcome to the ATM!", SwingConstants.CENTER);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(messageLabel, BorderLayout.NORTH);

        setVisible(true);
    }
}
