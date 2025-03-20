package day0319;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class ConnectTestEx2 {

	static final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	public void connectBoardAnswer() {
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select b.bno,writer,subject,nickname,content,writeday "
				+ "from board b,answer a where b.bno=a.bno";
				
		
		try {
			conn=DriverManager.getConnection(URL, "angel", "a1234");
			System.out.println("오라클연결성공!!!");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("게시판 댓글 리스트");
			System.out.println("-------------------------------------------");
			while(rs.next())
			{
				int bno=rs.getInt("bno");
				String writer=rs.getString("writer");
				String subject=rs.getString("subject");
				String nick=rs.getString("nickname");
				String content=rs.getString("content");
				Date d=rs.getDate("writeday");
				
				
				System.out.println(bno+"\t"+writer+"\t"+subject+"\t"+nick+"\t"+content+"\t"+d);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("오라클연결실패!!!");
		}
		
		
	}
	
	//sawon_부서별 평급급여 최고급여 최저급여  화폐기호 천단위구분기호
	//emp_ 직급별 평균급여 최고급여 최저급여   화폐기호 천단위구분기호
	public void connectSawonGroup() {
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select buseo,to_char(avg(pay),'L999,999,999') avgpay,to_char(max(pay),'L999,999,999') maxpay,to_char(min(pay),'L999,999,999') minpay from sawon group by buseo";
				
		
		try {
			conn=DriverManager.getConnection(URL, "angel", "a1234");
			System.out.println("성공");
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("회사\t 부서별\t 급여현황");
			System.out.println("---------------------------------------------");
			
			while(rs.next())
			{
				String buseo=rs.getString("buseo");
				String avgpay=rs.getString("avgpay");
				String maxpay=rs.getString("maxpay");
				String minpay=rs.getString("minpay");
				
				System.out.println(buseo+"\t"+avgpay+"\t"+maxpay+"\t"+minpay);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("실패");
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConnectTestEx2 cn2=new ConnectTestEx2();
		//cn2.connectBoardAnswer();
		cn2.connectSawonGroup();
	}

}
