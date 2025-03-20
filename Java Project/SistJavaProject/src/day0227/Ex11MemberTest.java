package day0227;

public class Ex11MemberTest {

	public static void main(String[] args) {
		// 멤버2명 객체생성후 출력
		Ex11Member mem1=new Ex11Member();
		Ex11Member mem2=new Ex11Member();
		
		
		mem1.setMemberData("김연아", "여자", "서울시 강동구");
		mem2.setMemberData("김영철", "남자", "부산시 해운대구");
		
		Ex11Member.ban="JAVA 4강의장";
		
		mem1.getMemberData();
		mem2.getMemberData();
	}

}
