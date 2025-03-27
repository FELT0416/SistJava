package day0319;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ShopTest {
    DbConnect db = new DbConnect();
    Scanner sc;

    public ShopTest() {
        this.sc = new Scanner(System.in);
    }

    public void insertSangpum() {
        Connection conn = this.db.getConnecton();
        PreparedStatement pstmt = null;
        System.out.println("1. 음료   2.과자?");
        int type = Integer.parseInt(this.sc.nextLine());
        System.out.println("상품명?");
        String sname = this.sc.nextLine();
        System.out.println("수량?");
        int su = Integer.parseInt(this.sc.nextLine());
        System.out.println("단가?");
        int dan = Integer.parseInt(this.sc.nextLine());
        String sql = "insert into sales values(seq_test.nextval,?,?,?,?,sysdate)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, type == 1 ? "음료" : "과자");
            pstmt.setString(2, sname);
            pstmt.setInt(3, su);
            pstmt.setInt(4, dan);
            int n = pstmt.executeUpdate();
            if (n == 1) {
                System.out.println("인서트 성공");
            } else {
                System.out.println("인서트 실패");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.db.dbClose(pstmt, conn);
        }

    }

    public void selectSagpum() {
        Connection conn = this.db.getConnecton();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from sales order by num asc";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            System.out.println("시퀀스\t카테고리\t상품명\t수량\t단가\t입고날짜");
            System.out.println("====================================================");

            while(rs.next()) {
                PrintStream var10000 = System.out;
                int var10001 = rs.getInt("num");
                var10000.println(var10001 + "\t" + rs.getString("type") + "\t" + rs.getString("sangpum") + "\t" + rs.getInt("su") + "\t" + rs.getInt("dan") + "\t" + String.valueOf(rs.getDate("ipgoday")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.db.dbClose(rs, pstmt, conn);
        }

    }

    public void deleteSangpum() {
        Connection conn = this.db.getConnecton();
        PreparedStatement pstmt = null;
        System.out.println("삭제할 시퀀스는?");
        int num = Integer.parseInt(this.sc.nextLine());
        String sql = "delete from sales where num=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            int n = pstmt.executeUpdate();
            if (n == 1) {
                System.out.println("삭제성공!!!");
            } else {
                System.out.println("삭제실패!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.db.dbClose(pstmt, conn);
        }

    }

    public boolean isOneData(int num) {
        boolean b = false;
        Connection conn = this.db.getConnecton();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from sales where num=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                b = true;
            } else {
                b = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.db.dbClose(rs, pstmt, conn);
        }

        return b;
    }

    public void updateSangpum() {
        Connection conn = this.db.getConnecton();
        PreparedStatement pstmt = null;
        System.out.println("수정할 시퀀스 번호는?");
        int num = Integer.parseInt(this.sc.nextLine());
        if (!this.isOneData(num)) {
            System.out.println("해당번호는 존재하지않습니다");
        } else {
            System.out.println("수정할 타입은 (1.음료  2.과자)?");
            int type = Integer.parseInt(this.sc.nextLine());
            System.out.println("수정할 상품명은?");
            String name = this.sc.nextLine();
            System.out.println("수량?");
            int su = Integer.parseInt(this.sc.nextLine());
            System.out.println("단가?");
            int dan = Integer.parseInt(this.sc.nextLine());
            String sql = "update sales set type=?,sangpum=?,su=?,dan=? where num=?";

            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, type == 1 ? "음료" : "과자");
                pstmt.setString(2, name);
                pstmt.setInt(3, su);
                pstmt.setInt(4, dan);
                pstmt.setInt(5, num);
                int n = pstmt.executeUpdate();
                if (n == 1) {
                    System.out.println("상품수정 성공!!");
                } else {
                    System.out.println("상품수정 실패!!!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                this.db.dbClose(pstmt, conn);
            }

        }
    }

    public static void main(String[] args) {
        ShopTest sh = new ShopTest();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("**상품입고**");
            System.out.println("1.상품추가  2.상품삭제   3.상품수정   4.재고출력   9.종료");
            int n = Integer.parseInt(sc.nextLine());
            if (n == 1) {
                sh.insertSangpum();
            } else {
                if (n == 9) {
                    System.out.println("프로그램종료");
                    return;
                }

                if (n == 4) {
                    sh.selectSagpum();
                } else if (n == 2) {
                    sh.deleteSangpum();
                } else if (n == 3) {
                    sh.updateSangpum();
                }
            }
        }
    }
}
