package day0321;
import day0319.DbConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StuTest {
    DbConnect db = new DbConnect();
    Scanner sc;

    public void insert()
    {
        Scanner sc=new Scanner(System.in);

        String name,addr,blood,hp,bday;
        int grade,age;
        String sql="";

        System.out.println("이름입력");
        name=sc.nextLine();
        System.out.println("주소입력");
        addr=sc.nextLine();
        System.out.println("혈앵형 입력");
        blood=sc.nextLine();
        System.out.println("hp 입력");
        hp=sc.nextLine();
        System.out.println("학년 입력");
        grade=Integer.parseInt(sc.nextLine());
        System.out.println("나이 입력");
        age=Integer.parseInt(sc.nextLine());
        System.out.println("생일 입력");
        bday=sc.nextLine();

        sql = "insert into StuInfo values (stu_no.nextval, '" + name + "', '" + addr + "', '" + blood + "', '" + hp + "', '" + grade + "', '" + age + "', '" + bday + "', sysdate)";
        System.out.println(sql);

        Connection conn=null;
        Statement stmt=null;

        conn=db.getConnecton();
        try {
            stmt=conn.createStatement();
            stmt.execute(sql); //boolean or int 저장할지...

            System.out.println("**추가됨**");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(stmt, conn);
        }

    }


    public void select()
    {
        System.out.println("시퀀스\t이름\t주소\t혈액형\thp\t학년\t나이\t생일\t등록일자");
        System.out.println("===========================================");

        String sql="select * from StuInfo by num";

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
                System.out.println(rs.getInt("stu_no")+"\t"
                        +rs.getString("stu_name")+"\t"
                        +rs.getString("stu_addr")+"\t"
                        +rs.getDate("stu_blood")+"\t"
                        +rs.getString("stu_hp")+"\t"
                        +rs.getString("stu_grade")+"\t"
                        +rs.getString("stu_age")+"\t"
                        +rs.getString("stu_bday")
                        +rs.getDate("writeday"));
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            db.dbClose(stmt, conn);
        }


    }

    public void delete()
    {
        Scanner sc=new Scanner(System.in);
        int num;
        String sql="";

        System.out.println("삭제할 번호는?");
        num=Integer.parseInt(sc.nextLine());

        sql="delete from hello where num="+num;
        //System.out.println(sql);

        //db연결
        Connection conn=db.getConnecton();
        //statement
        Statement stmt=null;

        try {
            stmt=conn.createStatement();
            int a=stmt.executeUpdate(sql);  //성공한레코드의 갯수

            //없는 번호 입력시 실제 삭제가 안되므로 0이반환
            if(a==0)
                System.out.println("없는 데이타 번호입니다");
            else //삭제되면 1이반환
                System.out.println("**삭제되었습니다**");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            db.dbClose(stmt, conn);
        }



    }


    public boolean isData(int num){
        boolean flag=false;

        String sql="select * from StuInfo where num="+num;

        Connection conn = db.getConnecton();
        Statement stmt = null;
        ResultSet rs = null;
        try{
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);

            if(rs.next()){
                flag=true;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return flag;
    }



    public void update(){

        Scanner sc=new Scanner(System.in);
        String sql = "";
        String name,addr,blood,hp,bday;
        int grade,age;
        int num = 0;

        System.out.println("수정할 번호 입력하세요");
        num = Integer.parseInt(sc.nextLine());
        if(!this.isData(num)){
            System.out.println("해당 번호는 존재하지 않습니다");
        }

        System.out.println("수정할 이름입력");
        name=sc.nextLine();
        System.out.println("수정할 주소입력");
        addr=sc.nextLine();
        System.out.println("수정할 혈앵형 입력");
        blood=sc.nextLine();
        System.out.println("수정할 hp 입력");
        hp=sc.nextLine();
        System.out.println("수정할 학년 입력");
        grade=Integer.parseInt(sc.nextLine());
        System.out.println("수정할 나이 입력");
        age=Integer.parseInt(sc.nextLine());
        System.out.println("수정할 생일 입력");
        bday=sc.nextLine();




        sql = "update StuInfo set name='"+name+"',addr='"+addr+"' where num="+num;
        System.out.println(sql);

        Connection conn=db.getConnecton();
        Statement stmt=null;

        try {
            stmt = conn.createStatement();
            int a = stmt.executeUpdate(sql);
            if (a == 0) {
                System.out.println("수정할 데이터가 존재하지 않습니다");
            } else {
                System.out.println("수정이 완료되었습니다");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public static void main(String[] args) {
        StuTest st = new StuTest();
        Scanner sc = new Scanner(System.in);




    }
}
