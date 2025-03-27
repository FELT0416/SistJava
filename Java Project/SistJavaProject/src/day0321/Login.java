package day0321;

import day0319.DbConnect;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame {
    private JTextField userIdField;
    private JPasswordField passwordField;
    private JButton loginButton;
    DbConnect db = new DbConnect();

    public Login(){

        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create components
        userIdField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");

        // Add components to the frame
        add(new JLabel("User ID:"));
        add(userIdField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(loginButton);

        // Add action listener for the login button
        loginButton.addActionListener(new LoginAction());
        setLocationRelativeTo(null);  // Center the window
    }


    private class LoginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userId = userIdField.getText();
            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);

            int isAdmin = -1;
            // Validate user credentials
            if (validateLogin(userId, password)) {
                isAdmin = getUserAdminStatus(userId);
                JOptionPane.showMessageDialog(Login.this, "로그인 성공!");
                setVisible(false);
                dispose();

                // Create and show the course window, passing userId and isAdmin
                Course courseWindow = new Course(userId, isAdmin, "수강신청 폼");
                courseWindow.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(Login.this, "Invalid credentials. Please try again.");
            }
        }
    }

    // Validate the login credentials from the database
    private boolean validateLogin(String userId, String password) {
        try (Connection conn = this.db.getConnecton()) {
            String query = "SELECT * FROM students WHERE user_id = ? AND password = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, userId);
                stmt.setString(2, password);

                try (ResultSet rs = stmt.executeQuery()) {
                    return rs.next(); // If result is found, login is successful
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }



    private int getUserAdminStatus(String userId) {
        try (Connection conn = this.db.getConnecton()) {
            String query = "SELECT isAdmin FROM students WHERE user_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, userId);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt("isAdmin"); // Return the isAdmin value
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
        return -1; // Return a default value in case of an error or no result
    }


}