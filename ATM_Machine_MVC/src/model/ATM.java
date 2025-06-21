package model;

import java.sql.*;

public class ATM {
    private Connection connection;

    public ATM() {
        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL database
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/atm_db", // database URL
                    "root", // your MySQL username
                    "" // your MySQL password
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String createAccount(String userId, String pin, int initialBalance) {
        try {
            if (!isPasswordStrong(pin)) {
                return "Weak PIN! Password must be at least 8 characters long and include uppercase, lowercase, digit, and special character.";
            }

            PreparedStatement checkStmt = connection.prepareStatement(
                    "SELECT * FROM users WHERE user_id = ?");
            checkStmt.setString(1, userId);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                return "User already exists!";
            }

            PreparedStatement insertStmt = connection.prepareStatement(
                    "INSERT INTO users (user_id, pin, balance) VALUES (?, ?, ?)");
            insertStmt.setString(1, userId);
            insertStmt.setString(2, pin);
            insertStmt.setInt(3, initialBalance);
            insertStmt.executeUpdate();

            return "Account created for: " + userId;

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error creating account!";
        }
    }


    // Password strength checker
    private boolean isPasswordStrong(String password) {
        if (password.length() < 8) return false;
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if ("!@#$%^&*()_+-=[]{},.<>?".indexOf(c) >= 0) hasSpecial = true;
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }


    public String withdraw(String userId, String pin, int amount) {
        try {
            PreparedStatement selectStmt = connection.prepareStatement(
                    "SELECT * FROM users WHERE user_id = ?");
            selectStmt.setString(1, userId);
            ResultSet rs = selectStmt.executeQuery();

            if (!rs.next()) return "User does not exist!";
            if (!rs.getString("pin").equals(pin)) return "Incorrect PIN!";

            int currentBalance = rs.getInt("balance");
            if (currentBalance < amount) return "Insufficient balance!";

            PreparedStatement updateStmt = connection.prepareStatement(
                    "UPDATE users SET balance = balance - ? WHERE user_id = ?");
            updateStmt.setInt(1, amount);
            updateStmt.setString(2, userId);
            updateStmt.executeUpdate();

            return "Withdrawal successful. Balance: " + (currentBalance - amount);

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error during withdrawal!";
        }
    }

    public String deposit(String userId, String pin, int amount) {
        try {
            PreparedStatement selectStmt = connection.prepareStatement(
                    "SELECT * FROM users WHERE user_id = ?");
            selectStmt.setString(1, userId);
            ResultSet rs = selectStmt.executeQuery();

            if (!rs.next()) return "User does not exist!";
            if (!rs.getString("pin").equals(pin)) return "Incorrect PIN!";

            PreparedStatement updateStmt = connection.prepareStatement(
                    "UPDATE users SET balance = balance + ? WHERE user_id = ?");
            updateStmt.setInt(1, amount);
            updateStmt.setString(2, userId);
            updateStmt.executeUpdate();

            int newBalance = rs.getInt("balance") + amount;
            return "Deposit successful. Balance: " + newBalance;

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error during deposit!";
        }
    }

    public String checkBalance(String userId, String pin) {
        try {
            PreparedStatement selectStmt = connection.prepareStatement(
                    "SELECT * FROM users WHERE user_id = ?");
            selectStmt.setString(1, userId);
            ResultSet rs = selectStmt.executeQuery();

            if (!rs.next()) return "User does not exist!";
            if (!rs.getString("pin").equals(pin)) return "Incorrect PIN!";

            int currentBalance = rs.getInt("balance");
            return "Your balance is: " + currentBalance;

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error checking balance!";
        }
    }
}
