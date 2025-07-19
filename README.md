# ATM Machine (Java, MVC Architecture)

A simple ATM simulation application built using **Java Swing** and following the **MVC (Model-View-Controller)** design pattern.

---

## 🧩 Features

- ✅ User Login with PIN authentication
- 💰 Check Balance
- 💵 Deposit Money
- 💸 Withdraw Money
- 🚪 Exit/Logout functionality
- 🧪 Modular structure using MVC for easy maintenance and expansion

---

## 🏗️ Project Structure

```
ATM_Machine_MVC/
├── controller/
│   └── ATMController.java
├── model/
│   ├── ATMModel.java
│   └── UserAccount.java
├── view/
│   ├── ATMView.java
│   └── LoginView.java
├── Main.java
└── README.md
```

- **model/**: Business logic and data handling (balance, user data)
- **view/**: Java Swing GUI components
- **controller/**: Logic connecting View and Model
- **Main.java**: Entry point of the application

---

## 🛠️ How to Run

1. **Download or Clone the repository**  
   ```
   git clone https://github.com/your-username/ATM_Machine_MVC.git
   ```

2. **Compile all Java files**  
   Open terminal and run:
   ```
   javac Main.java
   ```

3. **Run the Application**  
   ```
   java Main
   ```

---

## 🧪 Default Credentials

For testing:
- **Username:** `user1`
- **PIN:** `1234`

> You can add or modify user data in `UserAccount.java`.

---

## ✨ Future Improvements

- Persistent user data with file or database storage
- Admin panel for managing accounts
- Transaction history
- Input validations and error handling

---

## 📄 License

This project is open-source and free to use for educational purposes.

---

## 👤 Author

**Dipak**  
Connect with me on [LinkedIn]( https://www.linkedin.com/in/dipak-borkhatariya-ab4104274 )
