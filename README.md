# 🏧 ATM System

A GUI-based **ATM Machine simulation** developed in **Java** using **Swing** for the interface, **JDBC** for database interaction, and **MySQL** as the backend. This project demonstrates core object-oriented programming concepts, multithreading, MVC architecture, and real-time transaction management.

---

## 📌 Features

- 👤 Create New Account
- 💵 Withdraw Amount
- 💰 Deposit Amount
- 📊 Check Balance
- 🔐 Secure PIN-based Access
- 🧩 MySQL Database Integration with JDBC
- 🧵 Uses **Multithreading** for smoother UI operations
- 🧭 Modular design using **MVC Architecture**

---

## 🛠️ Technologies & Concepts Used

| Component        | Description                                      |
|------------------|--------------------------------------------------|
| **Language**     | Java                                              |
| **UI**           | Swing (Java GUI Framework)                        |
| **Database**     | MySQL                                             |
| **DB Access**    | JDBC (Java Database Connectivity)                 |
| **Architecture** | MVC (Model-View-Controller)                       |
| **Concurrency**  | Java Multithreading for better UI responsiveness |
| **Security**     | Basic PIN-based login for each user              |

---

## 🗂️ Project Structure

```
src/
├── Main.java                    // Entry point of the application
├── controller/
│   └── ATMController.java       // Logic and control flow
├── model/
│   ├── ATM.java                 // Business logic
│   └── UserAccount.java         // Account entity
├── view/
    └── ATMView.java             // Swing-based GUI
```

---

## 💾 Database Setup

1. **Start MySQL Server**
2. **Create Database & Table**
```sql
CREATE DATABASE atmdb;

USE atmdb;

CREATE TABLE users (
    user_id VARCHAR(50) PRIMARY KEY,
    pin VARCHAR(10) NOT NULL,
    balance DOUBLE DEFAULT 0
);
```

---

## 🚀 How to Run

1. Clone the repository or download the ZIP.
2. Set up the MySQL database as mentioned above.
3. Open the project in your favorite Java IDE (e.g., IntelliJ, Eclipse, VS Code).
4. Make sure to add your MySQL connector JAR to the project classpath.
5. Update DB credentials in the code if needed (typically in `ATM.java`).
6. Run `Main.java`.

---

## 📄 License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).

```
MIT License

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction...
```

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!  
Feel free to fork the project and submit a pull request.

---

## 👤 Author

**Dipak Borkhatariya**  
🔗 [LinkedIn](https://www.linkedin.com/in/dipak-borkhatariya)  
💻 [GitHub](https://github.com/dipakborkhatariya24)

