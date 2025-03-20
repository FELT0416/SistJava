package day0227;

public class QuizShopTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QuizShop q1=new QuizShop();
		//QuizShop q2=new QuizShop();
		QuizShop q2=new QuizShop("땅콘잼", 100, 11000);
		
		q1.setIpgoData("사과", 2, 23000);
		//q1.setIpgoData("땅콩잼", 20, 12000);
		
		
		QuizShop.jijum="이마트 강동지점";
		
		q1.getIpgoData();
		//q1.getIpgoData();
		q2.getIpgoData();
		
	}

}
