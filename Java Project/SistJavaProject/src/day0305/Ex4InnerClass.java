package day0305;

import day0305.OuterObj.InnerObj;

class OuterObj{
	
	
	class InnerObj{
		
		public void write()
		{
			System.out.println("내부클래스의 메서드");
		}
	}
	
	public void show()
	{
		System.out.println("외부클래스의 메서드");
		System.out.println("외부에서 내부클래스의 메서드 호출");
		
		//내부클래스 객체생성_자기멤버처럼 생성이 자유롭다
		InnerObj inObj=new InnerObj(); 
		inObj.write();
	}
	
}
////////////////////
public class Ex4InnerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//show메서드 호출
		OuterObj outobj=new OuterObj();
		outobj.show();
		System.out.println("============================");
		System.out.println("메인에서 직접 내부클래스 생성은 안되고 외부클래스 통해서만 가능");
		
		OuterObj.InnerObj obj=outobj.new InnerObj();
		obj.write();
		System.out.println("============================");
		
		OuterObj.InnerObj obj2=new OuterObj().new InnerObj();
		obj2.write();
		
		
		
	}

}
