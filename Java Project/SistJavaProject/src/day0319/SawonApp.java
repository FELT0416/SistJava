package day0319;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SawonApp extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton addButton, deleteButton;
    private DbConnect dbConnect = new DbConnect();

    public SawonApp() {
        super("Sawon Management");
        initComponents();
        loadData();  // Load data from DB into the table on startup
    }

    // Initialize UI components and layout
    private void initComponents() {
        setLayout(new BorderLayout());

        // Create top panel with add and delete buttons
        JPanel topPanel = new JPanel(new BorderLayout());
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        topPanel.add(addButton, BorderLayout.WEST);
        topPanel.add(deleteButton, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        // Set up the table with a non-editable model
        tableModel = new DefaultTableModel(new Object[]{"Num", "Name", "Gender", "Buseo", "Pay"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Button action for adding a new record
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addRecord();
            }
        });

        // Button action for deleting the selected record
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteRecord();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }

    // Load all records from the "sawon" table into the JTable
    private void loadData() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = dbConnect.getConnecton();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM sawon");
            tableModel.setRowCount(0); // Clear existing data
            while (rs.next()) {
                int num = rs.getInt("num");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String buseo = rs.getString("buseo");
                int pay = rs.getInt("pay");
                tableModel.addRow(new Object[]{num, name, gender, buseo, pay});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage());
        } finally {
            dbConnect.dbClose(rs, stmt, conn);
        }
    }

    // Display a dialog to add a new record and insert it into the DB
    private void addRecord() {
        JTextField numField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField genderField = new JTextField();
        JTextField buseoField = new JTextField();
        JTextField payField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("Num:"));
        panel.add(numField);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Gender:"));
        panel.add(genderField);
        panel.add(new JLabel("Buseo:"));
        panel.add(buseoField);
        panel.add(new JLabel("Pay:"));
        panel.add(payField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Enter Sawon Details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                int num = Integer.parseInt(numField.getText());
                String name = nameField.getText();
                String gender = genderField.getText();
                String buseo = buseoField.getText();
                int pay = Integer.parseInt(payField.getText());

                Connection conn = null;
                PreparedStatement pstmt = null;
                try {
                    conn = dbConnect.getConnecton();
                    String sql = "INSERT INTO sawon (num, name, gender, buseo, pay) VALUES (?, ?, ?, ?, ?)";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1, num);
                    pstmt.setString(2, name);
                    pstmt.setString(3, gender);
                    pstmt.setString(4, buseo);
                    pstmt.setInt(5, pay);
                    int inserted = pstmt.executeUpdate();
                    if (inserted > 0) {
                        JOptionPane.showMessageDialog(this, "Record added successfully.");
                        loadData();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error adding record: " + ex.getMessage());
                } finally {
                    dbConnect.dbClose(pstmt, conn);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numeric values for Num and Pay.");
            }
        }
    }

    // Delete the selected record from the table and the database
    private void deleteRecord() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        int num = (int) tableModel.getValueAt(selectedRow, 0);

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbConnect.getConnecton();
            String sql = "DELETE FROM sawon WHERE num = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            int deleted = pstmt.executeUpdate();
            if (deleted > 0) {
                JOptionPane.showMessageDialog(this, "Record deleted successfully.");
                loadData();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error deleting record: " + ex.getMessage());
        } finally {
            dbConnect.dbClose(pstmt, conn);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SawonApp().setVisible(true));
    }
}
