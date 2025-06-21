package controller;

import model.ATM;
import view.ATMView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMController {
    private ATM model;
    private ATMView view;

    public ATMController(ATM model, ATMView view) {
        this.model = model;
        this.view = view;

        view.createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleCreateAccount();
            }
        });

        view.withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleWithdraw();
            }
        });

        view.depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleDeposit();
            }
        });

        view.checkBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleCheckBalance();
            }
        });
    }

    private void handleCreateAccount() {
        String userId = view.userIdField.getText();
        String pin = new String(view.pinField.getPassword());
        String amountText = view.amountField.getText();

        if (userId.isEmpty() || pin.isEmpty() || amountText.isEmpty()) {
            view.messageLabel.setText("Please fill all fields!");
            return;
        }

        try {
            int amount = Integer.parseInt(amountText);
            String result = model.createAccount(userId, pin, amount);
            view.messageLabel.setText(result);
        } catch (NumberFormatException e) {
            view.messageLabel.setText("Invalid amount! Enter a number.");
        }
    }

    private void handleWithdraw() {
        String userId = view.userIdField.getText();
        String pin = new String(view.pinField.getPassword());
        String amountText = view.amountField.getText();

        if (userId.isEmpty() || pin.isEmpty() || amountText.isEmpty()) {
            view.messageLabel.setText("Please fill all fields!");
            return;
        }

        try {
            int amount = Integer.parseInt(amountText);
            String result = model.withdraw(userId, pin, amount);
            view.messageLabel.setText(result);
        } catch (NumberFormatException e) {
            view.messageLabel.setText("Invalid amount! Enter a number.");
        }
    }

    private void handleDeposit() {
        String userId = view.userIdField.getText();
        String pin = new String(view.pinField.getPassword());
        String amountText = view.amountField.getText();

        if (userId.isEmpty() || pin.isEmpty() || amountText.isEmpty()) {
            view.messageLabel.setText("Please fill all fields!");
            return;
        }

        try {
            int amount = Integer.parseInt(amountText);
            String result = model.deposit(userId, pin, amount);
            view.messageLabel.setText(result);
        } catch (NumberFormatException e) {
            view.messageLabel.setText("Invalid amount! Enter a number.");
        }
    }

    private void handleCheckBalance() {
        String userId = view.userIdField.getText();
        String pin = new String(view.pinField.getPassword());

        if (userId.isEmpty() || pin.isEmpty()) {
            view.messageLabel.setText("Please fill User ID and PIN!");
            return;
        }

        String result = model.checkBalance(userId, pin);
        view.messageLabel.setText(result);
    }
}
