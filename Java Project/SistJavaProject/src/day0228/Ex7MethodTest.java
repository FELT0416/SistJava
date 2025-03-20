package day0228;

class Score{
	private String name;
	private int java;
	private int oracle;
	private int spring;
	public static final String TITLE="중간고사결과";
	
	//setters & getters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getOracle() {
		return oracle;
	}
	public void setOracle(int oracle) {
		this.oracle = oracle;
	}
	public int getSpring() {
		return spring;
	}
	public void setSpring(int spring) {
		this.spring = spring;
	}
	
	//추가..합계
	public int getTot()
	{
		int s=java+oracle+spring;
		return s;
	}
	//평균
	public double getAvg()
	{
		return getTot()/3.0;
	}
	
}

public class Ex7MethodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Score s=new Score();
        s.setName("김민지");
        s.setJava(88);
        s.setOracle(77);
        s.setSpring(74);
        
        int tot=s.getTot();
        double abg=s.getAvg();
        
        System.out.println("[Score클래스 출력]");
        System.out.println(Score.TITLE);
        System.out.println("이름: "+s.getName());
        System.out.println("합계:"+s.getTot());
        System.out.println("평균: "+s.getAvg());
	}

}
