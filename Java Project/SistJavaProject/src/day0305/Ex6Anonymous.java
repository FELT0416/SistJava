package day0305;

abstract class AbstEx{
	
	abstract public void show();
}

///////////////////
class OuterEx{
	
	AbstEx ab=new AbstEx() {
		
		@Override
		public void show() {
			// TODO Auto-generated method stub
			System.out.println("익명내부클래스");
			
		}
	};
}
//////////////////////
public class Ex6Anonymous {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OuterEx ex=new OuterEx();
		ex.ab.show();
	}

}
