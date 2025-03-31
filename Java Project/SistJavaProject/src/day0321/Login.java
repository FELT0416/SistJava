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
    private JLabel titleLabel;
    private DbConnect db = new DbConnect();

    public Login() {
        setTitle("Login");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        titleLabel = new JLabel("수강신청 로그인", SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("User ID:"), gbc);

        userIdField = new JTextField(15);
        gbc.gridx = 1;
        add(userIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Password:"), gbc);

        passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        add(passwordField, gbc);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setBackground(new Color(50, 150, 250));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        loginButton.addActionListener(new LoginAction());

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(loginButton, gbc);
    }

    private class LoginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userId = userIdField.getText();
            String password = new String(passwordField.getPassword());

            if (validateLogin(userId, password)) {
                int isAdmin = getUserAdminStatus(userId);
                String name = getUserName(userId);
                JOptionPane.showMessageDialog(Login.this, "로그인 성공!");
                setVisible(false);
                dispose();
                new Course(userId, isAdmin, name, "Course Registration").setVisible(true);
            } else {
                JOptionPane.showMessageDialog(Login.this, "비밀번호가 틀립니다. 다시 로그인해주세요.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean validateLogin(String userId, String password) {
        try (Connection conn = db.getConnecton()) {
            String query = "SELECT * FROM students WHERE user_id = ? AND password = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, userId);
                stmt.setString(2, password);
                try (ResultSet rs = stmt.executeQuery()) {
                    return rs.next();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
        return false;
    }

    private int getUserAdminStatus(String userId) {
        try (Connection conn = db.getConnecton()) {
            String query = "SELECT isAdmin FROM students WHERE user_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, userId);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt("isAdmin");
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
        return -1;
    }

    private String getUserName(String userId) {
        try (Connection conn = db.getConnecton()) {
            String query = "SELECT name FROM students WHERE user_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, userId);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getString("name");
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
        return "";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }
}
