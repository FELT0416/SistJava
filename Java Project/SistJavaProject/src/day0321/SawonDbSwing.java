//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package day0321;

import day0319.DbConnect;
import java.awt.Color;
import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SawonDbSwing extends JFrame implements ItemListener, ActionListener {
    DbConnect db = new DbConnect();
    Container cp;
    JTable table;
    DefaultTableModel model;
    JRadioButton[] rb = new JRadioButton[6];
    JButton btnAdd;
    JButton btnDel;

    public SawonDbSwing(String title) {
        super(title);
        this.setBounds(100, 100, 700, 500);
        this.cp = this.getContentPane();
        this.setDefaultCloseOperation(3);
        this.cp.setBackground(Color.white);
        this.initDesign();
        this.sawonTableSelect(1);
        this.setVisible(true);
    }

    public void initDesign() {
        this.setLayout((LayoutManager)null);
        String[] title = new String[]{"번호", "ID", "사원명", "성별", "부서명", "월급여"};
        this.model = new DefaultTableModel(title, 0);
        this.table = new JTable(this.model);
        this.table.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.table.getColumnModel().getColumn(1).setPreferredWidth(10);
        JScrollPane js = new JScrollPane(this.table);
        js.setBounds(10, 100, 670, 350);
        this.add(js);
        ButtonGroup bg = new ButtonGroup();
        String[] rb_label = new String[]{"전체", "남자", "여자", "홍보부", "개발부", "디자인부"};
        int xpos = 10;

        for(int i = 0; i < this.rb.length; ++i) {
            this.rb[i] = new JRadioButton(rb_label[i], i == 0);
            this.rb[i].setBounds(xpos, 50, 90, 30);
            this.rb[i].setOpaque(false);
            this.rb[i].addItemListener(this);
            bg.add(this.rb[i]);
            this.add(this.rb[i]);
            xpos += 100;
        }


        this.btnDel = new JButton("사원삭제");
        this.btnDel.setBounds(10, 10, 100, 30);
        this.btnDel.addActionListener(this);
        this.add(this.btnDel);
        this.btnAdd = new JButton("사원추가");
        this.btnAdd.setBounds(150, 10, 100, 30);
        this.btnAdd.addActionListener(this);
        this.add(this.btnAdd);
    }

    public void sawonTableSelect(int select) {
        String sql = "";
        if (select == 1) {
            sql = "select ROWNUM no,num id,name,gender,buseo,to_char(pay,'L999,999,999') pay from sawon";
        } else if (select == 2) {
            sql = "select ROWNUM no,num id,name,gender,buseo,to_char(pay,'L999,999,999') pay from sawon where gender='남자'";
        } else if (select == 3) {
            sql = "select ROWNUM no,num id,name,gender,buseo,to_char(pay,'L999,999,999') pay from sawon where gender='여자'";
        } else if (select == 4) {
            sql = "select ROWNUM no,num id,name,gender,buseo,to_char(pay,'L999,999,999') pay from sawon where buseo='홍보부'";
        } else if (select == 5) {
            sql = "select ROWNUM no,num id,name,gender,buseo,to_char(pay,'L999,999,999') pay from sawon where buseo='개발부'";
        } else if (select == 6) {
            sql = "select ROWNUM no,num id,name,gender,buseo,to_char(pay,'L999,999,999') pay from sawon where buseo='디자인부'";
        }

        Connection conn = this.db.getConnecton();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            this.model.setRowCount(0);

            while(rs.next()) {
                Vector<String> data = new Vector();
                data.add(rs.getString("no"));
                data.add(rs.getString("id"));
                data.add(rs.getString("name"));
                data.add(rs.getString("gender"));
                data.add(rs.getString("buseo"));
                data.add(rs.getString("pay"));
                this.model.addRow(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.db.dbClose(rs, pstmt, conn);
        }

    }

    public static void main(String[] args) {
        new SawonDbSwing("사원테이블 DB");
    }

    public void actionPerformed(ActionEvent e) {
        Object ob = e.getSource();
        Connection conn = this.db.getConnecton();
        PreparedStatement pstmt = null;
        String sql = "";
        if (ob == this.btnDel) {
            int row = this.table.getSelectedRow();
            System.out.println(row);
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "삭제할 행을 먼저 선택해주세요");
                return;
            }

            String num = (String)this.model.getValueAt(row, 1);
            System.out.println(num);
            sql = "delete from sawon where num=?";

            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, num);
                pstmt.execute();
                this.sawonTableSelect(1);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            } else if (ob == this.btnAdd) {
                String name = JOptionPane.showInputDialog("사원명을 입력해주세요");
                String gender = JOptionPane.showInputDialog("성별 입력해주세요(남자/여자)");
                String buseo = JOptionPane.showInputDialog("부서를 입력해주세요(홍보부,개발부,디자인부)");
                String pay = JOptionPane.showInputDialog("급여 입력해주세요");
                sql = "insert into sawon values (seq_sawon.nextval,?,?,?,?)";

                try {
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, name);
                    pstmt.setString(2, gender);
                    pstmt.setString(3, buseo);
                    pstmt.setString(4, pay);
                    pstmt.execute();
                    this.sawonTableSelect(1);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

    }

    public void itemStateChanged(ItemEvent e) {
        Object ob = e.getSource();

        for(int i = 0; i < this.rb.length; ++i) {
            if (this.rb[i] == ob) {
                this.sawonTableSelect(i + 1);
            }
        }
    }


    public int getCurrentPeopleCount(int courseId) {
        int count = 0;
        // Database connection and query logic to count the rows in coursereg
        String query = "SELECT COUNT(*) FROM coursereg WHERE course_Id = ?";
        try (Connection conn = db.getConnecton();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, courseId);  // Set the courseId parameter
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    count = rs.getInt(1);  // Get the count value
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }


}
