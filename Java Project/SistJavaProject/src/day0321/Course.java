package day0321;
import day0319.DbConnect;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.util.Vector;


public class Course extends JFrame implements ItemListener, ActionListener {
    DbConnect db = new DbConnect();
    DefaultTableModel courseModel, stuModel;
    private JTable courseTable, stuTable;
    Container cp;
    JLabel hak, lbl;
    JButton btnAdd, btnDel, adminAdd, adminDel, logout;
    private int userId;
    private int isAdmin;


    public Course(String userId, int isAdmin, String title) {
        super(title);
        this.userId = Integer.parseInt(userId);
        this.isAdmin = isAdmin;
        System.out.println(userId+" "+isAdmin);
        this.setBounds(10, 100, 1600, 900);
        this.cp = this.getContentPane();
        this.setDefaultCloseOperation(3);
        this.cp.setBackground(Color.white);
        this.initDesign();
        if (this.isAdmin == 1) {
            this.initAdmin();
        }
        this.courseTableSelect(1);
        this.stuTableSelect();
        this.setVisible(true);
    }

    private void initDesign() {
        this.setLayout((LayoutManager)null);
        String[] title = new String[]{"번호","과목 ID", "과목명", "담당교수", "정원", "현재 인원"};
        this.courseModel = new DefaultTableModel(title, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.courseTable = new JTable(this.courseModel);
        this.courseTable.setAutoCreateRowSorter(true);
        this.courseTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.courseTable.getColumnModel().getColumn(1).setPreferredWidth(10);
        JScrollPane js = new JScrollPane(this.courseTable);
        js.setBounds(10, 50, 1570, 500);
        this.add(js);

        String welcome = "안녕하세요 "+userId+"님";
        this.hak = new JLabel(welcome);
        hak.setBounds(10, 10, 1570, 40);
        this.add(hak);


        this.lbl = new JLabel("내 수강신청 목록");
        lbl.setBounds(10,560,100,30);
        this.add(lbl);


        this.stuModel = new DefaultTableModel(title, 0);
        this.stuTable = new JTable(this.stuModel);
        this.stuTable.setAutoCreateRowSorter(true);
        this.stuTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.stuTable.getColumnModel().getColumn(1).setPreferredWidth(10);
        JScrollPane js1 = new JScrollPane(this.stuTable);
        js1.setBounds(10, 600, 1570, 290);
        this.add(js1);


        this.btnDel = new JButton("과목 삭제");
        this.btnDel.setBounds(320, 560, 100, 30);
        this.btnDel.addActionListener(this);
        this.add(this.btnDel);
        this.btnAdd = new JButton("과목 추가");
        this.btnAdd.setBounds(200, 560, 100, 30);
        this.btnAdd.addActionListener(this);
        this.add(this.btnAdd);


        this.logout = new JButton("로그아웃");
        this.logout.setBounds(500, 10, 100, 30);
        this.logout.addActionListener(this);
        this.add(this.logout);

    }




    public void initAdmin(){
        this.adminAdd = new JButton("과목 추가");
        this.adminAdd.setBounds(1330, 10, 100, 30);
        this.adminAdd.addActionListener(this);
        this.add(this.adminAdd);

        this.adminDel = new JButton("과목 삭제");
        this.adminDel.setBounds(1450, 10, 100, 30);
        this.adminDel.addActionListener(this);
        this.add(this.adminDel);
    }





    public void courseTableSelect(int select) {
        String sql = "SELECT " +
                "ROWNUM no, " +
                "c.course_id id, " +
                "c.course_name name, " +
                "c.instructor inst, " +
                "c.max, " +
                "(SELECT COUNT(*) FROM coursereg cr WHERE cr.course_id = c.course_id) AS cur " +
                "FROM courses c";

        Connection conn = this.db.getConnecton();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            this.courseModel.setRowCount(0);

            while(rs.next()) {
                Vector<String> data = new Vector();
                data.add(rs.getString("no"));
                data.add(rs.getString("id"));
                data.add(rs.getString("name"));
                data.add(rs.getString("inst"));
                data.add(rs.getString("max"));
                data.add(rs.getString("cur")); // Now dynamically calculated
                this.courseModel.addRow(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.db.dbClose(rs, pstmt, conn);
        }
    }



    public void stuTableSelect() {
        String sql = "SELECT rownum no, c.course_id id, c.course_name name, c.instructor inst, c.max, " +
                "(SELECT COUNT(*) FROM coursereg cr2 WHERE cr2.course_id = c.course_id) AS cur " +
                "FROM Courses c " +
                "JOIN courseReg cr ON c.course_id = cr.course_id " +
                "WHERE cr.student_id = ?";
        Connection conn = db.getConnecton();  // adjust the method name if needed
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, this.userId);  // the student id for now
            rs = pstmt.executeQuery();
            stuModel.setRowCount(0);   // clear existing rows

            while(rs.next()) {
                Vector<String> data = new Vector<>();
                data.add(rs.getString("no"));
                data.add(rs.getString("id"));
                data.add(rs.getString("name"));
                data.add(rs.getString("inst"));
                data.add(rs.getString("max"));
                data.add(rs.getString("cur"));
                stuModel.addRow(data);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(rs, pstmt, conn);
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        Object ob = e.getSource();
        Connection conn = this.db.getConnecton();
        PreparedStatement pstmt = null;
        String sql = "";
        if (ob == this.btnDel) {
            int row = this.stuTable.getSelectedRow();
            System.out.println(row);
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "삭제할 행을 먼저 선택해주세요");
                return;
            }

            String courseId = (String) stuModel.getValueAt(row, 1); // Assuming course_id is in column 1
            sql = "DELETE FROM coursereg WHERE student_id = ? AND course_id = ?";
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, this.userId);  // Hardcoded student ID for now
                pstmt.setInt(2, Integer.parseInt(courseId)); // Convert course_id to int
                int result = pstmt.executeUpdate();

                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "과목이 삭제되었습니다.");
                    stuModel.removeRow(row); // Remove from table UI
                } else {
                    JOptionPane.showMessageDialog(this, "삭제할 과목을 찾을 수 없습니다.");
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            } finally {
                db.dbClose(null, pstmt, conn);
            }
        }

        else if (ob == this.btnAdd) {
            sql = "INSERT INTO coursereg (student_id, course_id) VALUES (?, ?)";

            int row = this.courseTable.getSelectedRow();
            System.out.println(row);
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "수강할 과목을 먼저 선택해주세요");
                return;
            }

            String courseId = (String) courseModel.getValueAt(row, 1); // Assuming course_id is in column 1
            int maxs = Integer.parseInt((String) courseModel.getValueAt(row, 4));
            int curs = Integer.parseInt((String) courseModel.getValueAt(row, 5));

            if (curs >=maxs){
                JOptionPane.showMessageDialog(this, "정원이 초과 되었습니다.", "정원 초과", JOptionPane.ERROR_MESSAGE);

            }
            else {

                int id = Integer.parseInt(courseId);


                try {
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1, this.userId);
                    pstmt.setInt(2, id);
                    pstmt.execute();
                    this.stuTableSelect();
                    this.courseTableSelect(1);
                } catch (SQLIntegrityConstraintViolationException e2) {
                    JOptionPane.showMessageDialog(this, "이미 신청한 과목입니다. 다른 과목을 선택하세요.", "중복 오류", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(this, "데이터베이스 오류: " + e1.getMessage(), "오류", JOptionPane.ERROR_MESSAGE);
                    e1.printStackTrace();
                }
            }
        }

        else if (ob == this.adminAdd) {
            showEmployeeForm();
        }
        else if (ob == this.adminDel){
            int row = this.courseTable.getSelectedRow();
            System.out.println(row);
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "삭제할 행을 먼저 선택해주세요");
                return;
            }

            String courseId = (String) courseModel.getValueAt(row, 1); // Assuming course_id is in column 1
            sql = "DELETE FROM courses WHERE course_id = ?";
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, Integer.parseInt(courseId)); // Convert course_id to int
                int result = pstmt.executeUpdate();

                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "과목이 삭제되었습니다.");
                    this.courseTableSelect(1);
                    this.stuTableSelect();
                } else {
                    JOptionPane.showMessageDialog(this, "삭제할 과목을 찾을 수 없습니다.");
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            } finally {
                db.dbClose(null, pstmt, conn);
            }
        }
        else if (ob == this.logout){
            dispose();
            Login loginWindow = new Login();
            loginWindow.setVisible(true);
        }




    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    public static void main(String[] args) {
        new Course("20250000", 1,"수강신청 DB");
    }









    public void showEmployeeForm() {
        // Create form panel
        Connection conn = this.db.getConnecton();
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        panel.add(new JLabel("과목명"));
        JTextField nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("담당교수"));
        JTextField instField = new JTextField();
        panel.add(instField);

        panel.add(new JLabel("정원"));
        JTextField maxField = new JTextField();
        panel.add(maxField);


        // Show dialog
        int result = JOptionPane.showConfirmDialog(null, panel, "사원 정보 입력", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String inst = (String) instField.getText();
            String maxs = (String) maxField.getText();

            // Database insert
            String sql = "INSERT INTO courses (course_name, instructor, max) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, name);
                pstmt.setString(2, inst);
                pstmt.setString(3, maxs);
                pstmt.execute();
                // Refresh table
                courseTableSelect(1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }











}