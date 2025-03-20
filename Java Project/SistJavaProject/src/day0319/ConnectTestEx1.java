package day0319;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectTestEx1 {

	static final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	public void connectSawon()
	{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select * from sawon order by num"; //사원테이블을 num의 오름차순정렬하여 조회
		
		try {
			conn=DriverManager.getConnection(URL, "angel", "a1234");
			
			System.out.println("오라클서버에 연결성공!!!");
			
			stmt=conn.createStatement();
			
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				//db로부터 데이타 가져오기
				int num=rs.getInt("num"); //1열도 가능
				String name=rs.getString("name");
				String gender=rs.getString("gender");
				String buseo=rs.getString("buseo");
				int pay=rs.getInt("pay");
				
				System.out.println(num+"\t"+name+"\t"+gender+"\t"+buseo+"\t"+pay);
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("오라클서버에 연결실패!!!");
		}finally {
				try {
					if(rs!=null)  rs.close();
					if(stmt!=null) stmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	//회사명의 오름차순 정렬
	public void connectCompany() {
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select * from company order by company_id";
		
		try {
			conn=DriverManager.getConnection(URL, "angel", "a1234");
			
			System.out.println("오라클 계정 연결성공!!");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("**거래처 목록**");
			
			System.out.println("회사아이디\t회사명\t거래처주소\t거래처 전화번호");
			System.out.println("------------------------------------------------");
			while(rs.next())
			{
				int id=rs.getInt(1);//열번호나 라벨가능
				String name=rs.getString(2);
				String addr=rs.getString(3);
				String phone=rs.getString(4);
				
				System.out.println(id+"\t"+name+"\t"+addr+"\t"+phone);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("오라클 계정 연결실패!!");
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectTestEx1 ct=new ConnectTestEx1();
		//ct.connectSawon();
		ct.connectCompany();
	}

}
