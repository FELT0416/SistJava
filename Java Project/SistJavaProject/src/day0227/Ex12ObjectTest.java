package day0227;

class Input{
	
	private String irum;
	private String juso;
	private int nai;
	
	//setters & getters
	public String getIrum() {
		return irum;
	}
	public void setIrum(String irum) {
		this.irum = irum;
	}
	public String getJuso() {
		return juso;
	}
	public void setJuso(String juso) {
		this.juso = juso;
	}
	public int getNai() {
		return nai;
	}
	public void setNai(int nai) {
		this.nai = nai;
	}
	
	//3개의 멤버변수를 한꺼번에 변경하는 메소드  setInputDatas
	public void setInputDatas(String irum,String juso,int nai)
	{
		/*this.irum=irum;
		this.juso=juso;
		this.nai=nai;*/
		this.setIrum(irum);
		setJuso(juso);
		setNai(nai);
	}
	
	//3개의 멤버변수값을 한꺼번에 리턴
	public String getInputDatas()

	{
		String s="이름: "+irum+"\n주소: "+juso+"\n나이: "+nai;
		
		return s;
	}
}
////////////////////
public class Ex12ObjectTest {

	public static void main(String[] args) {
		//생성1
		Input ob1=new Input();
		ob1.setIrum("송혜교");
		ob1.setJuso("서울시");
		ob1.setNai(33);
		
		System.out.println("**값출력 하나하나 get메서드로 하기**");
		System.out.println("이름: "+ob1.getIrum());
		System.out.println("주소: "+ob1.getJuso());
		System.out.println("나이: "+ob1.getNai());
		
		//생성2
		Input ob2=new Input();
		
		System.out.println("**값입력도 3개한번에 출력도 3개 한번에 하기**");
		ob2.setInputDatas("김하나", "경기도", 66);
		System.out.println(ob2.getInputDatas());
		
		

	}

}
