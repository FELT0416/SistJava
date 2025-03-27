package day0319;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AboutSawon {

    DbConnect db = new DbConnect();
    Scanner sc = new Scanner(System.in);

    public void insertSawon(){
        System.out.println("사원 추가하기");
        System.out.println("사원명");
        String name = sc.nextLine();
        System.out.println("성별?");
        String gender = sc.nextLine();
        System.out.println("부서?");
        String buseo = sc.nextLine();
        System.out.println("월급여?");
        int pay = Integer.parseInt(sc.nextLine());

        String sql = "insert into sawon values (seq_sawon.nextval, '"+name+"','"+gender+"','"+buseo+"',"+pay+")";
        System.out.println(sql);

        Connection conn=db.getConnecton();
        Statement stmt = null;

        try{
            stmt=conn.createStatement();
            stmt.execute(sql);

            System.out.println("DB에 사원이 추가됨!!!");

        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            db.dbClose(stmt,conn);
        }

    }

    public void selectSawon(){
        String sql ="select * from sawon";


        Connection conn=db.getConnecton();
        Statement stmt=null;
        ResultSet rs=null;

        try {
            //2개이상일때는 while, 하나일때는 if
            while(rs.next())
            {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);

                //ResultSet next를 이용해서 행을 선택하고 get메서드를 이용해서 테이블의 컬럼값을 얻는다
                System.out.println(rs.getInt("num")+"\t"
                        +rs.getString("name")+"\t"
                        +rs.getString("gender")+"\t"
                        +rs.getString("beuseo")+
                        rs.getString("pay"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            db.dbClose(stmt, conn);
        }

    }

    public void deleteSawon(){
        System.out.println("삭제할 시퀀스를 입력해주세요");
        int num = Integer.parseInt(sc.nextLine());

        String sql ="delete from sawon";

        Connection conn=db.getConnecton();
        Statement stmt=null;
        try{
            stmt=conn.createStatement();
            int a = stmt.executeUpdate(sql);

            if(a==0)
                System.out.println(num+"번 시퀀스는 사원명단에 없는 번호입니다");
            else
                System.out.println(num+"번 시퀀스가 삭제되었습니다");
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            db.dbClose(stmt,conn);
        }




    }


    public static void main(String[] args) {
        AboutSawon as = new AboutSawon();
        Scanner sc = new Scanner(System.in);
        int n;
        while(true){
            System.out.println("오라클 사원 연습");
            System.out.println("1. 데이터 입력 2.데이터 출력 3.데이터 수정 4.데이터 삭제 9.종료");

            n= Integer.parseInt(sc.nextLine());

            if(n==1){
                as.insertSawon();
            }
            else if(n==2){
                as.selectSawon();
            }
            else if (n==9){
                System.out.println("종료합니다");
                break;
            }
        }

    }



}
