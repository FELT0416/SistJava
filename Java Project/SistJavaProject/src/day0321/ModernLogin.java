package day0321;

import day0319.DbConnect;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class ModernLogin extends JFrame {
    private JTextField userIdField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private DbConnect db = new DbConnect();

    public ModernLogin() {
        // Set up the frame
        setTitle("Login");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(createMainPanel());

        // Center the window
        setLocationRelativeTo(null);
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(40, 30, 40, 30));
        mainPanel.setBackground(Color.WHITE);

        // Logo or Title Panel
        JLabel titleLabel = new JLabel("Welcome Back", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(33, 33, 33));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Form Panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(Color.WHITE);

        // User ID Field
        userIdField = createModernTextField("Username", true);
        formPanel.add(createFieldPanel("Username", userIdField));
        formPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Password Field
        passwordField = createModernPasswordField("Password");
        formPanel.add(createFieldPanel("Password", passwordField));
        formPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        // Login Button
        loginButton = createModernButton("LOGIN");
        formPanel.add(loginButton);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        return mainPanel;
    }

    private JTextField createModernTextField(String placeholder, boolean isUsername) {
        JTextField textField = new JTextField(20);
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        return textField;
    }

    private JPasswordField createModernPasswordField(String placeholder) {
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        passwordField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        passwordField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        return passwordField;
    }

    private JPanel createFieldPanel(String labelText, JComponent component) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label.setForeground(new Color(33, 33, 33));

        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(component);

        return panel;
    }

    private JButton createModernButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setBackground(new Color(33, 150, 243));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        // Add hover and click effects
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(new Color(25, 118, 210));
            }
            public void mouseExited(MouseEvent evt) {
                button.setBackground(new Color(33, 150, 243));
            }
        });

        return button;
    }

    public static void main(String[] args) {
        // Use Swing's built-in look and feel for a more modern appearance
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            new ModernLogin().setVisible(true);
        });
    }
}