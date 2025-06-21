import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class ATMMachine extends JFrame implements ActionListener {
    // GUI Components
    private JLabel userIdLabel, pinLabel, amountLabel, messageLabel;
    private JTextField userIdField, amountField;
    private JPasswordField pinField; // Use JPasswordField for PIN
    private JButton createAccountButton, withdrawButton, depositButton, checkBalanceButton;

    // ATM and UserAccount Data
    private ATM atm;

    // Constructor
    public ATMMachine() {
        // Initialize ATM
        atm = new ATM();

        // Set up the JFrame
        setTitle("ATM Machine");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a panel for input fields
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Create GUI components
        userIdLabel = new JLabel("User ID:");
        pinLabel = new JLabel("PIN:");
        amountLabel = new JLabel("Amount:");
        messageLabel = new JLabel("Welcome to the ATM!");
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        userIdField = new JTextField(15);
        pinField = new JPasswordField(15); // Use JPasswordField for PIN
        amountField = new JTextField(15);

        createAccountButton = new JButton("Create Account");
        withdrawButton = new JButton("Withdraw");
        depositButton = new JButton("Deposit");
        checkBalanceButton = new JButton("Check Balance");

        // Add components to the input panel
        inputPanel.add(userIdLabel);
        inputPanel.add(userIdField);
        inputPanel.add(pinLabel);
        inputPanel.add(pinField);
        inputPanel.add(amountLabel);
        inputPanel.add(amountField);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        buttonPanel.add(createAccountButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(depositButton);
        buttonPanel.add(checkBalanceButton);

        // Add panels to the JFrame
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(messageLabel, BorderLayout.NORTH);

        // Add action listeners to buttons
        createAccountButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        depositButton.addActionListener(this);
        checkBalanceButton.addActionListener(this);

        // Display the JFrame
        setVisible(true);
    }

    // Handle button clicks
    public void actionPerformed(ActionEvent e) {
        String userId = userIdField.getText();
        String pin = new String(pinField.getPassword()); // Get PIN from JPasswordField
        String amountText = amountField.getText();
        int amount = 0;

        // Validate amount input
        if (!amountText.isEmpty()) {
            try {
                amount = Integer.parseInt(amountText);
            } catch (NumberFormatException ex) {
                messageLabel.setText("Invalid amount! Please enter a number.");
                return;
            }
        }

        if (e.getSource() == createAccountButton) {
            if (userId.isEmpty() || pin.isEmpty() || amountText.isEmpty()) {
                messageLabel.setText("Please fill all fields!");
            } else {
                atm.createAccount(userId, pin, amount);
                messageLabel.setText("Account created for: " + userId);
            }
        } else if (e.getSource() == withdrawButton) {
            if (userId.isEmpty() || pin.isEmpty() || amountText.isEmpty()) {
                messageLabel.setText("Please fill all fields!");
            } else {
                atm.withdraw(userId, pin, amount);
            }
        } else if (e.getSource() == depositButton) {
            if (userId.isEmpty() || pin.isEmpty() || amountText.isEmpty()) {
                messageLabel.setText("Please fill all fields!");
            } else {
                atm.deposit(userId, pin, amount);
            }
        } else if (e.getSource() == checkBalanceButton) {
            if (userId.isEmpty() || pin.isEmpty()) {
                messageLabel.setText("Please fill User ID and PIN!");
            } else {
                atm.checkBalance(userId, pin);
            }
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        new ATMMachine();
    }

    // ATM Class
    class ATM {
        private Map<String, UserAccount> accounts;
        private int balance;

        public ATM() {
            accounts = new HashMap<>();
            balance = 100000; // Initial ATM balance
        }

        public void createAccount(String userId, String pin, int initialBalance) {
            if (accounts.containsKey(userId)) {
                messageLabel.setText("User already exists!");
            } else {
                accounts.put(userId, new UserAccount(userId, pin, initialBalance));
                messageLabel.setText("Account created for: " + userId);
            }
        }

        public void withdraw(String userId, String pin, int amount) {
            if (!accounts.containsKey(userId)) {
                messageLabel.setText("User does not exist!");
                return;
            }

            UserAccount user = accounts.get(userId);
            if (!user.getPin().equals(pin)) {
                messageLabel.setText("Incorrect PIN!");
                return;
            }

            if (user.getBalance() < amount) {
                messageLabel.setText("Insufficient balance!");
            } else if (balance < amount) {
                messageLabel.setText("ATM out of cash!");
            } else {
                user.setBalance(user.getBalance() - amount);
                balance -= amount;
                messageLabel.setText("Withdrawal successful. Balance: " + user.getBalance());
            }
        }

        public void deposit(String userId, String pin, int amount) {
            if (!accounts.containsKey(userId)) {
                messageLabel.setText("User does not exist!");
                return;
            }

            UserAccount user = accounts.get(userId);
            if (!user.getPin().equals(pin)) {
                messageLabel.setText("Incorrect PIN!");
                return;
            }

            user.setBalance(user.getBalance() + amount);
            balance += amount;
            messageLabel.setText("Deposit successful. Balance: " + user.getBalance());
        }

        public void checkBalance(String userId, String pin) {
            if (!accounts.containsKey(userId)) {
                messageLabel.setText("User does not exist!");
                return;
            }

            UserAccount user = accounts.get(userId);
            if (!user.getPin().equals(pin)) {
                messageLabel.setText("Incorrect PIN!");
                return;
            }

            messageLabel.setText("Your balance is: " + user.getBalance());
        }
    }

    // UserAccount Class
    class UserAccount {
        private String userId;
        private String pin;
        private int balance;

        public UserAccount(String userId, String pin, int balance) {
            this.userId = userId;
            this.pin = pin;
            this.balance = balance;
        }

        public String getUserId() {
            return userId;
        }

        public String getPin() {
            return pin;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }
    }
}